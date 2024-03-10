package org.example.wimelody.services.impl;

import java.util.List;

import lombok.AllArgsConstructor;
import org.example.wimelody.dto.media.MediaDtoReq;
import org.example.wimelody.dto.media.MediaDtoRsp;
import org.example.wimelody.entities.Media;
import org.example.wimelody.entities.Pack;
import org.example.wimelody.exceptions.NotFoundEx;
import org.example.wimelody.repositories.MediaRepository;
import org.example.wimelody.repositories.PackRepository;
import org.example.wimelody.services.inter.MediaService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MediaServiceImpl implements MediaService {

    private  final MediaRepository mediaRepository;

    private  final PackRepository packRepository;

    private final ModelMapper modelMapper;

    @Override
    public MediaDtoRsp save(MediaDtoReq dtoMini) {
        Pack pack = packRepository.findById(dtoMini.getPack_id()).orElseThrow(() -> new NotFoundEx("Pack not found"));
        Media media = modelMapper.map(dtoMini, Media.class);
        media.setPack(pack);
        return modelMapper.map(mediaRepository.save(media), MediaDtoRsp.class);
    }

    @Override
    public MediaDtoRsp update(MediaDtoReq dtoMini, Long f) {
        Pack pack = packRepository.findById(dtoMini.getPack_id()).orElseThrow(() -> new NotFoundEx("Pack not found"));
        mediaRepository.findById(f).orElseThrow(() -> new NotFoundEx("Media not found"));
        Media media = modelMapper.map(dtoMini, Media.class);
        media.setPack(pack);
        return modelMapper.map(mediaRepository.save(media), MediaDtoRsp.class);
    }

    @Override
    public Boolean delete(Long f) {
        mediaRepository.findById(f).orElseThrow(() -> new NotFoundEx("Media not found"));
        mediaRepository.deleteById(f);
        return true;
    }

    @Override
    public MediaDtoRsp findById(Long f) {
        Media media = mediaRepository.findById(f).orElseThrow(() -> new NotFoundEx("Media not found"));
        return modelMapper.map(media, MediaDtoRsp.class);
    }

    @Override
    public List<MediaDtoRsp> findAll() {
        List<Media> media = mediaRepository.findAll();
        return media.stream().map(m -> modelMapper.map(m, MediaDtoRsp.class)).toList();
    }

    @Override
    public List<MediaDtoRsp> findAllByPack(Long id) {
        Pack pack = packRepository.findById(id).orElseThrow(() -> new NotFoundEx("Pack not found"));
        return mediaRepository.findAllByPack(pack).stream().map(m -> modelMapper.map(m, MediaDtoRsp.class)).toList();
    }

    @Override
    public List<MediaDtoRsp> save(List<MediaDtoReq> mediaDtoReq) {
        return mediaDtoReq.stream().map(this::save).toList();
    }
}
