package com.worcester.neighbor.nourish.repository;

import com.worcester.neighbor.nourish.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // check if userId is used
    User findByUserId(String userId);
    // for login
    User findByUserIdAndPassword(String user, String password);
    // for register
    User saveAndFlush(User user);
}
