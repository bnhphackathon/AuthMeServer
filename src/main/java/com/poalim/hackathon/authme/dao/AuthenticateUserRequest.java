package com.poalim.hackathon.authme.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
@AllArgsConstructor
public class AuthenticateUserRequest {
    String otp;
    String user;
}
