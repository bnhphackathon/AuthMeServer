package com.poalim.hackathon.authme.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@AllArgsConstructor
@Builder
public class AuthenticateUserResponse {
    Boolean otpAuthenticate;
    String user;
}
