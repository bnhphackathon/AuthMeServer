package com.poalim.hackathon.authme.repository;

import com.poalim.hackathon.authme.dao.NewJwtEntryRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewJwtEntryRequestRepository extends JpaRepository<NewJwtEntryRequest, Long> {
}
