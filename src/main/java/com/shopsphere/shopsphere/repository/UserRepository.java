package com.shopsphere.shopsphere.repository;

import com.shopsphere.shopsphere.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
