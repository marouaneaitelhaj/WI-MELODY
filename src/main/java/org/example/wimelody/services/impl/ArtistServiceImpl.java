package org.example.wimelody.services.impl;

import lombok.AllArgsConstructor;
import org.example.wimelody.audit.SpringSecurityAuditAwareImpl;
import org.example.wimelody.dto.tier.TierDtoReqWithSubscribed;
import org.example.wimelody.dto.user.UserDtoReq;
import org.example.wimelody.dto.user.UserDtoRsp;
import org.example.wimelody.entities.DBUser;
import org.example.wimelody.entities.Payment;
import org.example.wimelody.enums.Role;
import org.example.wimelody.exceptions.NotFoundEx;
import org.example.wimelody.repositories.DBUserRepository;
import org.example.wimelody.repositories.PaymentRepository;
import org.example.wimelody.services.inter.ArtistService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ArtistServiceImpl implements ArtistService {

    private final DBUserRepository artistRepository;
    private final ModelMapper modelMapper;

    private final PaymentRepository paymentRepository;

    private final SpringSecurityAuditAwareImpl springSecurityAuditAware;

    @Override
    public UserDtoRsp save(UserDtoReq dtoMini) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public UserDtoRsp update(UserDtoReq dtoMini, UUID f) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Boolean delete(UUID f) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }



    @Override
    public UserDtoRsp findById(UUID f) {
        List<Payment> payments = paymentRepository.findAllByFanId(springSecurityAuditAware.getCurrentAuditor().getId());
        List<TierDtoReqWithSubscribed> tiers = payments.stream().map(Payment::getTier).toList().stream().map(tier -> modelMapper.map(tier, TierDtoReqWithSubscribed.class)).toList();
        UserDtoRsp artist = modelMapper.map(artistRepository.findByIdAndRole(f, Role.ARTIST).orElseThrow(() -> new NotFoundEx("Artist Not Found")), UserDtoRsp.class);
        List<TierDtoReqWithSubscribed> tierDtoReqWithSubscribeds = artist.getTiers();
        for (TierDtoReqWithSubscribed tierDtoReqWithSubscribed : tierDtoReqWithSubscribeds) {
            for (TierDtoReqWithSubscribed tier : tiers) {
                if (tierDtoReqWithSubscribed.getId().equals(tier.getId())) {
                    tierDtoReqWithSubscribed.setSubscribed(true);
                }
            }
        }
        return artist;
    }

    @Override
    public List<UserDtoRsp> findAll() {
        return artistRepository.findAllByRole(Role.ARTIST).stream().map(artist -> modelMapper.map(artist, UserDtoRsp.class)).collect(Collectors.toList());
    }

    @Override
    public Page<UserDtoRsp> findAll(Pageable pageable, String text) {
        Page<DBUser> dbUsers = artistRepository.findAllByRoleAndUsernameContainingIgnoreCase(Role.ARTIST, text, pageable);
        return dbUsers.map(dbUser -> modelMapper.map(dbUser, UserDtoRsp.class));
    }
    
}
