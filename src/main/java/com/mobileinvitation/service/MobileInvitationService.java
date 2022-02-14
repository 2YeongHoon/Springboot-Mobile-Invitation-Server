package com.mobileinvitation.service;

import com.mobileinvitation.common.CommonResult;
import com.mobileinvitation.model.entity.ImageEntity;
import com.mobileinvitation.model.entity.UserEntity;
import com.mobileinvitation.model.entity.VideoEntity;
import com.mobileinvitation.model.entity.WeddingInfoEntity;
import com.mobileinvitation.model.item.SaveInfoItem;
import com.mobileinvitation.model.request.LoginUserReq;
import com.mobileinvitation.model.request.SaveInfoReq;
import com.mobileinvitation.model.response.LoginInfoRes;
import com.mobileinvitation.repository.ImageRepo;
import com.mobileinvitation.repository.UserRepo;
import com.mobileinvitation.repository.VideoRepo;
import com.mobileinvitation.repository.WeddingInfoRepo;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.utility.FileSystem;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.*;
import javax.transaction.Transactional;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

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
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        WeddingInfoEntity weddingInfoEntity = userRepo.findByUserName(loginUserReq.getUserName()).get().getWeddingInfo();

        List<VideoEntity> videoEntityList = weddingInfoEntity.getVideoEntityList();
        List<String> videoNames = videoEntityList.stream().map(x -> x.getVideoName()).collect(Collectors.toList());

        List<ImageEntity> imageEntityList = weddingInfoEntity.getImageEntityList();
        List<String> imageNames = imageEntityList.stream().map(x -> x.getImageName()).collect(Collectors.toList());

        LoginInfoRes loginInfoRes = LoginInfoRes.builder()
                .groomName(weddingInfoEntity.getGroomName())
                .groomFather(weddingInfoEntity.getGroomFather())
                .groomRelation(weddingInfoEntity.getGroomRelation())
                .groomPhone(weddingInfoEntity.getGroomPhone())
                .groomBank(weddingInfoEntity.getGroomBank())
                .groomAccountNum(weddingInfoEntity.getGroomAccountNum())
                .groomAccountOwn(weddingInfoEntity.getGroomAccountOwn())
                .brideName(weddingInfoEntity.getBrideName())
                .brideFather(weddingInfoEntity.getBrideFather())
                .brideMather(weddingInfoEntity.getBrideMather())
                .brideRelation(weddingInfoEntity.getBrideRelation())
                .bridePhone(weddingInfoEntity.getBridePhone())
                .brideBank(weddingInfoEntity.getBrideBank())
                .brideAccountNum(weddingInfoEntity.getBrideAccountNum())
                .brideAccountOwn(weddingInfoEntity.getBrideAccountOwn())
                .weddingDate(weddingInfoEntity.getWeddingDate())
                .weddingHall(weddingInfoEntity.getWeddingHall())
                .address(weddingInfoEntity.getAddress())
                .detailAddress(weddingInfoEntity.getDetailAddress())
                .notice(weddingInfoEntity.getNotice())
                .text(weddingInfoEntity.getText())
                .greetingsBody(weddingInfoEntity.getGreetingsBody())
                .greetingsTitle(weddingInfoEntity.getGreetingsTitle())
                .images(imageNames)
                .videos(videoNames)
                .build();

        res.setCode(0);
        res.setMessage("information 반환");

        //TODO loginInfoRes 반환 구현
        return res;
    }

    @Transactional
    public CommonResult dbUpload(SaveInfoItem saveInfoItem) throws Exception {
        CommonResult res = new CommonResult();

        if (!userExistCheck(saveInfoItem.getUserName())) {
            WeddingInfoEntity weddingInfoEntity = saveInfoItem.toWeddingInfoEntity();
            weddingInfoEntity.setVideoEntityList(saveInfoItem.getVideoEntityList());
            weddingInfoEntity.setImageEntityList(saveInfoItem.getImageEntityList());
            userRepo.save(saveInfoItem.toUserEntity(weddingInfoEntity));
        } else {
            UUID userIdx = userRepo.findByUserName(saveInfoItem.getUserName()).get().getWeddingInfo().getIdx();

            WeddingInfoEntity weddingInfoEntity = saveInfoItem.toWeddingInfoEntity();
            weddingInfoEntity.setVideoEntityList(saveInfoItem.getVideoEntityList());
            weddingInfoEntity.setImageEntityList(saveInfoItem.getImageEntityList());
            weddingInfoEntity.setIdx(userIdx);
            weddingInfoRepo.save(weddingInfoEntity);
        }

        res.setCode(0);
        res.setMessage("db저장완료");
        return res;
    }

    @Transactional
    public String fileUpload(MultipartFile media) throws IOException {
        CommonResult res = new CommonResult();

        // TODO UUID명 저장
        if (!media.isEmpty()) {
            String path = "D:\\temp";
            File file = new File(path, media.getOriginalFilename());

            media.transferTo(file);
            return file.getAbsolutePath();
        }

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
