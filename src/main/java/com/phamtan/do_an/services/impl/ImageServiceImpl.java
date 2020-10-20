package com.phamtan.do_an.services.impl;

import com.phamtan.do_an.dao.entities.Image;
import com.phamtan.do_an.dao.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ImageServiceImpl {
    @Autowired
    ImageRepository imageRepository ;
    public long uploadImage(Image image ){
        Image image1  = imageRepository.save(image);
        return image1.getId();
    }
    public Image getImageById(long id ){
        Optional<Image> image = imageRepository.findById(id);
        return image.get();
    }
    public Image getImageByName(String name){
        Optional<Image> image = imageRepository.findByName(name);
        return image.get();
    }
}
