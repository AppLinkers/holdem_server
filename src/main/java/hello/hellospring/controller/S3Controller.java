package hello.hellospring.controller;

import hello.hellospring.service.S3Uploader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequiredArgsConstructor
@Controller
public class S3Controller {

    private final S3Uploader s3Uploader;

    @GetMapping("/image")
    public String imgTest() {
        return "imgTest";
    }

    @PostMapping("/images")
    @ResponseBody
    public String upload(@RequestParam("images")MultipartFile multipartFile) throws IOException {
        s3Uploader.upload(multipartFile, "static");
        return "test";
    }
}
