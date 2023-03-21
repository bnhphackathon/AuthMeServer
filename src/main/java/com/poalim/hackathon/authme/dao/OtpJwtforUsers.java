package com.poalim.hackathon.authme.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Table(name = "OtpJwtforUsers")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OtpJwtforUsers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String jwt;
    String user;
    String firstName;
    String lastName;
    String squad;
    String tribe;
    Boolean isGreen;
}
