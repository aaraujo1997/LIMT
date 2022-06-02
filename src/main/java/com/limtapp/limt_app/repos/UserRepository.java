package com.limtapp.limt_app.repos;

import com.limtapp.limt_app.model.User;
import org.springframework.context.annotation.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String username);
}