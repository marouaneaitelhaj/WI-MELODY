package org.example.wimelody.services.impl;

import lombok.AllArgsConstructor;
import org.example.wimelody.audit.SpringSecurityAuditAwareImpl;
import org.example.wimelody.dto.pack.PackDtoReq;
import org.example.wimelody.dto.pack.PackDtoRsp;
import org.example.wimelody.entities.Pack;
import org.example.wimelody.entities.Payment;
import org.example.wimelody.entities.Tier;
import org.example.wimelody.enums.Role;
import org.example.wimelody.exceptions.NotFoundEx;
import org.example.wimelody.repositories.LikeRepository;
import org.example.wimelody.repositories.PackRepository;
import org.example.wimelody.repositories.PaymentRepository;
import org.example.wimelody.repositories.TierRepository;
import org.example.wimelody.services.inter.PackService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class PackServiceImpl implements PackService {

    private final PackRepository packRepository;

    private final PaymentRepository paymentRepository;

    private final LikeRepository likeRepository;

    private final TierRepository tierRepository;

    private  final SpringSecurityAuditAwareImpl springSecurityAuditAware;

    private final ModelMapper modelMapper;

    @Override
    public PackDtoRsp save(PackDtoReq dtoMini) {
        Tier tier = tierRepository.findById(dtoMini.getTier_id()).orElseThrow(() -> new NotFoundEx("Tier not found"));
        Pack pack = modelMapper.map(dtoMini, Pack.class);
        pack.setDate(LocalDateTime.now());
        pack.setTier(tier);
        pack.setArtist(springSecurityAuditAware.getCurrentAuditor());
        pack = packRepository.save(pack);
        return modelMapper.map(pack, PackDtoRsp.class);
    }

    @Override
    public PackDtoRsp update(PackDtoReq dtoMini, Long f) {
        packRepository.findById(f).orElseThrow(() -> new NotFoundEx("Pack not found"));
        Pack pack = modelMapper.map(dtoMini, Pack.class);
        Tier tier = tierRepository.findById(dtoMini.getTier_id()).orElseThrow(() -> new NotFoundEx("Tier not found"));
        pack.setTier(tier);
        pack.setId(f);
        pack.setArtist(springSecurityAuditAware.getCurrentAuditor());
        pack.setDate(LocalDateTime.now());
        pack = packRepository.save(pack);
        return modelMapper.map(pack, PackDtoRsp.class);
    }

    @Override
    public Boolean delete(Long f) {
        Pack pack = packRepository.findById(f).orElseThrow(() -> new NotFoundEx("Pack not found"));
        packRepository.delete(pack);
        return true;
    }

    @Override
    public PackDtoRsp findById(Long f) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findOne'");
    }


    @Override
    public List<PackDtoRsp> findAll() {
        List<Pack> packs = null;
        if (springSecurityAuditAware.getCurrentAuditor().getRole() == Role.FAN) {
            packs = packRepository.findAllByFanId(springSecurityAuditAware.getCurrentAuditor().getId());
        } else if (springSecurityAuditAware.getCurrentAuditor().getRole() == Role.ARTIST) {
            packs = packRepository.findAllByTierArtistId(springSecurityAuditAware.getCurrentAuditor().getId());
        }
        assert packs != null;
        return packs.stream().map(pack -> modelMapper.map(pack, PackDtoRsp.class)).toList();
    }

    @Override
    public List<PackDtoRsp> findAllByTier(UUID id) {
        Tier tier = tierRepository.findById(id).orElseThrow(() -> new NotFoundEx("Tier not found"));
        return packRepository.findAllByTierId(id).stream().map(pack -> modelMapper.map(pack, PackDtoRsp.class)).toList();
    }

    @Override
    public List<PackDtoRsp> findAllByArtist(UUID id) {
        List<Payment> payments = paymentRepository.findAllByFanIdAndTierArtistId(springSecurityAuditAware.getCurrentAuditor().getId(), id);
        List<Tier> tiers = payments.stream().map(Payment::getTier).toList();
        List<PackDtoRsp> packDtoRsps = tiers.stream().map(tier -> packRepository.findAllByTierId(tier.getId()).stream().map(pack -> modelMapper.map(pack, PackDtoRsp.class)).toList()).toList().stream().flatMap(List::stream).toList();
        packDtoRsps.forEach(packDtoRsp -> packDtoRsp.setLiked(likeRepository.existsByFanIdAndPackId(springSecurityAuditAware.getCurrentAuditor().getId(), packDtoRsp.getId())));
        return packDtoRsps;
    }
}
