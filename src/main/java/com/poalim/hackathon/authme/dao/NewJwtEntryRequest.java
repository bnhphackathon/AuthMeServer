package com.poalim.hackathon.authme.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewJwtEntryRequest {

    String user;
    String firstName;
    String lastName;
    String squad;
    String tribe;
    Boolean isGreen;
}
