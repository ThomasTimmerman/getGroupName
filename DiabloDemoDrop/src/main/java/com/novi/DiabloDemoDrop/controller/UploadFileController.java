package com.novi.DiabloDemoDrop.controller;

import com.novi.DiabloDemoDrop.model.FileModel;
import com.novi.DiabloDemoDrop.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

//SOURCE: https://grokonez.com/frontend/angular/angular-6/angular-6-client-upload-files-download-files-to-mysql-with-springboot-restapis
//@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UploadFileController {

    @Autowired
    FileRepository fileRepository;

    /*
     * MultipartFile Upload
     */
    @PostMapping("/api/file/upload")
    public String uploadMultipartFile(@RequestParam("file") MultipartFile file) {
        try {
            // save file to MySQL
            FileModel filemode = new FileModel(file.getOriginalFilename(), file.getContentType(), file.getBytes());
            fileRepository.save(filemode);
            return "File uploaded successfully! -> filename = " + file.getOriginalFilename();
        } catch (Exception e) {
            return "FAIL! Maybe You had uploaded the file before or the file's size > 15MB";
        }
    }
}
