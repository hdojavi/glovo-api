package com.jhernando.glovo.model.repositories;

import com.jhernando.glovo.model.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    User findByEmailAndPassword(String email, String password);
}
