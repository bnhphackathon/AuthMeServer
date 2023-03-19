package com.poalim.hackathon.authme.service;

import com.poalim.hackathon.authme.dao.NewJwtEntryRequest;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthMeService {

    private final JwtService jwtProduce;
    private final FileCrudService fileCrudService;

    public String insert(NewJwtEntryRequest transactionRequest) {

        String jwt = jwtProduce.newJwt();
        log.info("JWT={}", jwt);
        fileCrudService.insertIntoDB(transactionRequest.getUser(), jwt);
        return jwt;
    }


    public JwtService getJwtProduce() {
        return jwtProduce;
    }
}
