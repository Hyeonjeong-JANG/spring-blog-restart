package shop.mtcoding.blog.user;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_tb")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String username;

    @Column(length = 60, nullable = false)
    private String password;
    private String email;

    private LocalDateTime createdAt;
}
