package com.mobileinvitation.form.repository;

import com.mobileinvitation.form.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<UserEntity, Long> {

  Optional<UserEntity> findByUserNameAndUserPass(String userName, String userPass);

  Optional<UserEntity> findByUserName(String userName);
}
