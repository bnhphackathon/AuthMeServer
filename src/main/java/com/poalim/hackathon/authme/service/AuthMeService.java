package com.poalim.hackathon.authme.service;

import com.poalim.hackathon.authme.dao.AuthenticateUserRequest;
import com.poalim.hackathon.authme.dao.AuthenticateUserResponse;
import com.poalim.hackathon.authme.dao.NewJwtEntryRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthMeService {

    private final JwtService jwtService;
    private final FileCrudService fileCrudService;

    public String insertJwt(NewJwtEntryRequest newJwtEntryRequest) {

        String jwt = jwtService.newJwt();
        log.info("JWT={}", jwt);
        newJwtEntryRequest.setJwt(jwt);
        fileCrudService.insertIntoDB(newJwtEntryRequest);
        log.info("row from db = {}", fileCrudService.findByUser(newJwtEntryRequest.getUser()));
        String jwtDec = jwtService.decryptJwt(jwt);
//        String word = jwt
        return jwtDec;
    }


    public JwtService getJwtService() {
        return jwtService;
    }

    public AuthenticateUserResponse getOtp(AuthenticateUserRequest authenticateUserRequest) {

        NewJwtEntryRequest newJwtEntryRequest = fileCrudService.findByUser(authenticateUserRequest.getUser());
//        jwtService.decryptJwt(newJwtEntryRequest.)
        return null;
    }
}
