/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author stephensonpetit-homme
 */

@Transactional(readOnly = true)
//public interface UserRepository extends CrudRepository<User, UserId>, UserRepositoryCustom {
//    boolean existsByEmail(Email email);
//}
public interface UserRepository extends JpaRepository<User, UserId>, UserRepositoryCustom {
    boolean existsByEmail(Email email);
}



