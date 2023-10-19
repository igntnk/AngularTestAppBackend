package dev.vorsty.controllers;

import dev.vorsty.db.entities.auth.AuthUserEntity;
import dev.vorsty.dto.ShortUser;
import dev.vorsty.repositories.AuthUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("api/admin")
public class AdminController {

    @Autowired
    private AuthUserRepo authUserRepo;

    @GetMapping(value = "users")
    public List<ShortUser> getAllUsers(){
        //return authUserRepo.findAll();
        return authUserRepo.findAll().stream().
                map(el->new ShortUser(el.getId(),el.getName(), el.getSurname())).collect(Collectors.toList());
    }

    @PostMapping(value = "users", produces = APPLICATION_JSON_VALUE)
    public AuthUserEntity createStudent(@RequestBody AuthUserEntity user){
        return authUserRepo.save(user);
    }

    @PutMapping(value = "users", produces = APPLICATION_JSON_VALUE)
    public AuthUserEntity editStudent(@RequestBody AuthUserEntity updatedUser){
        return editUser(updatedUser);
    }

    @DeleteMapping(value = "users", produces = APPLICATION_JSON_VALUE)
    public Long deleteStudent(@PathVariable("id")Long id){
        return deleteUser(id);
    }

    private AuthUserEntity editUser(AuthUserEntity user){
        if(user.getId() == 0){
            throw new RuntimeException("id of editing user cannot be null");
        }
        AuthUserEntity changed = authUserRepo.findAll().stream().
                filter(el -> el.getId().equals(user.getId())).
                findFirst().orElseThrow(()->new RuntimeException("user with id: " + user.getId() + "not found"));
        changed = user;
        authUserRepo.save(changed);

        return changed;
    }

    private Long deleteUser(Long id){
        authUserRepo.deleteById(id);
        return id;
    }

}
