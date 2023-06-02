package com.example.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.user.modal.FileModal;

public interface FileRepository extends JpaRepository<FileModal, Long> {

}
