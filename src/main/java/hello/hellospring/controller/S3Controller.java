package hello.hellospring.controller;

import hello.hellospring.service.S3Uploader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
@Slf4j
public class S3Controller {

    private final S3Uploader s3Uploader;

    @PostMapping("/images")
    public String upload(@RequestParam("images")MultipartFile multipartFile) throws IOException {
        System.out.println("test_controller");
        log.info("controller_start_log");
        s3Uploader.upload(multipartFile, "static");
        return "test";
    }
}
