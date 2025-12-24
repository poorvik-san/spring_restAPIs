package com.proto.setapi.setapi.controller;
import lombok.RequiredArgsConstructor;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class Home {

    @GetMapping()
    public String hello(OAuth2AuthenticationToken token) {
        return "Hello from user "+token.getName()+token.getPrincipal().getAttribute("email");
    }

    
}
