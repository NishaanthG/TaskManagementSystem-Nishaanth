package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Model.Attachment;

/**
 * Repository interface for managing Attachment entities.
 * Extends JpaRepository to provide CRUD operations and additional JPA functionalities.
 */
public interface AttachmentRepository extends JpaRepository<Attachment, Integer> {

}

