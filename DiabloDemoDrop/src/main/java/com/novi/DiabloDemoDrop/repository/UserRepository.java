/**
 *
 * @author wouterverveer 
 */
package com.novi.DiabloDemoDrop.repository;

import com.novi.DiabloDemoDrop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{}
    
    
 


