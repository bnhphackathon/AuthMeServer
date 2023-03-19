package com.poalim.hackathon.authme.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@Table(name = "NewJwtEntryRequest")
@Entity
@AllArgsConstructor
public class NewJwtEntryRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String jwt;
    String user;
    String firstName;
    String secondName;
    String squad;
    String tribe;
}
