package com.phamtan.do_an;

import com.phamtan.do_an.entities.AppUser;
import com.phamtan.do_an.repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EnableAutoConfiguration

public class DoAnPtit2020Application implements CommandLineRunner {

	@Autowired
	private AppUserRepository  appUserRepository;

	@Autowired
	 PasswordEncoder bCryPasswordEncoder ;

	public static void main(String[] args) {
		SpringApplication.run(DoAnPtit2020Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		AppUser appUser = new AppUser();
		appUser.setId(1);
		appUser.setUsername("dieulinh");
		appUser.setPassword(bCryPasswordEncoder.encode("a"));
		appUserRepository.save(appUser);
		System.out.println(appUser);
	}
}
