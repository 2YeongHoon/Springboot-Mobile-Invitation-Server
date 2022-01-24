package com.mobileinvitation.service;

import com.mobileinvitation.model.entity.UserEntity;
import com.mobileinvitation.model.request.CreateUserReq;
import com.mobileinvitation.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MobileInvitationService {

    private final UserRepo userRepo;

    @Transactional
    public String savePost(CreateUserReq createUserReq) throws Exception {

        String userName = createUserReq.getUserName();
        String userPass = createUserReq.getUserPass();

        try {
            UserEntity user = userLoginCheck(createUserReq).orElse(null);

            if (ObjectUtils.isEmpty(user)) {
                UserEntity userEntity = UserEntity.builder()
                        .userName(userName)
                        .userPass(userPass)
                        .build();
                userRepo.save(userEntity);
                return "회원정보 저장";
            } else {
//                UserEntity userEntity = user.get();
                if (!userPass.equals(user.getUserPass())) {
                    return "Passwd가 일치 하지 않습니다.";
                }
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return "Success";
    }

    @Transactional
    public Optional<UserEntity> userLoginCheck(CreateUserReq createUserReq) {
        return userRepo.findByUserNameAndUserPass(createUserReq.getUserName(), createUserReq.getUserPass());
    }
}
