package com.example.ruvimProject.modell;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users_db")
public class UserModell {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Column(name = "name")
    private String name;

    @NotEmpty
    @Column(name = "surname")
    private String surname;

    @Column(name = "birthday")
    private Date birthday;

    @NotEmpty
    @Column(name ="department")
    private String department;

    @Column (name = "username")
    private String username;

    @Column(name = "password")
    @JsonIgnore
    private String password;

    @OneToOne(mappedBy = "user")
    private ProjectEntity projectEntity;
}
