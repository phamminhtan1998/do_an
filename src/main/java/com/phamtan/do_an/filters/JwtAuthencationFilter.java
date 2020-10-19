package com.phamtan.do_an.filters;

import com.phamtan.do_an.jwt.JwtProvider;
import com.phamtan.do_an.services.CustomerUserDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class JwtAuthencationFilter  extends OncePerRequestFilter {

    @Autowired
    private JwtProvider jwtProvider ;
    @Autowired
    private CustomerUserDetailsService customerUserDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        try{


            HttpServletRequest servletToUse = httpServletRequest ;

                String jwt = getTokenFromRequest(servletToUse);
                if(jwt==null){
                    SecurityContextHolder.clearContext();
                    filterChain.doFilter(httpServletRequest,httpServletResponse);
                }
                /*
                 *  check if has jwt token and is it validated
                 *   get the username from jwt
                 *   Check the user in in the database
                 *   if the user is accepted  set the info security context
                 * */
                if(StringUtils.hasText(jwt)&&jwtProvider.validateJwtToken(jwt)){
                    String username =  jwtProvider.getUsernameFromToken(jwt);
                    UserDetails userDetails = customerUserDetailsService.loadUserByUsername(username);

                    if(userDetails!=null){
                        UsernamePasswordAuthenticationToken authencation = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
// set the user details tho the current request
                        authencation.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
//  get the context  of spring to  set authencation
                        SecurityContextHolder.getContext().setAuthentication(authencation );
                    }
                }
                else{
                    SecurityContextHolder.clearContext();
                }
        }
        catch (Exception e){
            SecurityContextHolder.clearContext();
            e.printStackTrace();
        }
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }

    private String getTokenFromRequest(HttpServletRequest httpServletRequest) {
        String bearerToken = httpServletRequest.getHeader("Authorization");
        if(bearerToken.startsWith("Bearer ")&& StringUtils.hasText(bearerToken)){
            return bearerToken.substring(7);
        }
        return null ;
    }

}
