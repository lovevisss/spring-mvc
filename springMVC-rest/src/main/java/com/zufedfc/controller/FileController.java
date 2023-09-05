package com.zufedfc.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Controller
public class FileController {

    @RequestMapping("/download")
    public ResponseEntity<byte[]>  download(HttpSession session) throws IOException {
        ServletContext servletContext = session.getServletContext();
        String realPath = servletContext.getRealPath("/static/img/1.jpg");
        System.out.println(realPath);

        InputStream resourceAsStream = Files.newInputStream(Paths.get(realPath));
        byte[] bytes = new byte[resourceAsStream.available()];
        resourceAsStream.read(bytes);

        MultiValueMap<String,String> headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment;filename=1.jpg");

        HttpStatus statusCode = HttpStatus.OK;

        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers, statusCode);
        resourceAsStream.close();


        return responseEntity;

    }

    @RequestMapping("/upload")
    public String upload(MultipartFile photo, HttpSession session) throws IOException {
        ServletContext servletContext = session.getServletContext();
        String realPath = servletContext.getRealPath("photo");
        File file = new File(realPath);

        if(!file.exists()){
            file.mkdirs();
        }
        String filename = photo.getOriginalFilename();
        System.out.println(photo.getOriginalFilename());
        String suffix = filename.substring(filename.lastIndexOf(".") + 1);
        String prefix = filename.substring(0, filename.lastIndexOf("."));
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        String newFileName = uuid + "." + suffix;
        photo.transferTo(new File(file,newFileName));
        return "success";
    }
}
