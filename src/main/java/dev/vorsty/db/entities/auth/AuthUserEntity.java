package dev.vorsty.db.entities.auth;

import dev.vorsty.db.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Set;


@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class AuthUserEntity extends BaseEntity {
    static BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    public AuthUserEntity(boolean enabled, String username, String password, String name,String surname, Set<RoleUserEntity> roles){
        this.password = passwordEncoder.encode(password);
        this.enabled = enabled;
        this.username = username;
        this.roles = roles;
        this.name = name;
        this.surname = surname;
    }

    private String username;
    private boolean enabled;
    private String password;
    @OneToMany(cascade = {CascadeType.ALL},orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "user_id", updatable = true)
    private Set<RoleUserEntity> roles;

}
