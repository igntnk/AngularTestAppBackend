package dev.vorsty.repositories;

import dev.vorsty.db.entities.auth.AuthUserEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthUserRepo extends ListCrudRepository<AuthUserEntity,Long> {
}
