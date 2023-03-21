package com.poalim.hackathon.authme.repository;

import com.poalim.hackathon.authme.dao.GreenUser;
import com.poalim.hackathon.authme.dao.OtpJwtforUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersJwtRepository extends JpaRepository<OtpJwtforUsers, Integer> {
        Optional<OtpJwtforUsers>findByUser(String user);
        List<OtpJwtforUsers> findByIsGreen(Boolean isGreen);
}
