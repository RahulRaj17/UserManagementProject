package com.learning.usermanagementproject.repository;

import com.learning.usermanagementproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
