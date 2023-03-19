package com.poalim.hackathon.authme.dao;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class AuthenticateUserResponse {
    Boolean otpAuthenticate;
    String user;
}
