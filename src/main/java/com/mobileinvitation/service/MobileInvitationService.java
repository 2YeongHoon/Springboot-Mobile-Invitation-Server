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
import java.util.List;
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
    public CommonResult dbUpload(SaveInfoItem saveInfoItem) {
        CommonResult res = new CommonResult();
//
        if (!userExistCheck(saveInfoItem.getUserName())) {
//            UserEntity userEntity = UserEntity.builder()
//                    .userName(saveInfoItem.getUserName())
//                    .userPass(saveInfoItem.getUserPass())
//                    .build();
//            userRepo.save(userEntity);
//            saveInfoItem.toUserEntity()
//            userRepo.save().getIdx();
            userRepo.save(saveInfoItem.toUserEntity());
        } else {
            userRepo.findByUserName(saveInfoItem.getUserName()).get();
        }


//        weddingInfoRepo.save(saveInfoItem.toWeddingInfoEntity());
//        imageRepo.save(saveInfoItem.toImageEntity());
//        videoRepo.save(saveInfoItem.toVideoEntity());

        return res;
    }

    @Transactional
    public String fileUpload(MultipartFile media) throws IOException {
        CommonResult res = new CommonResult();
        File file = null;

        //TODO 파일 저장명: UUID_"파일"으로 구현
        if (!media.isEmpty()) {
            String path = "D:\\temp";
//            File file = new File(path, media.getOriginalFilename());
            file = new File(path, media.getOriginalFilename());

            media.transferTo(file);
        }

        //TODO Path, fileName 반환
        return file.getAbsolutePath();
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
