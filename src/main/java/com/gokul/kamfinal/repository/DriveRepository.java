package com.gokul.kamfinal.repository;

import com.gokul.kamfinal.model.DriveInstance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriveRepository extends JpaRepository<DriveInstance,Long> {
}
