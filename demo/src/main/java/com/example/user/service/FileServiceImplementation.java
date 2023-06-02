package com.example.user.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.user.modal.FileModal;
import com.example.user.repository.FileRepository;

// @Service annotation is used with classes
// that provide some business functionalities
@Service
public class FileServiceImplementation implements FileService {

  // @Autowired annotation used to inject
  // the object dependency of FileRepository
  @Autowired
  FileRepository fileRepository;

  @Override
  public List<FileModal> getAllFiles() {
    // fetch all the files form database
    return fileRepository.findAll();
  }

  public void saveAllFilesList(List<FileModal> fileList) {
    // Save all the files into database
    for (FileModal fileModal : fileList)
      fileRepository.save(fileModal);
  }
}