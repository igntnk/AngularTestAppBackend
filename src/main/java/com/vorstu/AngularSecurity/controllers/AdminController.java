package com.vorstu.AngularSecurity.controllers;

import com.vorstu.AngularSecurity.db.entities.auth.AuthUserEntity;
import com.vorstu.AngularSecurity.db.repositories.AuthUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/admin")
public class AdminController {

    @Autowired
    private AuthUserRepo authUserRepo;

    @GetMapping("users/{pageIndex}/{pageSize}/{filterData}")
    public Page<AuthUserEntity> getFilteredData(@PathVariable("pageIndex")int pageIndex,
                                                @PathVariable("pageSize")int pageSize,
                                                @PathVariable("filterData")String data){
        if(data.equals("$empty")){data = "";}
        Page<AuthUserEntity> test  = authUserRepo.findWithFilter(PageRequest.of(pageIndex,pageSize,Sort.by("user_id")), '%'+data+'%');
        return authUserRepo.findWithFilter(PageRequest.of(pageIndex,pageSize,Sort.by("user_id")), '%'+data+'%');
    }

//    @PostMapping(value="users", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    public AuthUserEntity createStudent(@RequestBody AuthUserEntity user){
//        user.setEnabled(true);
//        return authUserRepo.save(user);
//    }

//    @PutMapping(value = "users", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    public ResponseEntity<AuthUserEntity> editStudent(@RequestBody AuthUserEntity updatedUser){
//        return editUser(updatedUser);
//    }

    @DeleteMapping(value = "users/{id}")
    public int deleteStudent(@PathVariable("id")Long id){
        return authUserRepo.deleteUser(id);
    }

//    private ResponseEntity<AuthUserEntity> editUser(AuthUserEntity user){
//        if(user.getId() == 0){
//            throw new RuntimeException("id of editing user cannot be null");
//        }
//        AuthUserEntity changed = authUserRepo.findAll().stream().
//                filter(el -> el.getId().equals(user.getId())).
//                findFirst().orElseThrow(()->new RuntimeException("user with id: " + user.getId() + "not found"));
//        changed.setName(user.getName());
//        changed.setSurname(user.getSurname());
//        authUserRepo.save(changed);
//
//        return ResponseEntity.ok(changed);
//    }

//    private Long deleteUser(Long id){
//        authUserRepo.deleteById(id);
//        return id;
//    }
}
