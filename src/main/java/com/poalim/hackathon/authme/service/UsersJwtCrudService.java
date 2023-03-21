package com.poalim.hackathon.authme.service;
import com.poalim.hackathon.authme.dao.GreenUser;
import com.poalim.hackathon.authme.dao.NewJwtEntryRequest;
import com.poalim.hackathon.authme.dao.OtpJwtforUsers;
import com.poalim.hackathon.authme.repository.UsersJwtRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsersJwtCrudService {

    private final UsersJwtRepository usersJwtRepository;

    public  String insertIntoDB(NewJwtEntryRequest newJwtEntry, String jwt) {

        OtpJwtforUsers otpJwtforUsers = findByUser(newJwtEntry.getUser());
        if (Objects.isNull(otpJwtforUsers)){
            usersJwtRepository.save(OtpJwtforUsers.builder()
                    .firstName(newJwtEntry.getFirstName())
                    .jwt(jwt)
                    .isGreen(false)
                    .user(newJwtEntry.getUser())
                    .lastName(newJwtEntry.getLastName())
                    .squad(newJwtEntry.getSquad())
                    .tribe(newJwtEntry.getTribe())
                    .build());
        } else {
            otpJwtforUsers.setJwt(jwt);
            usersJwtRepository.save(otpJwtforUsers);
        }


        return jwt;
    }

    public OtpJwtforUsers findByUser(String user) {

        Optional<OtpJwtforUsers> jwtEntryOpt = usersJwtRepository.findByUser(user);
        if (!jwtEntryOpt.isPresent()){
            return null;
        }
        return jwtEntryOpt.get();

    }


    public void saveUser(OtpJwtforUsers otpJwtforUsers) {
        usersJwtRepository.save(otpJwtforUsers);

    }

    public List<OtpJwtforUsers> getGreenUsersList() {
        return usersJwtRepository.findAll();
//        return usersJwtRepository.findByIsGreen(true);
    }
}


