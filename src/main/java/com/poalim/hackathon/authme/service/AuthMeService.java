package com.poalim.hackathon.authme.service;

import com.poalim.hackathon.authme.dao.*;
import com.poalim.hackathon.authme.dao.Error;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthMeService {

    private final JwtService jwtService;
    private final UsersJwtCrudService crudService;
    private final UsersWhiteListCrudService usersWhiteListCrudService;

    public NewJwtEntryResponse insertJwt(NewJwtEntryRequest newJwtEntryRequest) {

        String jwtDec = null;
        String newJwt;

        if (!usersWhiteListCrudService.isUserInWhiteList(newJwtEntryRequest.getUser()))
            return NewJwtEntryResponse.builder()
                    .error(Error.builder()
                            .message("user:" + newJwtEntryRequest.getUser() + " not exist in white list")
                            .build())
                    .data(null)
                    .build();

        try {
            newJwt = jwtService.getNewJwt();
            log.info("insertJwt: newJWT={}", newJwt);
//            newJwtEntryRequest.setJwt(newJwt);
            crudService.insertIntoDB(newJwtEntryRequest, newJwt);
            jwtDec = jwtService.decryptJwt(newJwt);
        } catch (Exception e) {
            log.error("insertJwt: error={}", e.getMessage());
            return NewJwtEntryResponse.builder()
                    .data(null)
                    .error(Error.builder()
                            .message(e.getMessage())
                            .build())
                    .build();
        }

        return NewJwtEntryResponse.builder()
                .data(NewJwtEntryData.builder()
                        .otp(jwtDec)
                        .user(newJwtEntryRequest.getUser())
                        .build())
                .build();
    }


    public JwtService getJwtService() {
        return jwtService;
    }

    public AuthenticateUserResponse otpAuthenticate(AuthenticateUserRequest authenticateUserRequest) {

        OtpJwtforUsers newJwtEntryRequest = crudService.findByUser(authenticateUserRequest.getUser());
        if (Objects.isNull(newJwtEntryRequest)){
            return null;
        }
        String otpDb = jwtService.decryptJwt(newJwtEntryRequest.getJwt());
        if (otpDb.equals(authenticateUserRequest.getOtp().toString())){
            newJwtEntryRequest.setIsGreen(true);
            crudService.saveUser(newJwtEntryRequest);
            return AuthenticateUserResponse.builder()
                    .otpAuthenticate(true)
                    .user(authenticateUserRequest.getUser())
                    .build();
        } else {
            return AuthenticateUserResponse.builder()
                    .otpAuthenticate(false)
                    .user(authenticateUserRequest.getUser().toUpperCase())
                    .build();
        }
    }

    public GreenUserListResponse getGreenList() {
        List<OtpJwtforUsers> greenUserList = crudService.getGreenUsersList();
        return GreenUserListResponse.builder()
                        .greenUserList(greenUserList)
                                .build();

    }
}
