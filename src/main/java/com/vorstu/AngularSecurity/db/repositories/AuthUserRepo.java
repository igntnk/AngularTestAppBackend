package com.vorstu.AngularSecurity.db.repositories;

import com.vorstu.AngularSecurity.db.entities.auth.AuthUserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface AuthUserRepo  extends PagingAndSortingRepository<AuthUserEntity, Long> {

}
