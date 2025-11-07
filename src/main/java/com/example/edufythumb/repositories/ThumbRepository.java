package com.example.edufythumb.repositories;

import com.example.edufythumb.models.entities.Thumb;
import com.example.edufythumb.models.enums.MediaType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



import java.util.List;


@Repository
public interface ThumbRepository extends JpaRepository<Thumb, Long> {
    Thumb findByMediaTypeAndMediaId(MediaType mediaType, Long mediaId);//ED-217-SA

    //List<Thumb> findByMediaTypeOrderByThumbsUpDesc(MediaType mediaType); //ED-98-AA

    List<Thumb> findByMediaTypeOrderByThumbsDownDesc(MediaType mediaType); //ED-99-AA

    //ED-104-AA
    @Query("SELECT t FROM Thumb t WHERE t.mediaType = :mediaType ORDER BY SIZE(t.userIdVotedUp) DESC")
    List<Thumb> findByMediaTypeOrderByThumbsUpDesc(@Param("mediaType") MediaType mediaType);

/*    @Query("SELECT t FROM Thumb t WHERE t.mediaType = :mediaType ORDER BY SIZE(t.userIdVotedDown) DESC")
    List<Thumb> findByMediaTypeOrderByThumbsDownDesc(@Param("mediaType") MediaType mediaType);*/



    //ED-104-AA
    @Query("SELECT t FROM Thumb t WHERE :userId MEMBER OF t.userIdVotedUp AND t.mediaType = :mediaType")
    List<Thumb> findAllByUserVotedUpAndMediaType(@Param("userId") Long userId, @Param("mediaType") MediaType mediaType);

}
