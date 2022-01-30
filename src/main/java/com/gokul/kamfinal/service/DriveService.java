package com.gokul.kamfinal.service;


import com.gokul.kamfinal.model.DriveInstance;
import com.gokul.kamfinal.model.request.DriveInstanceCreateRequest;
import com.gokul.kamfinal.repository.DriveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class DriveService {

    private final DriveRepository driveRepository;
    public DriveInstance createDriveInstance(DriveInstanceCreateRequest driveInstanceCreateRequest){
        DriveInstance driveInstance=new DriveInstance();

        String username= (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(driveInstanceCreateRequest.getXAxis());


        driveInstance.setXAxis(driveInstanceCreateRequest.getXAxis());
        driveInstance.setYAxis(driveInstanceCreateRequest.getYAxis());
        driveInstance.setInstant(Instant.now());
        driveInstance.setUsername(username);

        return driveRepository.save(driveInstance);
    }
}
