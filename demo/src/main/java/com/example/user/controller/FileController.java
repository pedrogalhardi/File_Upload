package com.example.user.controller;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.example.user.modal.FileModal;
import com.example.user.service.FileServiceImplementation;

@Controller
public class FileController {

  @Autowired
  FileServiceImplementation fileServiceImplementation;

  @GetMapping("/")
  public String getData() {
    return "File";
  }

  @PostMapping("/")
  public String uploadMultipartFile(@RequestParam("files") MultipartFile[] files, Model modal) {
    try {

      List<FileModal> fileList = new ArrayList<FileModal>();
      for (MultipartFile file : files) {
        String fileContentType = file.getContentType();
        String sourceFileContent = new String(file.getBytes(), StandardCharsets.UTF_8);
        String fileName = file.getOriginalFilename();
        FileModal fileModal = new FileModal(fileName, sourceFileContent, fileContentType);

        fileList.add(fileModal);
      }

      fileServiceImplementation.saveAllFilesList(fileList);

    } catch (Exception e) {
      e.printStackTrace();
    }

    modal.addAttribute("allFiles", fileServiceImplementation.getAllFiles());

    return "FileList";
  }
}