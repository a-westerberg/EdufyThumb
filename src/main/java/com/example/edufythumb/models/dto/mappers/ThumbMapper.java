package com.example.edufythumb.models.dto.mappers;

import com.example.edufythumb.models.dto.ThumbDTO;
import com.example.edufythumb.models.entities.Thumb;

//ED-217-SA
public class ThumbMapper {

    //ED-217-SA
    public static ThumbDTO toDTOFull(Thumb thumb) {
        ThumbDTO thumbDTO = new ThumbDTO();
        thumbDTO.setId(thumb.getId());
        thumbDTO.setMediaName(thumb.getMediaName());
        thumbDTO.setMediaType(thumb.getMediaType());
        thumbDTO.setMediaId(thumb.getMediaId());
        thumbDTO.setThumbsUp(thumb.getThumbsUp());
        thumbDTO.setThumbsDown(thumb.getThumbsDown());
        return thumbDTO;
    }

    //ED-217-SA
    public static ThumbDTO toDTOUser(Thumb thumb) {
        ThumbDTO thumbDTO = new ThumbDTO();
        thumbDTO.setMediaName(thumb.getMediaName());
        thumbDTO.setMediaType(thumb.getMediaType());
        thumbDTO.setThumbsUp(thumb.getThumbsUp());
        thumbDTO.setThumbsDown(thumb.getThumbsDown());
        return thumbDTO;
    }
}
