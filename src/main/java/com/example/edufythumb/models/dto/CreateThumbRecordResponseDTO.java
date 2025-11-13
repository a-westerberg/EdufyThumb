package com.example.edufythumb.models.dto;

import com.example.edufythumb.models.enums.MediaType;

//ED-245-AWS
public class CreateThumbRecordResponseDTO {

    private final Long id;
    private final Long mediaId;
    private final MediaType mediaType;
    private final String mediaName;

    public CreateThumbRecordResponseDTO(Long id, Long mediaId, MediaType mediaType, String mediaName) {
        this.id = id;
        this.mediaId = mediaId;
        this.mediaType = mediaType;
        this.mediaName = mediaName;
    }

    public Long getId() {
        return id;
    }
    public Long getMediaId() {
        return mediaId;
    }
    public MediaType getMediaType() {
        return mediaType;
    }
    public String getMediaName() {
        return mediaName;
    }
}
