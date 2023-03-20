package com.poalim.hackathon.authme.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@AllArgsConstructor
@Builder
public class GreenUser {
    Integer id;
    String user;
    String firstName;
    String secondName;
    String squad;
    String tribe;
}
