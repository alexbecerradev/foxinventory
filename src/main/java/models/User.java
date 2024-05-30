package models;

import jakarta.persistence.*;
import lombok.Data;

import javax.management.relation.Role;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    public boolean isAdmin() {
        return roles.stream().anyMatch(role -> role.getRoleName().equals("ROLE_ADMIN"));
    }

    public boolean isUser() {
        return roles.stream().anyMatch(role -> role.getRoleName().equals("ROLE_USER"));
    }

    // Otros métodos y getters/setters
}
