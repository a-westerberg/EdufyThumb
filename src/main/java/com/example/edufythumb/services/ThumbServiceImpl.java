package com.example.edufythumb.services;

import com.example.edufythumb.exceptions.ResourceNotFoundException;
import com.example.edufythumb.models.dto.ThumbDTO;
import com.example.edufythumb.models.dto.mappers.ThumbMapper;
import com.example.edufythumb.models.entities.Thumb;
import com.example.edufythumb.models.enums.MediaType;
import com.example.edufythumb.repositories.ThumbRepository;
import com.example.edufythumb.services.util.ValidateMediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ThumbServiceImpl implements ThumbService {

    private final ThumbRepository thumbRepository;

    @Autowired
    public ThumbServiceImpl(ThumbRepository thumbRepository) {
        this.thumbRepository = thumbRepository;
    }

    //ED-217-SA
    @Override
    public ThumbDTO getThumbByMediaAndId(String media, Long mediaId) {

        MediaType mediaType = ValidateMediaType.getMediaType(media);

        Thumb findThumb = thumbRepository.findByMediaTypeAndMediaId(mediaType, mediaId);

        if(findThumb==null) {
            throw new ResourceNotFoundException("Thumb", "media type", "id", mediaType, mediaId);
        }

        return ThumbMapper.toDTOFull(findThumb);
    }

    //ED-98-AA
    @Override
    public List<ThumbDTO> getThumbsUpFilteredListByMediaType(MediaType mediaType) {
        List<Thumb> filteredListByThumbsUp = thumbRepository.findByMediaTypeOrderByThumbsUpDesc(mediaType);
        return filteredListByThumbsUp.stream().map(ThumbMapper::toDTOThumbsUp).collect(Collectors.toList());
    }

    //ED-99-AA
    @Override
    public List<ThumbDTO> getThumbsDownFilteredListByMediaType(MediaType mediaType) {
        List<Thumb> filteredListByThumbsDown = thumbRepository.findByMediaTypeOrderByThumbsDownDesc(mediaType);
        return filteredListByThumbsDown.stream().map(ThumbMapper::toDTOThumbsDown).collect(Collectors.toList());
    }

    //ED-104-AA
    @Override
    public List<ThumbDTO> getMediaByThumbsUpAndUserId(MediaType mediaType, Long userId) {
        List<Thumb> mediaByThumbsUpAndUser = thumbRepository.findAllByUserVotedUpAndMediaType(userId, mediaType);
        return mediaByThumbsUpAndUser.stream().map(ThumbMapper::toDTOMediaIdAndMediaType).collect(Collectors.toList());
    }
}
