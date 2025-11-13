package com.example.edufythumb.models.dto;

import com.example.edufythumb.models.enums.MediaType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


//ED-245-AWS
public class CreateThumbRecordDTO {

    @NotNull
    private Long mediaId;

    @NotNull
    private MediaType mediaType;

    @NotBlank
    private String mediaName;

    public Long getMediaId() {
        return mediaId;
    }
    public void setMediaId(Long mediaId) {
        this.mediaId = mediaId;
    }
    public MediaType getMediaType() {
        return mediaType;
    }
    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }
    public String getMediaName() {
        return mediaName;
    }
    public void setMediaName(String mediaName) {
        this.mediaName = mediaName;
    }

}
