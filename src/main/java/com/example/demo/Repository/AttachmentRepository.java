package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Attachment;

public interface AttachmentRepository extends JpaRepository<Attachment, Integer>{

}
