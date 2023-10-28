package com.vorstu.AngularSecurity.config;

import com.vorstu.AngularSecurity.db.entities.auth.AuthUserEntity;
import com.vorstu.AngularSecurity.db.entities.auth.BaseRole;
import com.vorstu.AngularSecurity.db.entities.auth.RoleUserEntity;
import com.vorstu.AngularSecurity.db.repositories.AuthUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class Initializer implements CommandLineRunner {
    @Autowired
    private AuthUserRepo authUserRepo;

    @Override
    public void run(String... args){
        AuthUserEntity admin = new AuthUserEntity(true, "admin", "1234","Ilya","Ignatenko",
                Collections.singleton(new RoleUserEntity("admin", BaseRole.SUPER_USER))
        );

        authUserRepo.save(admin);

        AuthUserEntity user1 = new AuthUserEntity(true, "user1", "12345","Daniil","Svinoukhov",
                Collections.singleton(new RoleUserEntity("user1", BaseRole.STUDENT))
        );

        authUserRepo.save(user1);

        AuthUserEntity user2 = new AuthUserEntity(true, "user2", "123456","Daniil","Kabirov",
                Collections.singleton(new RoleUserEntity("user2", BaseRole.STUDENT))
        );

        authUserRepo.save(user2);

        AuthUserEntity user3 = new AuthUserEntity(true, "user3", "123456","Daniil","Kabirov",
                Collections.singleton(new RoleUserEntity("user2", BaseRole.STUDENT))
        );

        authUserRepo.save(user3);

        authUserRepo.save(new AuthUserEntity(true, "user4", "123456","Daniil","Kabirov",
                Collections.singleton(new RoleUserEntity("user2", BaseRole.STUDENT))
        ));
        authUserRepo.save(new AuthUserEntity(true, "user5", "123456","Daniil","Kabirov",
                Collections.singleton(new RoleUserEntity("user2", BaseRole.STUDENT))
        ));
        authUserRepo.save(new AuthUserEntity(true, "user6", "123456","Daniil","Kabirov",
                Collections.singleton(new RoleUserEntity("user2", BaseRole.STUDENT))
        ));
        authUserRepo.save(new AuthUserEntity(true, "user7", "123456","Daniil","Kabirov",
                Collections.singleton(new RoleUserEntity("user2", BaseRole.STUDENT))
        ));
        authUserRepo.save(new AuthUserEntity(true, "user8", "123456","Daniil","Kabirov",
                Collections.singleton(new RoleUserEntity("user2", BaseRole.STUDENT))
        ));
    }
}
