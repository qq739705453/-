package com.yj.wl.controller;


import com.yj.wl.entity.Ajax;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;
import java.io.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/FileUploads")
public class FileUpload {


    @PostMapping("/upload")
    public Ajax upload(@RequestParam(value = "file") MultipartFile file, Model model, HttpServletRequest request){
        if (file.isEmpty()) {
            System.out.println("文件为空空");
        }
        String fileName = file.getOriginalFilename();  // 文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
        String filePath = "D://temp-rainy//"; // 上传后的路径
        String filepath= "";
        fileName = UUID.randomUUID() + suffixName; // 新文件名
    }
}
