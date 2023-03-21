package com.poalim.hackathon.authme.controller;

import com.poalim.hackathon.authme.dao.*;
import com.poalim.hackathon.authme.service.AuthMeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/authMe/v1")
@AllArgsConstructor
@Slf4j
public class AuthMeAppController {

    private final AuthMeService authMeService;

    @PostMapping("/insert-jwt")
    public ResponseEntity<NewJwtEntryResponse> insertJwt(@RequestBody NewJwtEntryRequest newJwtEntryRequest) {

        NewJwtEntryResponse response = authMeService.insertJwt(newJwtEntryRequest);
        if (Objects.isNull(response.getData())){
            log.error("ERROR in insertJwt: ", response.getError().getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR );
        }
        return new ResponseEntity<>(response, HttpStatus.OK );
    }

    @GetMapping("/authenticate-user")
    public ResponseEntity<AuthenticateUserResponse> authenticateUser(@RequestHeader("userId") String userId,
                                                                     @RequestHeader("otp") String otp) {
        return new ResponseEntity<AuthenticateUserResponse>( authMeService.otpAuthenticate(AuthenticateUserRequest.builder()
                        .user(userId)
                        .otp(otp)
                .build()), HttpStatus.OK);

    }

    @GetMapping("/green-list")
    public ResponseEntity<GreenUserListResponse> getGreenList() {

        GreenUserListResponse greenUserListResponse = authMeService.getGreenList();
        return new ResponseEntity<>(greenUserListResponse, HttpStatus.OK );

    }

}

