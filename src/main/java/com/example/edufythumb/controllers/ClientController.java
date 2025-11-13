package com.example.edufythumb.controllers;

import com.example.edufythumb.models.dto.ThumbDTO;
import com.example.edufythumb.services.ThumbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//ED-217-SA
@RestController
@RequestMapping("/thumb")
public class ClientController {

    private final ThumbService thumbService;

    //ED-217-SA
    @Autowired
    public ClientController(ThumbService thumbService) {
        this.thumbService = thumbService;
    }

    //ED-217-SA
    @GetMapping("/thumbs-media")
    public ResponseEntity<ThumbDTO> getThumbOnMedia(@RequestParam String media, @RequestParam Long mediaId){
        return ResponseEntity.ok(thumbService.getThumbByMediaAndId(media, mediaId));
    }
}
