package com.mobileinvitation.config.aws.s3;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.mobileinvitation.invitation.entity.ImageEntity;
import com.mobileinvitation.invitation.entity.VideoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Component
public class S3UploaderService {

  private final AmazonS3Client amazonS3Client;

  @Value("${cloud.aws.s3.bucket}")
  public String bucket;

  public List<ImageEntity> imageUpload(List<MultipartFile> medias) throws Exception {
    List<ImageEntity> imageEntityList = new ArrayList<>();
    String path = "D:\\mobile-invitation";

    for (MultipartFile media : medias) {
      if (!media.isEmpty()) {
        Date nowDate = new Date();
        SimpleDateFormat time = new SimpleDateFormat("hhmmssSSSS");
        String fileName = time.format(nowDate) + "_" + media.getOriginalFilename();
        File file = new File(path, fileName);
        media.transferTo(file);

        amazonS3Client.putObject(new PutObjectRequest(bucket, fileName, file).withCannedAcl(
            CannedAccessControlList.PublicRead));

        //TODO S3 업로드 위치 변경
        ImageEntity imageEntity = ImageEntity.builder().
            imagePath(amazonS3Client.getUrl(bucket, fileName).toString()).
            imageName(fileName).
            build();
        imageEntityList.add(imageEntity);
        file.delete();
      }
    }
    return imageEntityList;
  }

  public List<VideoEntity> videoUpload(List<MultipartFile> medias) throws Exception {
    List<VideoEntity> videoEntityList = new ArrayList<>();
    String path = "D:\\mobile-invitation";

    for (MultipartFile media : medias) {
      if (!media.isEmpty()) {
        Date nowDate = new Date();
        SimpleDateFormat time = new SimpleDateFormat("hhmmssSSSS");
        String fileName = time.format(nowDate) + "_" + media.getOriginalFilename();
        File file = new File(path, fileName);
        media.transferTo(file);

        amazonS3Client.putObject(new PutObjectRequest(bucket, fileName, file).withCannedAcl(
            CannedAccessControlList.PublicRead));

        //TODO S3 업로드 위치 변경
        VideoEntity videoEntity = VideoEntity.builder().
            videoPath(amazonS3Client.getUrl(bucket, fileName).toString()).
            videoName(fileName).
            build();
        videoEntityList.add(videoEntity);
        file.delete();
      }
    }
    return videoEntityList;
  }
}
