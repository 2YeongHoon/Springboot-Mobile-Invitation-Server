package com.mobileinvitation.service;

import com.mobileinvitation.common.CommonResult;
import com.mobileinvitation.model.entity.UserEntity;
import com.mobileinvitation.model.request.LoginUserReq;
import com.mobileinvitation.repository.UserRepo;
import lombok.Data;
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
    public CommonResult login(LoginUserReq loginUserReq) throws Exception {
        CommonResult res = new CommonResult();
        try {
            if (userExistCheck(loginUserReq.getUserName())) {
                UserEntity user = userPassCheck(loginUserReq).orElse(null);
                if (!user.getUserPass().equals(user.getUserPass())) {
                    res.setCode(2);
                    res.setMessage("Password 불일치");
                    return res;
                }
            } else {
                res.setCode(1);
                res.setMessage("회원정보 없음, infomation호출");
                return res;
            }
//            if (ObjectUtils.isEmpty(user)) {
//                UserEntity userEntity = UserEntity.builder()
//                        .userName(userName)
//                        .userPass(userPass)
//                        .build();
//                userRepo.save(userEntity);
//
//            } else {
//                UserEntity userEntity = user.get();
//            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        res.setCode(0);
        res.setMessage("info반환");
        return res;
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
    public Optional<UserEntity> userPassCheck(LoginUserReq loginUserReq) {
        return userRepo.findByUserNameAndUserPass(loginUserReq.getUserName(), loginUserReq.getUserPass());
    }

    @Transactional
    public boolean userExistCheck(String userName) {
        boolean userExist = true;
        if (ObjectUtils.isEmpty(userRepo.findByUserName(userName).orElse(null))) {
            userExist = false;
        }
        return userExist;
    }

}
