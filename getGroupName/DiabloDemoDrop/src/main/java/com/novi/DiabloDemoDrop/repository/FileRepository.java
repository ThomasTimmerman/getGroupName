package com.novi.DiabloDemoDrop.repository;

import com.novi.DiabloDemoDrop.model.FileModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;



@Transactional
public interface FileRepository extends JpaRepository<FileModel, Long>{	
}