package org.jaanDeveloper.loading.repository;

import jakarta.transaction.Transactional;
import org.jaanDeveloper.loading.model.UserRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface UserRegisterRepository extends JpaRepository<UserRegister,Integer> {
   // @Query(value = "select * from user_register where mobile=:mobile", nativeQuery = true)
    public UserRegister findByUsername(String mobile);
    @Query(value = "select * from user_register where username=:username", nativeQuery = true)
    UserRegister getByChangePassword(String username);
    @Transactional    // 1:-
    @Modifying        // 2:- both are imp for DML operation
    @Query(value = "update user_register set password=:upass where username=:uname ", nativeQuery = true)
    int updatePassword(String uname, String upass);
}
