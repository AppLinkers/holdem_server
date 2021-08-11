package hello.hellospring.controller;

import hello.hellospring.service.S3Uploader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class S3Controller {

//    private final S3Uploader s3Uploader;
//
//    @Autowired
//    public S3Controller(S3Uploader s3Uploader) {
//        this.s3Uploader = s3Uploader;
//    }

    @GetMapping("/image")
    @ResponseBody
    public String imgTest() {
        return "imgTest";
    }

//    @PostMapping("/images")
//    @ResponseBody
//    public String upload(@RequestParam("images")MultipartFile multipartFile) throws IOException {
//        s3Uploader.upload(multipartFile, "static");
//        return "test";
//    }
}
