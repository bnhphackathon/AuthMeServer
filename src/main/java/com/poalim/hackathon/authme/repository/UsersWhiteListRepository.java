package com.poalim.hackathon.authme.repository;

import com.poalim.hackathon.authme.dao.NewJwtEntryRequest;
import com.poalim.hackathon.authme.dao.UsersWhiteList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersWhiteListRepository extends JpaRepository<UsersWhiteList, Integer> {
        Optional<UsersWhiteList>findByUser(String user);
}
