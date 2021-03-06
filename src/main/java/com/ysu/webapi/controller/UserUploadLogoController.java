package com.ysu.webapi.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import static com.ysu.webapi.WebapiApplication.*;

@RestController
@RequestMapping(value = "/api/userUploadLogo")
public class UserUploadLogoController {




    @ApiOperation(value = "接受上传图片", notes = "接受上传图片，保存到本地，并返回上传结果")
    @ApiImplicitParam(name = "file", value = "API类详细实体api", required = true, dataType = "MultipartFile")
    @PostMapping("/")
    public String uploadPre(@RequestParam("file") MultipartFile file) {
        System.out.println("接受上传图片");
        String fileName = file.getOriginalFilename();
        if(fileName.indexOf("\\") != -1){
            fileName = fileName.substring(fileName.lastIndexOf("\\"));
        }
        String filePath = userPath;
        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(filePath+fileName);
            out.write(file.getBytes());
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            return "上传失败";
        }
        return "上传成功!";
    }


    @ApiOperation(value = "接受上传图片", notes = "接受上传图片，保存到本地，并返回上传结果")
    @ApiImplicitParam(name = "logo", value = "logo", required = true, dataType = "String")
    @PostMapping("/no")
    public void noUpload(@RequestParam String logo)throws Exception {
        String url1 = logoPath+"logo.png";// 源文件路径
        String url2 = userPath+logo;// 目标路径

        FileInputStream in = new FileInputStream(new File(url1));
        FileOutputStream out = new FileOutputStream(new File(url2));
        byte[] buff = new byte[512];
        int n = 0;
        System.out.println("复制文件：" + "\n" + "源路径：" + url1 + "\n" + "目标路径："
                + url2);
        while ((n = in.read(buff)) != -1) {
            out.write(buff, 0, n);
        }
        out.flush();
        in.close();
        out.close();
        System.out.println("复制完成");
    }

    @ApiOperation(value = "接受上传图片", notes = "接受上传图片，保存到本地，并返回上传结果")
    @ApiImplicitParam(name = "logo", value = "logo", required = true, dataType = "String")
    @PostMapping("/upload")
    public void Upload(@RequestParam String logo)throws Exception {
        String url1 = userPath+logo;// 源文件路径
        String url2 = path+logo;// 目标路径

        FileInputStream in = new FileInputStream(new File(url1));
        FileOutputStream out = new FileOutputStream(new File(url2));
        byte[] buff = new byte[512];
        int n = 0;
        System.out.println("复制文件：" + "\n" + "源路径：" + url1 + "\n" + "目标路径："
                + url2);
        while ((n = in.read(buff)) != -1) {
            out.write(buff, 0, n);
        }
        out.flush();
        in.close();
        out.close();
        System.out.println("复制完成");
    }
}
