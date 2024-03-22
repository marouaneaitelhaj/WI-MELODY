package org.example.wimelody.services.impl;

import lombok.AllArgsConstructor;
import org.example.wimelody.audit.SpringSecurityAuditAwareImpl;
import org.example.wimelody.dto.tier.TierDtoReq;
import org.example.wimelody.dto.tier.TierDtoRsp;
import org.example.wimelody.entities.Tier;
import org.example.wimelody.exceptions.AlreadyExistsEx;
import org.example.wimelody.exceptions.NotFoundEx;
import org.example.wimelody.repositories.DBUserRepository;
import org.example.wimelody.repositories.TierRepository;
import org.example.wimelody.services.inter.TierService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class TierServiceImpl implements TierService {

    private final DBUserRepository artistRepository;

    private final TierRepository tierRepository;

    private final ModelMapper modelMapper;

    private final DBUserRepository userRepository;

    private  final SpringSecurityAuditAwareImpl springSecurityAuditAware;

    @Override
    public TierDtoRsp save(TierDtoReq dtoMini) {
        //DBUser artist = artistRepository.findById(dtoMini.getArtist_id())
           //     .orElseThrow(() -> new NotFoundEx("Artist not found"));
        tierRepository.findByPrice(dtoMini.getPrice()).ifPresent(tier -> {
            throw new AlreadyExistsEx("Tier already exists");
        });
        Tier tier = modelMapper.map(dtoMini, Tier.class);
        tier.setArtist(springSecurityAuditAware.getCurrentAuditor());
        return modelMapper.map(tierRepository.save(tier), TierDtoRsp.class);
    }

    @Override
    public TierDtoRsp update(TierDtoReq dtoMini, UUID f) {
        tierRepository.findById(f).orElseThrow(() -> new NotFoundEx("Tier not found"));
        Tier tier = modelMapper.map(dtoMini, Tier.class);
        tier.setArtist(springSecurityAuditAware.getCurrentAuditor());
        tier.setId(f);
        return modelMapper.map(tierRepository.save(tier), TierDtoRsp.class);
    }

    @Override
    public Boolean delete(UUID f) {
        Tier tier = tierRepository.findById(f).orElseThrow(() -> new NotFoundEx("Tier not found"));
        tierRepository.delete(tier);
        return true;
    }

    @Override
    public TierDtoRsp findById(UUID f) {
        return modelMapper.map(tierRepository.findById(f).orElseThrow(() -> new NotFoundEx("Tier not found")), TierDtoRsp.class);
    }

    @Override
    public List<TierDtoRsp> findAll() {
        return tierRepository.findAll().stream().map(tier -> modelMapper.map(tier, TierDtoRsp.class)).toList();
    }
}
