package org.example.wimelody.services.impl;

import lombok.AllArgsConstructor;
import org.example.wimelody.dto.pack.PackDtoReq;
import org.example.wimelody.dto.pack.PackDtoRsp;
import org.example.wimelody.dto.user.UserDtoRsp;
import org.example.wimelody.entities.Pack;
import org.example.wimelody.entities.Payment;
import org.example.wimelody.entities.Tier;
import org.example.wimelody.enums.Role;
import org.example.wimelody.exceptions.NotFoundEx;
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
    private final TierRepository tierRepository;

    private final ModelMapper modelMapper;

    @Override
    public PackDtoRsp save(PackDtoReq dtoMini) {
        Tier tier = tierRepository.findById(dtoMini.getTier_id()).orElseThrow(() -> new NotFoundEx("Tier not found"));
        Pack pack = modelMapper.map(dtoMini, Pack.class);
        pack.setDate(LocalDateTime.now());
        pack.setTier(tier);
        pack = packRepository.save(pack);
        return modelMapper.map(pack, PackDtoRsp.class);
    }

    @Override
    public PackDtoRsp update(PackDtoReq dtoMini, Long f) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Boolean delete(Long f) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public PackDtoRsp findById(Long f) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findOne'");
    }

    @Override
    public List<PackDtoRsp> findAll() {
        return null;
    }

    @Override
    public List<PackDtoRsp> findAll(UserDtoRsp userDtoRsp) {
        List<Pack> packs = null;
        if (userDtoRsp.getRole() == Role.FAN) {
            List<Payment> payments = paymentRepository.findAllByFanId(userDtoRsp.getId());
            List<Tier> tiers = payments.stream().map(Payment::getTier).toList();
            packs = tiers.stream().map(Tier::getPacks).flatMap(List::stream).toList();
        } else if (userDtoRsp.getRole() == Role.ARTIST) {
            packs = packRepository.findAll();
        }
        return packs.stream().map(pack -> modelMapper.map(pack, PackDtoRsp.class)).toList();
    }

    @Override
    public List<PackDtoRsp> findAllByTier(UUID id) {
        Tier tier = tierRepository.findById(id).orElseThrow(() -> new NotFoundEx("Tier not found"));
        return packRepository.findAllByTierId(id).stream().map(pack -> modelMapper.map(pack, PackDtoRsp.class)).toList();
    }
}
