package org.example.wimelody.services.impl;

import lombok.AllArgsConstructor;
import org.example.wimelody.audit.SpringSecurityAuditAwareImpl;
import org.example.wimelody.entities.DBUser;
import org.example.wimelody.repositories.DBUserRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DbUserServiceImpl {

    private final DBUserRepository dbUserRepository;

    private final SpringSecurityAuditAwareImpl springSecurityAuditAwareImpl;

    public String updatebanner(String banner) {
        DBUser user = springSecurityAuditAwareImpl.getCurrentAuditor();
        user.setBanner(banner);
        dbUserRepository.save(user);
        return banner;
    }

    public String updateprofilePicture(String profilePicture) {
        DBUser user = springSecurityAuditAwareImpl.getCurrentAuditor();
        user.setProfilePicture(profilePicture);
        dbUserRepository.save(user);
        return profilePicture;
    }
}
