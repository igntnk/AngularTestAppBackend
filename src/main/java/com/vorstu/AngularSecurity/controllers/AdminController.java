package com.vorstu.AngularSecurity.controllers;

import com.vorstu.AngularSecurity.db.dto.ShortUser;
import com.vorstu.AngularSecurity.db.entities.auth.AuthUserEntity;
import com.vorstu.AngularSecurity.db.entities.auth.BaseRole;
import com.vorstu.AngularSecurity.db.repositories.AuthUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/admin")
public class AdminController {
    @Autowired
    private AuthUserRepo authUserRepo;

    @GetMapping("users")
    public Set<ShortUser> getAllUsers() {
        return authUserRepo.findAll().stream()
                .map(el -> new ShortUser(el.getId(), el.getName(),el.getSurname()))
                .collect(Collectors.toSet());
    }

    @PostMapping(value="users", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public AuthUserEntity createStudent(@RequestBody AuthUserEntity user){
        user.setEnabled(true);
        return authUserRepo.save(user);
    }

    @PutMapping(value = "users", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<AuthUserEntity> editStudent(@RequestBody AuthUserEntity updatedUser){
        return editUser(updatedUser);
    }

    @DeleteMapping(value = "users/{id}")
    public Long deleteStudent(@PathVariable("id")Long id){
        return deleteUser(id);
    }

    private ResponseEntity<AuthUserEntity> editUser(AuthUserEntity user){
        if(user.getId() == 0){
            throw new RuntimeException("id of editing user cannot be null");
        }
        AuthUserEntity changed = authUserRepo.findAll().stream().
                filter(el -> el.getId().equals(user.getId())).
                findFirst().orElseThrow(()->new RuntimeException("user with id: " + user.getId() + "not found"));
        changed.setName(user.getName());
        changed.setSurname(user.getSurname());
        authUserRepo.save(changed);

        return ResponseEntity.ok(changed);
    }

    private Long deleteUser(Long id){
        authUserRepo.deleteById(id);
        return id;
    }
}
