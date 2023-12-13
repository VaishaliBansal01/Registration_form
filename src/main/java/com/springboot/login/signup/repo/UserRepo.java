package com.springboot.login.signup.repo;

import com.springboot.login.signup.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {



    User findByEmail(String email);
}
