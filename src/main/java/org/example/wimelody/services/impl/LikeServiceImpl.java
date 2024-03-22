package org.example.wimelody.services.impl;

import lombok.AllArgsConstructor;
import org.example.wimelody.audit.SpringSecurityAuditAwareImpl;
import org.example.wimelody.dto.like.LikeDtoReq;
import org.example.wimelody.dto.like.LikeDtoRsp;
import org.example.wimelody.entities.DBUser;
import org.example.wimelody.entities.Like;
import org.example.wimelody.entities.Pack;
import org.example.wimelody.exceptions.NotFoundEx;
import org.example.wimelody.repositories.DBUserRepository;
import org.example.wimelody.repositories.LikeRepository;
import org.example.wimelody.repositories.PackRepository;
import org.example.wimelody.services.inter.LikeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LikeServiceImpl implements LikeService {

    private final LikeRepository likeRepository;

    private final ModelMapper modelMapper;

    private final PackRepository packRepository;

    private final DBUserRepository userRepository;

    private final SpringSecurityAuditAwareImpl springSecurityAuditAware;

    @Override
    public LikeDtoRsp save(LikeDtoReq dtoMini) {
        Pack pack = packRepository.findById(dtoMini.getPack_id()).orElseThrow(() -> new NotFoundEx("Pack not found"));
        Like like = modelMapper.map(dtoMini, Like.class);
        like.setPack(pack);
        like.setFan(springSecurityAuditAware.getCurrentAuditor());
        if (likeRepository.existsByFanIdAndPackId(springSecurityAuditAware.getCurrentAuditor().getId(), pack.getId())) {
            likeRepository.delete(likeRepository.findByFanIdAndPackId(springSecurityAuditAware.getCurrentAuditor().getId(), pack.getId()));
        } else {
            like = likeRepository.save(like);
        }
        return modelMapper.map(like, LikeDtoRsp.class);
    }

    @Override
    public LikeDtoRsp update(LikeDtoReq dtoMini, Long f) {
        Pack pack = packRepository.findById(dtoMini.getPack_id()).orElseThrow(() -> new NotFoundEx("Pack not found"));
        DBUser user = userRepository.findById(dtoMini.getFan_id()).orElseThrow(() -> new NotFoundEx("User not found"));
        likeRepository.findById(f).orElseThrow(() -> new NotFoundEx("Like not found"));
        Like like = modelMapper.map(dtoMini, Like.class);
        like.setPack(pack);
        like.setFan(user);
        return modelMapper.map(likeRepository.save(like), LikeDtoRsp.class);
    }

    @Override
    public Boolean delete(Long f) {
        likeRepository.findById(f).orElseThrow(() -> new NotFoundEx("Like not found"));
        likeRepository.deleteById(f);
        return true;
    }

    @Override
    public LikeDtoRsp findById(Long f) {
        Like like = likeRepository.findById(f).orElseThrow(() -> new NotFoundEx("Like not found"));
        return modelMapper.map(like, LikeDtoRsp.class);
    }

    @Override
    public List<LikeDtoRsp> findAll() {
        return null;
    }
}
