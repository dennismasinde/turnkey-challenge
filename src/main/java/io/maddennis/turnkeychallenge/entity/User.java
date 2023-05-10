package io.maddennis.turnkeychallenge.entity;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "usera_tbl")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    @Max(30)
    private String firstName;
    @Column(name = "last_name")
    @Max(30)
    private String lastName;
    @Column(name = "phone_number")
    @Max(13)
    @Min(10)
    private String phoneNumber;
    @Column(name = "account_number")
    private int accountNumber;
    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;
    @Column(name = "created_at")
    private LocalDateTime createdAt;


    public User(String firstName, String lastName, String phoneNumber, int accountNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.accountNumber = accountNumber;
        this.modifiedAt = LocalDateTime.now();
        this.createdAt = LocalDateTime.now();
    }
}
