package com.poalim.hackathon.authme.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;


@Data
@Entity
@AllArgsConstructor
public class NewJwtEntryRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String user;
    String firstName;
    String secondName;
    String squad;
    String tribe;
}
