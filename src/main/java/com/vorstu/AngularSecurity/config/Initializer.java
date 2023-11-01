package com.vorstu.AngularSecurity.config;

import com.vorstu.AngularSecurity.db.entities.auth.AuthUserEntity;
import com.vorstu.AngularSecurity.db.entities.auth.BaseRole;
import com.vorstu.AngularSecurity.db.entities.auth.RoleUserEntity;
import com.vorstu.AngularSecurity.db.repositories.AuthUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

        for(int c =0;c< 30; c++){
            authUserRepo.save(new AuthUserEntity(true, ("user" + c), "123456",("Daniil"+c),"Kabirov",
                    Collections.singleton(new RoleUserEntity(("user" + c), BaseRole.STUDENT))
            ));
        }

    }
}
