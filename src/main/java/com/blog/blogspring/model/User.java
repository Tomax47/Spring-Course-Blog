package com.blog.blogspring.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

// We just need to correctly write the model and Spring boot on its own will create the db work for us /No tables to create by us/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
// User table is alrdy taken, so we will need to pick another name
@Table(name = "account")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    @OneToMany(mappedBy = "author")
    private List<Article> createdArticles;

    private String confirmed;
    private Role role;
}