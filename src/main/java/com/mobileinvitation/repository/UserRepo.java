package com.mobileinvitation.repository;

import com.mobileinvitation.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepo extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUserNameAndUserPass(String userName, String userPass);

    Optional<UserEntity> findByUserName(String userName);
}
