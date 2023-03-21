
package com.poalim.hackathon.authme.service;

import com.poalim.hackathon.authme.dao.UsersWhiteList;
import com.poalim.hackathon.authme.repository.UsersWhiteListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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


