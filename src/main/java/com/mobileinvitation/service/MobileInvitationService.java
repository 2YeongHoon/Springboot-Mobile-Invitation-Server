package com.mobileinvitation.service;

import com.mobileinvitation.common.CommonResult;
import com.mobileinvitation.model.entity.ImageEntity;
import com.mobileinvitation.model.entity.UserEntity;
import com.mobileinvitation.model.entity.VideoEntity;
import com.mobileinvitation.model.entity.WeddingInfoEntity;
import com.mobileinvitation.model.item.SaveInfoItem;
import com.mobileinvitation.model.request.LoginUserReq;
import com.mobileinvitation.model.request.SaveInfoReq;
import com.mobileinvitation.repository.ImageRepo;
import com.mobileinvitation.repository.UserRepo;
import com.mobileinvitation.repository.VideoRepo;
import com.mobileinvitation.repository.WeddingInfoRepo;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.utility.FileSystem;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.*;
import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
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

//    public CommonResult imageUpload(MultipartFile image) {
//        CommonResult res = new CommonResult();
//        // TODO 파일 업로드 구현
//
//        return res;
//    }
//
//    public CommonResult videoUpload(MultipartFile video) {
//        CommonResult res = new CommonResult();
//        // TODO 파일 업로드 구현
//
//        return res;
//    }

    @Transactional
    public CommonResult dbUpload(SaveInfoItem saveInfoItem) {
        CommonResult res = new CommonResult();

        userRepo.save(saveInfoItem.toUserEntity());
        weddingInfoRepo.save(saveInfoItem.toWeddingInfoEntity());
        imageRepo.save(saveInfoItem.toImageEntity());
        videoRepo.save(saveInfoItem.toVideoEntity());

        return res;
    }

    @Transactional
    public CommonResult fileUpload(MultipartFile media) throws IOException {
        CommonResult res = new CommonResult();
        // TODO user idx 조회
        // TODO 이미지 업로드
        if (!media.isEmpty()) {
            String path = "D:\\temp";
            File file = new File(path, media.getOriginalFilename());
            media.transferTo(file);
        }

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
