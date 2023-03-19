package com.poalim.hackathon.authme.repository;

import com.poalim.hackathon.authme.dao.NewJwtEntryRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NewJwtEntryRequestRepository extends JpaRepository<NewJwtEntryRequest, Integer> {
        Optional<NewJwtEntryRequest>findByUser(String user);
}
