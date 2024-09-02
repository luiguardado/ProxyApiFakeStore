package com.fakestore.proxyapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long id;
    private String email;
    private String username;
    private String password;
    private NameUserDTO nameUser;
    private AddressDTO address;
    private String phone;

}
