package com.Demo.SpringContract.Dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Demo.SpringContract.User.User;


/**
 * Data access layer for the application.
 *
 */
@Repository
public interface UserDao extends JpaRepository<User, Integer> {
   /**
    * 
    * @param email email
    * @return email 
    */
    User findByEmail(String email);

}
