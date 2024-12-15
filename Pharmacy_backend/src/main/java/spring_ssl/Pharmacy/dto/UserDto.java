package spring_ssl.Pharmacy.dto;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import spring_ssl.Pharmacy.domain.Role;

public class UserDto {

    private String amka;

    private String email;

    private Role role;
}
