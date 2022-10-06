package com.carsite.carsite.respository;

import com.carsite.carsite.model.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Qualifier("UserRepository")
public interface UserRepository extends JpaRepository<User, String> {

    @Query( value =
            "SELECT u " +
            "FROM User u " +
            "WHERE u.username = :username"
    )
    Optional<User> findByUsername(
            @Param("username") String username
    );

    Optional<User> findByEmail(@Param("email") String email);

}
