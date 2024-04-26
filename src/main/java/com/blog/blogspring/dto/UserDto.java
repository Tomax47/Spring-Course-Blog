package com.blog.blogspring.dto;

import com.blog.blogspring.model.User;
import lombok.*;
import java.util.List;
import java.util.stream.Collectors;
@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;
    private String email;
    private String firstname;
    private String lastname;
    private String phoneNumber;

    public static UserDto from(User user) {
        return UserDto.builder()
                .id(user.getId())
                .firstname(user.getFirstName())
                .lastname(user.getLastName())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .build();
    }

    public static List<UserDto> usersList(List<User> users) {
        return users.stream()
                .map(UserDto::from)
                .collect(Collectors.toList());
    }
}
