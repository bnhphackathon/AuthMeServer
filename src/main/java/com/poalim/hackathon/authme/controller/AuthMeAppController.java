package com.poalim.hackathon.authme.controller;

import com.poalim.hackathon.authme.dao.NewJwtEntryRequest;
import com.poalim.hackathon.authme.service.AuthMeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authMe/v1")
@AllArgsConstructor
public class AuthMeAppController {

    private final AuthMeService authMeService;

    @PostMapping("/insert-jwt")
    public ResponseEntity<String> insert(@RequestBody NewJwtEntryRequest newJwtEntryRequest) {

        return new ResponseEntity<>( authMeService.insert(newJwtEntryRequest), HttpStatus.OK);

    }

    @PostMapping("/authenticate-user")
    public ResponseEntity<String> authenticateUser(@RequestBody NewJwtEntryRequest newJwtEntryRequest) {

        return new ResponseEntity<>( authMeService.insert(newJwtEntryRequest), HttpStatus.OK);

    }

}

