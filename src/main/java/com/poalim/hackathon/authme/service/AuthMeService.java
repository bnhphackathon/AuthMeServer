package com.poalim.hackathon.authme.service;

import com.poalim.hackathon.authme.dao.AuthenticateUserRequest;
import com.poalim.hackathon.authme.dao.NewJwtEntryRequest;
import io.jsonwebtoken.lang.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthMeService {

    private final JwtService jwtProduce;
    private final FileCrudService fileCrudService;

    public String insertJwt(NewJwtEntryRequest transactionRequest) {

        String jwt = jwtProduce.newJwt();
        log.info("JWT={}", jwt);
        fileCrudService.insertIntoDB(transactionRequest, jwt);
        log.info("row from db = {}", fileCrudService.findByUser(transactionRequest.getUser()));
        String jwtDec = jwtProduce.decryptJwt(jwt);
//        String word = jwt
        return jwtDec;
    }


    public JwtService getJwtProduce() {
        return jwtProduce;
    }

    public String getOtp(AuthenticateUserRequest authenticateUserRequest) {
        return null;
    }
}
