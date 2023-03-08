package it.infobasic.usermanager.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@NoArgsConstructor
@Data
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    String username;
    String password;
    String email;
    LocalDate dataNascita;
    LocalDate dataRegistrazione;


    public User(String username, String password, String email, LocalDate dataNascita) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.dataNascita = dataNascita;
        this.dataRegistrazione = LocalDate.now();
    }
}


