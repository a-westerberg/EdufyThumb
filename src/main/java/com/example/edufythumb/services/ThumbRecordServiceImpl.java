package com.example.edufythumb.services;

import com.example.edufythumb.exceptions.BadRequest;
import com.example.edufythumb.models.dto.CreateThumbRecordDTO;
import com.example.edufythumb.models.dto.CreateThumbRecordResponseDTO;
import com.example.edufythumb.models.entities.Thumb;
import com.example.edufythumb.models.enums.MediaType;
import com.example.edufythumb.repositories.ThumbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//ED-245-AWS
@Service
public class ThumbRecordServiceImpl implements ThumbRecordService {

    private final ThumbRepository thumbRepository;

    @Autowired
    public ThumbRecordServiceImpl(ThumbRepository thumbRepository) {
        this.thumbRepository = thumbRepository;
    }

    @Override
    @Transactional
    public CreateThumbRecordResponseDTO createRecordOfMedia(CreateThumbRecordDTO request) {
        Long mediaId = request.getMediaId();
        MediaType mediaType = request.getMediaType();

        if(thumbRepository.existsByMediaIdAndMediaType(mediaId, mediaType)){
            throw new BadRequest("Thumb",
                    "mediaId/mediaType",
                    "record already exists for this media");
        }

        Thumb saved = thumbRepository.save(
                new Thumb(
                    request.getMediaName(),
                    mediaType,
                    mediaId
                )
        );
        return new CreateThumbRecordResponseDTO(
                saved.getId(),
                saved.getMediaId(),
                saved.getMediaType(),
                saved.getMediaName()
        );
    }
}
