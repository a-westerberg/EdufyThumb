package com.example.edufythumb.models.entities;


import com.example.edufythumb.models.enums.MediaType;
import jakarta.persistence.*;

// ED-173-AWS
@Entity
@Table(
        name = "thumb",
        uniqueConstraints = {
                @UniqueConstraint(name = "uq_thumb_media", columnNames = {"media_type", "media_id"})
        }
)
public class Thumb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "media_name", nullable = false, length = 100)
    private String mediaName;

    @Enumerated(EnumType.STRING)
    @Column(name = "media_type", nullable = false, length = 50)
    private MediaType mediaType;
// ED-176-AWS
    @Column(name = "media_id", nullable = false)
    private Long mediaId;

    @Column(name = "thumbs_up", nullable = false)
    private Long thumbsUp = 0L;

    @Column(name = "thumbs_down", nullable = false)
    private Long thumbsDown = 0L;

    public Thumb() {
    }

    public Thumb(String mediaName, MediaType mediaType, Long mediaId) {
        this.mediaName = mediaName;
        this.mediaType = mediaType;
        this.mediaId = mediaId;
    }

    public Thumb(String mediaName, MediaType mediaType, Long mediaId, Long thumbsUp, Long thumbsDown) {
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

// Increases thumbs up count by one
    public void addThumbUp(){
        this.thumbsUp++;
    }

// Increases thumbs down count by one
    public void addThumbDown(){
        this.thumbsDown++;
    }

    @Override
    public String toString() {
        return "Thumb{" +
                "id=" + id +
                ", mediaName='" + mediaName + '\'' +
                ", mediaType=" + mediaType +
                ", mediaId=" + mediaId +
                ", thumbsUp=" + thumbsUp +
                ", thumbsDown=" + thumbsDown +
                '}';
    }
}
