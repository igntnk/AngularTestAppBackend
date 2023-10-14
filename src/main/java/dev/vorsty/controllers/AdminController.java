package dev.vorsty.controllers;

import dev.vorsty.db.entities.auth.AuthUserEntity;
import dev.vorsty.repositories.AuthUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("api/admin")
public class AdminController {

    @Autowired
    private AuthUserRepo authUserRepo;

    @GetMapping("users")
    public List<AuthUserEntity> getAllUsers(){
        return authUserRepo.findAll();
    }

    @PostMapping(value = "users", produces = APPLICATION_JSON_VALUE)
    public AuthUserEntity createStudent(@RequestBody AuthUserEntity user){
        return authUserRepo.save(user);
    }

}
