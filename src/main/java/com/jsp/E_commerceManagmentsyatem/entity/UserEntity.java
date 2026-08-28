package com.jsp.E_commerceManagmentsyatem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "users")// for name conflict in postgres
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "myuser")//instead of AUTO use sequence
    @SequenceGenerator(name ="myuser",sequenceName = "user_seq", allocationSize = 1,initialValue = 1)
    private int id;
    @Column(nullable = false)
    private String name;

    @Column(unique = true,nullable = false)
private String email;
    @Column(nullable = false)
    private String mobile;

@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
@JsonIgnore
private List<OrderEntity>orders;


    @Override
    public String toString() {
        return "UserEntity{" +
                "email='" + email + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}
