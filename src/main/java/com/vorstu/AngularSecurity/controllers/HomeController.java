package com.vorstu.AngularSecurity.controllers;

import com.vorstu.AngularSecurity.db.dto.ShortUser;
import com.vorstu.AngularSecurity.db.entities.auth.BaseRole;
import com.vorstu.AngularSecurity.db.repositories.AuthUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/home")
public class HomeController {
    @Autowired
    private AuthUserRepo authUserRepo;

    @GetMapping("users")
    public Set<ShortUser> getAllUsers() {
        return authUserRepo.findAll().stream()
                .filter(el -> el.getRoles().stream().anyMatch(role ->
                        !role.getRole().equals(BaseRole.SUPER_USER)))
                .map(el -> new ShortUser(el.getId(), el.getName(),el.getSurname()))
                .collect(Collectors.toSet());
    }

}
