package com.mobileinvitation.s3.service;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.mobileinvitation.form.model.entity.ImageEntity;
import com.mobileinvitation.form.model.entity.VideoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

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

    for (MultipartFile media : medias) {
      if (!media.isEmpty()) {
        Date nowDate = new Date();
        SimpleDateFormat time = new SimpleDateFormat("hhmmssSSSS");
        String fileName = time.format(nowDate) + "_" + media.getOriginalFilename();

        amazonS3Client.putObject(new PutObjectRequest(bucket, fileName, media.getInputStream(), obtainMetadata(media)).withCannedAcl(
            CannedAccessControlList.PublicRead));

        //TODO S3 업로드 위치 변경
        ImageEntity imageEntity = ImageEntity.builder().
            imagePath(amazonS3Client.getUrl(bucket, fileName).toString()).
            imageName(fileName).
            build();
        imageEntityList.add(imageEntity);
      }
    }
    return imageEntityList;
  }

  public List<VideoEntity> videoUpload(List<MultipartFile> medias) throws Exception {
    List<VideoEntity> videoEntityList = new ArrayList<>();

    for (MultipartFile media : medias) {
      if (!media.isEmpty()) {
        Date nowDate = new Date();
        SimpleDateFormat time = new SimpleDateFormat("hhmmssSSSS");
        String fileName = time.format(nowDate) + "_" + media.getOriginalFilename();

        amazonS3Client.putObject(new PutObjectRequest(bucket, fileName, media.getInputStream(), obtainMetadata(media)).withCannedAcl(
            CannedAccessControlList.PublicRead));

        //TODO S3 업로드 위치 변경
        VideoEntity videoEntity = VideoEntity.builder().
            videoPath(amazonS3Client.getUrl(bucket, fileName).toString()).
            videoName(fileName).
            build();
        videoEntityList.add(videoEntity);
      }
    }
    return videoEntityList;
  }

  private ObjectMetadata obtainMetadata(MultipartFile multipartFile) {
    ObjectMetadata metadata = new ObjectMetadata();
    metadata.setContentLength(multipartFile.getSize());
    metadata.setContentType(multipartFile.getContentType());
    return metadata;
  }
}
