package com.cafe.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cafe.model.User;

@Repository

public interface UserRepository extends JpaRepository<User, Long> {
	User findById(long id);
}
