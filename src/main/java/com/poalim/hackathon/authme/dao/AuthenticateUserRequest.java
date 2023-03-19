package com.poalim.hackathon.authme.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@Entity
@AllArgsConstructor
public class AuthenticateUserRequest {
    Integer otp;
    String user;
}
