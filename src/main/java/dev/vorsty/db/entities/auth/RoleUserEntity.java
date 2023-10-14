package dev.vorsty.db.entities.auth;

import dev.vorsty.db.entities.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleUserEntity extends BaseEntity {
    private String username;
    @Enumerated(EnumType.STRING)
    private BaseRole role;
}
