package com.example.edufythumb.services;

import com.example.edufythumb.models.dto.ThumbDTO;
import com.example.edufythumb.models.entities.Thumb;

//ED-217-SA
public interface ThumbService {
    ThumbDTO getThumbByMediaAndId(String media, Long id);//ED-217-SA
}
