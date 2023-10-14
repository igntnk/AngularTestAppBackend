package dev.vorsty.controllers;

import dev.vorsty.db.entities.auth.BaseRole;
import dev.vorsty.dto.ShortUser;
import dev.vorsty.repositories.AuthUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/home")
public class HomeController{
    @Autowired
    private AuthUserRepo authUserRepo;

    @GetMapping("users")
    public List<ShortUser> getAllUsers(){
        return authUserRepo.findAll().stream().filter(el->el.getRoles().stream().anyMatch(role->
                role.getRole().equals(BaseRole.SUPER_USER))).
                map(el->new ShortUser(el.getId(),el.getUsername())).collect(Collectors.toList());
    }
}