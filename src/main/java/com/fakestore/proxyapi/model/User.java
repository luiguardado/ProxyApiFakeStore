package com.fakestore.proxyapi.model;

import com.fakestore.proxyapi.dto.AddressDTO;
import com.fakestore.proxyapi.dto.NameUserDTO;
import com.fasterxml.jackson.annotation.JsonTypeId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "user_data")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    @Embedded
    private NameUser name;
    private Address addressUser;

    private String phone;

}
