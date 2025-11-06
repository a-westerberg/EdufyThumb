package com.example.edufythumb.repositories;

import com.example.edufythumb.models.entities.Thumb;
import com.example.edufythumb.models.enums.MediaType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ThumbRepository extends JpaRepository<Thumb, Long> {
    Thumb findByMediaTypeAndMediaId(MediaType mediaType, Long mediaId);//ED-217-SA

    List<Thumb> findByMediaTypeOrderByThumbsUpDesc(MediaType mediaType); //ED-98-AA
}
