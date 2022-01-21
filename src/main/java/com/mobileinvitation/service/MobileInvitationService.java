package com.mobileinvitation.service;

import com.mobileinvitation.model.entity.UserEntity;
import com.mobileinvitation.model.request.CreateUserReq;
import com.mobileinvitation.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MobileInvitationService {

    private final UserRepo userRepo;

    @Transactional
    public String savePost(CreateUserReq createUserReq) {

        String userName = createUserReq.getUserName();
        String userPass = createUserReq.getUserPass();

        try {
            Optional<UserEntity> user = userLoginCheck(createUserReq);

            if (user.isEmpty()) {
                UserEntity userEntity = UserEntity.builder()
                        .userName(userName)
                        .userPass(userPass)
                        .build();
                userRepo.save(userEntity);
                return "회원정보 저장";
            } else {
                UserEntity userEntity = user.get();
                if (!userPass.equals(userEntity.getUserPass())) {
                    return "Passwd가 일치 하지 않습니다.";
                }
            }
        } catch (Exception e) {
            return "Err";
        }
        return "Success";
    }


    @Transactional
    public Optional<UserEntity> userLoginCheck(CreateUserReq createUserReq) {
        return userRepo.findByUserNameAndUserPass(createUserReq.getUserName(), createUserReq.getUserPass());
    }
}
