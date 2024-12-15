package spring_ssl.Pharmacy.dto;

import spring_ssl.Pharmacy.domain.User;


public interface UserMapper {

    User fromDto(UserDto dto);

    UserDto toDto(User user);
}
