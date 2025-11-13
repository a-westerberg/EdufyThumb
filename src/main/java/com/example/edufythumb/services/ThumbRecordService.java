package com.example.edufythumb.services;

import com.example.edufythumb.models.dto.CreateThumbRecordDTO;
import com.example.edufythumb.models.dto.CreateThumbRecordResponseDTO;

//ED-245-AWS
public interface ThumbRecordService {

     CreateThumbRecordResponseDTO createRecordOfMedia(CreateThumbRecordDTO request);
}
