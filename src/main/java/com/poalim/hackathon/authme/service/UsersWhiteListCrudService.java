
package com.poalim.hackathon.authme.service;

import com.poalim.hackathon.authme.dao.NewJwtEntryRequest;
import com.poalim.hackathon.authme.dao.UsersWhiteList;
import com.poalim.hackathon.authme.repository.UsersJwtRepository;
import com.poalim.hackathon.authme.repository.UsersWhiteListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsersWhiteListCrudService {

    private final UsersWhiteListRepository usersWhiteListRepository;

    public  Boolean isUserInWhiteList(String user) {

        Optional<UsersWhiteList> userOpt =  usersWhiteListRepository.findByUser(user);
        if (userOpt.isPresent())
            return true;
        else return false;
        }
}


