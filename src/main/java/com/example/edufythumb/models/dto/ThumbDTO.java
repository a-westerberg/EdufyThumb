package com.example.edufythumb.models.dto;

import com.example.edufythumb.models.enums.MediaType;
import com.fasterxml.jackson.annotation.JsonInclude;

//ED-217-SA
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ThumbDTO {
    private Long id;
    private String mediaName;
    private MediaType mediaType;
    private Long mediaId;
    private Long thumbsUp;
    private Long thumbsDown;

    public ThumbDTO() {
    }

    public ThumbDTO(Long id, String mediaName, MediaType mediaType, Long mediaId, Long thumbsUp, Long thumbsDown) {
        this.id = id;
        this.mediaName = mediaName;
        this.mediaType = mediaType;
        this.mediaId = mediaId;
        this.thumbsUp = thumbsUp;
        this.thumbsDown = thumbsDown;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMediaName() {
        return mediaName;
    }

    public void setMediaName(String mediaName) {
        this.mediaName = mediaName;
    }

    public MediaType getMediaType() {
        return mediaType;
    }

    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }

    public Long getMediaId() {
        return mediaId;
    }

    public void setMediaId(Long mediaId) {
        this.mediaId = mediaId;
    }

    public Long getThumbsUp() {
        return thumbsUp;
    }

    public void setThumbsUp(Long thumbsUp) {
        this.thumbsUp = thumbsUp;
    }

    public Long getThumbsDown() {
        return thumbsDown;
    }

    public void setThumbsDown(Long thumbsDown) {
        this.thumbsDown = thumbsDown;
    }

    @Override
    public String toString() {
        return "ThumbDTO{" +
                "id=" + id +
                ", mediaName='" + mediaName + '\'' +
                ", mediaType=" + mediaType +
                ", mediaId=" + mediaId +
                ", thumbsUp=" + thumbsUp +
                ", thumbsDown=" + thumbsDown +
                '}';
    }
}
