package org.example.wimelody.services.impl;

import java.util.List;

import lombok.AllArgsConstructor;
import org.example.wimelody.dto.tier.TierDtoReq;
import org.example.wimelody.dto.tier.TierDtoRsp;
import org.example.wimelody.entities.DBUser;
import org.example.wimelody.entities.Tier;
import org.example.wimelody.exceptions.NotFoundEx;
import org.example.wimelody.repositories.DBUserRepository;
import org.example.wimelody.repositories.TierRepository;
import org.example.wimelody.services.inter.TierService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TierServiceImpl implements TierService {

    private final DBUserRepository artistRepository;

    private final TierRepository tierRepository;

    private final ModelMapper modelMapper;

    @Override
    public TierDtoRsp save(TierDtoReq dtoMini) {
        DBUser artist = artistRepository.findById(dtoMini.getArtist_id())
                .orElseThrow(() -> new NotFoundEx("Artist not found"));
        Tier tier = modelMapper.map(dtoMini, Tier.class);
        tier.setArtist(artist);
        return modelMapper.map(tierRepository.save(tier), TierDtoRsp.class);
    }

    @Override
    public TierDtoRsp update(TierDtoReq dtoMini, Long f) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Boolean delete(Long f) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public TierDtoRsp findById(Long f) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findOne'");
    }

    @Override
    public List<TierDtoRsp> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }
}
