package com.phamtan.do_an.web.image;

import com.phamtan.do_an.dao.entities.Image;
import com.phamtan.do_an.services.impl.ImageServiceImpl;
import com.phamtan.do_an.utils.ImageHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping(value = "/images")
public class ImageController {
    @Autowired
    private ImageServiceImpl imageService ;
    @GetMapping(value = "/{id}")
    public Image getImage(@PathVariable(name = "id") long id ){
       Image image =  imageService.getImageById(id);
        image.setPicByte(ImageHandle.decompressByte(image.getPicByte()));
        return image;
    }
    @GetMapping(value = "/name/{name}")
    public Image getImage(@PathVariable(name = "name") String name ){
        Image image =  imageService.getImageByName(name);
        image.setPicByte(ImageHandle.decompressByte(image.getPicByte()));
        return image;

    }

    @PostMapping()
    public long uploadImage(@RequestParam("imageFile")MultipartFile file )throws IOException{
        System.out.println("Original image byte size "+file.getBytes().length);
        Image image = new Image(0,file.getOriginalFilename(),file.getContentType(),ImageHandle.compressBytes(file.getBytes()));
       long rs = imageService.uploadImage(image);
       return rs;

    }
}
