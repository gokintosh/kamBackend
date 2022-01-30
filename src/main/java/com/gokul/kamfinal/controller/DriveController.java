package com.gokul.kamfinal.controller;


import com.gokul.kamfinal.model.request.DriveInstanceCreateRequest;
import com.gokul.kamfinal.service.DriveService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/drive")
@RequiredArgsConstructor
public class DriveController {

    private final DriveService driveService;

    @PostMapping
    public ResponseEntity createDriveInstance(@RequestBody DriveInstanceCreateRequest driveInstanceCreateRequest){

        return ResponseEntity.ok(driveService.createDriveInstance(driveInstanceCreateRequest));

    }
}
