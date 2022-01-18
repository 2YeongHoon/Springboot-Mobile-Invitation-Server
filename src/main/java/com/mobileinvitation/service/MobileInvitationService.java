package com.mobileinvitation.service;

import com.mobileinvitation.model.entity.UserEntity;
import com.mobileinvitation.model.request.CreateUserReq;
import com.mobileinvitation.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class MobileInvitationService {

    private final UserRepo userRepo;

    @Transactional
    public void savePost(CreateUserReq createUserReq) {

        UserEntity userEntity = UserEntity.builder()
                .userName(createUserReq.getUserName())
                .userPass(createUserReq.getUserPass())
                .build();

        userRepo.save(userEntity);
    }
}
