package com.mobileinvitation.service;

import com.mobileinvitation.common.CommonResult;
import com.mobileinvitation.model.entity.ImageEntity;
import com.mobileinvitation.model.entity.UserEntity;
import com.mobileinvitation.model.entity.VideoEntity;
import com.mobileinvitation.model.entity.WeddingInfoEntity;
import com.mobileinvitation.model.request.LoginUserReq;
import com.mobileinvitation.model.request.SaveInfoReq;
import com.mobileinvitation.repository.ImageRepo;
import com.mobileinvitation.repository.UserRepo;
import com.mobileinvitation.repository.VideoRepo;
import com.mobileinvitation.repository.WeddingInfoRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MobileInvitationService {

    private final UserRepo userRepo;
    private final WeddingInfoRepo weddingInfoRepo;
    private final ImageRepo imageRepo;
    private final VideoRepo videoRepo;

    @Transactional
    public CommonResult login(LoginUserReq loginUserReq) throws Exception {
        CommonResult res = new CommonResult();
        try {
            if (userExistCheck(loginUserReq.getUserName())) {
                UserEntity user = userPassCheck(loginUserReq).orElse(null);
                if (user == null) {
                    res.setCode(2);
                    res.setMessage("Password가 일치하지 않습니다.");
                    return res;
                }
            } else {
                res.setCode(1);
                res.setMessage("회원정보 없음");
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
        res.setMessage("information 반환");
        return res;
    }

    @Transactional
    public CommonResult upload(SaveInfoReq saveInfoReq) {
        CommonResult res = new CommonResult();
        // TODO 이미지 업로드

        // user 저장
        UserEntity userEntity = UserEntity.builder()
                .userName(saveInfoReq.getUserName())
                .userPass("pass!!")
                .build();

        userRepo.save(userEntity);

        // weddingInfo 저장
        String imageName = saveInfoReq.getImage().getOriginalFilename();
        String videoName = saveInfoReq.getVideo().getOriginalFilename();

        WeddingInfoEntity weddingInfoEntity = WeddingInfoEntity.builder()
                .groomName(saveInfoReq.getGroomName())
                .groomFather(saveInfoReq.getGroomFather())
                .groomRelation(saveInfoReq.getGroomRelation())
                .groomPhone(saveInfoReq.getGroomPhone())
                .groomBank(saveInfoReq.getGroomBank())
                .groomAccountNum(saveInfoReq.getGroomAccountNum())
                .groomAccountOwn(saveInfoReq.getGroomAccountOwn())
                .brideName(saveInfoReq.getBrideName())
                .brideFather(saveInfoReq.getBrideFather())
                .brideMather(saveInfoReq.getBrideMather())
                .brideRelation(saveInfoReq.getBrideRelation())
                .bridePhone(saveInfoReq.getBridePhone())
                .brideBank(saveInfoReq.getBrideBank())
                .brideAccountNum(saveInfoReq.getBrideAccountNum())
                .brideAccountOwn(saveInfoReq.getBrideAccountOwn())
                .build();


        ImageEntity imageEntity = ImageEntity.builder()
                .image(imageName)
                .weddingInfo(weddingInfoEntity)
                .build();

        VideoEntity videoEntity = VideoEntity.builder()
                .video(videoName)
                .weddingInfo(weddingInfoEntity)
                .build();

        weddingInfoRepo.save(weddingInfoEntity);
        imageRepo.save(imageEntity);
        videoRepo.save(videoEntity);

        return res;
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
//        return userRepo.existsByName(userName);
    }

}
