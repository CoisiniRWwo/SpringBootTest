package com.shf.boot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @Author:Su HangFei
 * @Date:2022-12-31 20 38
 * @Project:boot-05-web-admin 文件上传
 */
@Controller
@Slf4j
public class FormTestController {

    @GetMapping("/form_layouts")
    public String from_layouts() {
        return "form/form_layouts";
    }

    //自动封装MultipartFile上传过来的文件
    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestPart("headerImg") MultipartFile headerImg,
                         @RequestPart("photos") MultipartFile[] photos) throws IOException {

        log.info("上传的信息：email={}，username={}，headerImg={}，photos={}",email,username,headerImg.getSize(),photos.length);

        if (!headerImg.isEmpty()){
            //保存到文件服务器，oss服务器
            String originalFilename = headerImg.getOriginalFilename();
            headerImg.transferTo(new File("D:\\Study\\SHFWorkSpace\\boot-05-web-admin\\src\\main\\resources\\static\\headerImg\\"+originalFilename));
        }

        if (photos.length > 0){
            for (MultipartFile photo : photos){
                if (!photo.isEmpty()){
                    String originalFilename = photo.getOriginalFilename();
                    photo.transferTo(new File("D:\\Study\\SHFWorkSpace\\boot-05-web-admin\\src\\main\\resources\\static\\photos\\"+originalFilename));
                }
            }
        }

        return "main";
    }
}
