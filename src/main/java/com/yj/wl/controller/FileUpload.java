package com.yj.wl.controller;


import com.yj.wl.dao.PictureDao;
import com.yj.wl.entity.Ajax;
import com.yj.wl.entity.Picture;
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

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


@Slf4j
@RestController
@RequestMapping("/Journalisms")
public class FileUpload {

    @Resource
    PictureDao pictureDao;


    private String UPLOAD_FOLDER = "D:/test/";

    @PostMapping("/upload")
    public Ajax upload(@RequestParam(name = "file", required = false) MultipartFile file, HttpServletRequest request) {
        if (file == null) {
            System.out.println("请选择要上传的图片");
            return Ajax.error();
        }
        if (file.getSize() > 1024 * 1024 * 10) {
            System.out.println("文件大小不能大于1M");
            return Ajax.error();
        }
        //获取文件后缀
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1, file.getOriginalFilename().length());
        if (!"jpg,jpeg,gif,png".toUpperCase().contains(suffix.toUpperCase())) {
            System.out.println("请选择jpg,jpeg,gif,png格式的图片");
            return Ajax.error();
        }
        String savePath = UPLOAD_FOLDER;
        File savePathFile = new File(savePath);
        if (!savePathFile.exists()) {
            //若不存在该目录，则创建目录
            savePathFile.mkdir();
        }
        //通过UUID生成唯一文件名
        String filename = UUID.randomUUID().toString().replaceAll("-","") + "." + suffix;
        try {
            //将文件保存指定目录
            file.transferTo(new File(savePath + filename));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("保存文件异常");
            return Ajax.error();
        }
        //返回文件名称
        System.out.println(filename);
        System.out.println(request);

        Picture p = new Picture();
        p.setImgName(filename);

        pictureDao.saveJournalism(p);
        return Ajax.success();
    }
}
