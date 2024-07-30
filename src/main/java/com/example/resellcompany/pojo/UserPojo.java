package com.example.resellcompany.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class UserPojo {
    private Integer id;
    private String username;
    private String password;
    private String role;
    private String phone;
    private String email;
    private String address;
}
