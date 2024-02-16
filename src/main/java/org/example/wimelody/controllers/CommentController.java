package org.example.wimelody.controllers;

import org.example.wimelody.dto.comment.CommentDtoReq;
import org.example.wimelody.dto.comment.CommentDtoRsp;
import org.example.wimelody.services.inter.CommentService;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class CommentController  {
    public ResponseEntity<?> save(CommentDtoReq commentDtoReq) {
        return null;
    }

    public ResponseEntity<?> update(CommentDtoReq commentDtoReq, Long aLong) {
        return null;
    }

    public ResponseEntity<?> delete(Long aLong) {
        return null;
    }

    public ResponseEntity<?> findById(Long aLong) {
        return null;
    }

    public List<CommentDtoRsp> findAll() {
        return null;
    }
}
