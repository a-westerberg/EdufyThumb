package com.example.edufythumb.controllers;

import com.example.edufythumb.models.dto.ThumbDTO;
import com.example.edufythumb.models.enums.MediaType;
import com.example.edufythumb.services.ThumbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//ED-217-SA
@RestController
@RequestMapping("/api/v1/thumb")
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

    //ED-98-AA
    @GetMapping("thumbsup-media/{mediaType}")
    public ResponseEntity<List<ThumbDTO>> getThumbsOnMedia(@PathVariable MediaType mediaType){
        return ResponseEntity.ok(thumbService.getThumbsUpFilteredListByMediaType(mediaType));
    }

    //ED-99-AA
    @GetMapping("/thumbsdown-media/{mediaType}")
    public ResponseEntity<List<ThumbDTO>> getThumbsDownMedia(@PathVariable MediaType mediaType){
        return ResponseEntity.ok(thumbService.getThumbsDownFilteredListByMediaType(mediaType));
    }

    //ED-104-AA
    @GetMapping("/thumbsup-media-user/{mediaType}/{userId}")
    public ResponseEntity<List<ThumbDTO>> getMediaByThumbsupAndUserId(@PathVariable MediaType mediaType, @PathVariable Long userId){
        return ResponseEntity.ok(thumbService.getMediaByThumbsUpAndUserId(mediaType, userId));
    }
}
