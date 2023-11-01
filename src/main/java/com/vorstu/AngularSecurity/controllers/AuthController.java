package com.vorstu.AngularSecurity.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    @GetMapping("user")
    @ResponseBody
    public Principal user(Principal user){
        log.warn("getUserAuth: " + (user != null ? user.getName() : "null") );
        return user;
    }

//    @PostMapping(path = "/logout", consumes = "application/json", produces = "applicaton/json")
//    @ResponseBody
//    public Principal logout(Principal user, HttpServletRequest request, HttpServletResponse response) {
//
//        CookieClearingLogoutHandler cookieClearingLogoutHandler = new CookieClearingLogoutHandler(AbstractRememberMeServices.SPRING_SECURITY_REMEMBER_ME_COOKIE_KEY);
//        SecurityContextLogoutHandler securityContextLogoutHandler = new SecurityContextLogoutHandler();
//        cookieClearingLogoutHandler.logout(request, response, null);
//        securityContextLogoutHandler.logout(request, response, null);
//
//        return user;
//    }
}
