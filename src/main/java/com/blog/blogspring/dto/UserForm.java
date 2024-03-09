package com.blog.blogspring.dto;

import lombok.*;
@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserForm {

    private String email;
    private String password;
    private String firstname;
    private String lastname;
}
