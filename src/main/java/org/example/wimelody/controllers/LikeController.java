package org.example.wimelody.controllers;

import org.example.wimelody.dto.like.LikeDtoReq;
import org.example.wimelody.dto.like.LikeDtoRsp;
import org.example.wimelody.services.inter.LikeService;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class LikeController   {
    public ResponseEntity<?> save(LikeDtoReq likeDtoReq) {
        return null;
    }

    public ResponseEntity<?> update(LikeDtoReq likeDtoReq, Long aLong) {
        return null;
    }

    public Boolean delete(Long aLong) {
        return null;
    }

    public ResponseEntity<?> findById(Long aLong) {
        return null;
    }

    public List<LikeDtoRsp> findAll() {
        return null;
    }
}
