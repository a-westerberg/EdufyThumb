package com.example.edufythumb.services;

import com.example.edufythumb.models.dto.ThumbDTO;
import com.example.edufythumb.models.enums.MediaType;

import java.util.List;


//ED-217-SA
public interface ThumbService {
    ThumbDTO getThumbByMediaAndId(String media, Long id);//ED-217-SA

    List<ThumbDTO> getThumbsUpFilteredListByMediaType(MediaType mediaType); //ED-98-AA

    List<ThumbDTO> getThumbsDownFilteredListByMediaType(MediaType mediaType); //ED-99-AA
}
