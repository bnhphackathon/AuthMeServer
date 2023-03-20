package com.poalim.hackathon.authme.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Table(name = "UsersWhiteList")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsersWhiteList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String user;
}
