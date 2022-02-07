package com.mobileinvitation.model.item;

import com.mobileinvitation.model.entity.ImageEntity;
import com.mobileinvitation.model.entity.UserEntity;
import com.mobileinvitation.model.entity.VideoEntity;
import com.mobileinvitation.model.entity.WeddingInfoEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaveInfoItem {
    private String userName;
    private String userPass;
    private String groomName;
    private String groomFather;
    private String groomRelation;
    private String groomPhone;
    private String groomBank;
    private String groomAccountNum;
    private String groomAccountOwn;
    private String brideName;
    private String brideFather;
    private String brideMather;
    private String brideRelation;
    private String bridePhone;
    private String brideBank;
    private String brideAccountNum;
    private String brideAccountOwn;
    private String weddingDate;
    private String weddingHall;
    private String address;
    private String detailAddress;
    private String notice;
    private String text;
    private String greetingsBody;
    private String greetingsTitle;
    private String videoPath;
    private String imagePath;

    public UserEntity toUserEntity() {
        UserEntity userEntity = UserEntity.builder()
                .userName(userName)
                .userPass(userPass)
                .build();
        return userEntity;
    }

    public WeddingInfoEntity toWeddingInfoEntity() {
        WeddingInfoEntity weddingInfoEntity = WeddingInfoEntity.builder()
                .groomName(groomName)
                .groomFather(groomFather)
                .groomRelation(groomRelation)
                .groomPhone(groomPhone)
                .groomBank(groomBank)
                .groomAccountNum(groomAccountNum)
                .groomAccountOwn(groomAccountOwn)
                .brideName(brideName)
                .brideFather(brideFather)
                .brideMather(brideMather)
                .brideRelation(brideRelation)
                .bridePhone(bridePhone)
                .brideBank(brideBank)
                .brideAccountNum(brideAccountNum)
                .brideAccountOwn(brideAccountOwn)
                .weddingDate(weddingDate)
                .weddingHall(weddingHall)
                .address(address)
                .detailAddress(detailAddress)
                .notice(notice)
                .text(text)
                .greetingsBody(greetingsBody)
                .greetingsTitle(greetingsTitle)
                .build();

        return weddingInfoEntity;
    }

    public VideoEntity toVideoEntity() {
        VideoEntity videoEntity = VideoEntity.builder()
                .videoPath(videoPath)
                .build();

        return videoEntity;
    }

    public ImageEntity toImageEntity() {
        ImageEntity imageEntity = ImageEntity.builder()
                .imagePath(imagePath)
                .build();

        return imageEntity;
    }

    @Builder
    public SaveInfoItem(String imagePath, String videoPath) {
        this.videoPath = videoPath;
        this.imagePath = imagePath;
    }
}
