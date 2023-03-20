package com.poalim.hackathon.authme.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@AllArgsConstructor
@Builder
public class GreenUserListResponse {
    List<GreenUser> greenUserList;
}
