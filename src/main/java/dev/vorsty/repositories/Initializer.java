package dev.vorsty.repositories;

import dev.vorsty.db.entities.auth.AuthUserEntity;
import dev.vorsty.db.entities.auth.BaseRole;
import dev.vorsty.db.entities.auth.RoleUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class Initializer {

    @Autowired
    private AuthUserRepo authUserRepo;

    public void initial() {
        AuthUserEntity admin = new AuthUserEntity(true,"admin","1234",
                Collections.singleton(new RoleUserEntity("admin", BaseRole.SUPER_USER)));

        authUserRepo.save(admin);

        AuthUserEntity user1 = new AuthUserEntity(true,"user1","123456",
                Collections.singleton(new RoleUserEntity("user1", BaseRole.STUDENT)));

        authUserRepo.save(user1);

        AuthUserEntity user2 = new AuthUserEntity(true,"user2","123456",
                Collections.singleton(new RoleUserEntity("user2", BaseRole.STUDENT)));

        authUserRepo.save(user2);

    }
}
