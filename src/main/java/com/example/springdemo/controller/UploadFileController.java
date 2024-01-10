package com.example.springdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class UploadFileController {
    private static final String UPLOAD_PATH =System.getProperty("user.dir")+"/upload";

    @RequestMapping(value="/upload",method = RequestMethod.POST)
    public String uploadFile(String username, MultipartFile file, HttpServletRequest request) throws IOException {
        System.out.println(username);
        System.out.println(file.getOriginalFilename());

        System.out.println(file.getContentType());
        System.out.println(file.getSize());
        System.out.println(UUID.nameUUIDFromBytes(file.getBytes()));
        System.out.println(System.getProperty("user.dir"));

        String path = request.getServletContext().getRealPath("/upload/");
        System.out.println(path);

        saveUploadFile(file, path);
        return "Success";
    }

    public void saveUploadFile(MultipartFile uploadfile, String path) throws IOException{
        File uploadDirectory = new File(path);
        if(!uploadDirectory.exists()){
            uploadDirectory.mkdir();
        }

        File file = new File(path + UUID.nameUUIDFromBytes(uploadfile.getBytes()));
        uploadfile.transferTo(file);
    }
}
