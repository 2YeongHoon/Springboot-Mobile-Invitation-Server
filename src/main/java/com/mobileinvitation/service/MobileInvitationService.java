package com.mobileinvitation.service;

import com.mobileinvitation.model.entity.UserEntity;
import com.mobileinvitation.model.request.LoginUserReq;
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
    public String login(LoginUserReq loginUserReq) throws Exception {
        try {
            UserEntity user = userLoginCheck(loginUserReq).orElse(null);

            if (ObjectUtils.isEmpty(user)) {
//                UserEntity userEntity = UserEntity.builder()
//                        .userName(userName)
//                        .userPass(userPass)
//                        .build();
//                userRepo.save(userEntity);
                return "회원정보 없음, infomation.html 호출";
            } else {
//                UserEntity userEntity = user.get();
                if (!user.getUserPass().equals(user.getUserPass())) {
                    return "Passwd를 확인해주세요.";
                }
                // getInfo
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return "Success";
    }

    @Transactional
    public String getInfo() {
        return "";
    }

    @Transactional
    public String saveInfo() {
        return "";
    }

    @Transactional
    public Optional<UserEntity> userLoginCheck(LoginUserReq loginUserReq) {
        return userRepo.findByUserNameAndUserPass(loginUserReq.getUserName(), loginUserReq.getUserPass());
    }
}
