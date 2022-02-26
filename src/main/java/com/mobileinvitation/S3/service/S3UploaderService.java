package com.mobileinvitation.S3.service;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.mobileinvitation.model.entity.ImageEntity;
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

//    public String upload(MultipartFile multipartFile) {
//        File uploadFile = convert(multipartFile)  // 파일 변환할 수 없으면 에러
//                .orElseThrow(() -> new IllegalArgumentException("error: MultipartFile -> File convert fail"));
//
//        return upload(uploadFile, dirName);
//    }
//
//    // S3로 파일 업로드하기
//    private String upload(File uploadFile, String dirName) {
//        String fileName = dirName + "/" + UUID.randomUUID() + uploadFile.getName();   // S3에 저장된 파일 이름
//        String uploadImageUrl = putS3(uploadFile, fileName); // s3로 업로드
//        removeNewFile(uploadFile);
//        return uploadImageUrl;
//    }

    // S3로 업로드
    public List<ImageEntity> upload(List<MultipartFile> medias) throws Exception {
        List<ImageEntity> imageEntityList = new ArrayList<>();
        String path = "D:\\mobile-invitation";

        for (MultipartFile media : medias) {
            if (!media.isEmpty()) {
                Date nowDate = new Date();
                SimpleDateFormat time = new SimpleDateFormat("hhmmssSSSS");
                String fileName = time.format(nowDate) + "_" + media.getOriginalFilename();
                File file = new File(path, fileName);
                media.transferTo(file);

                amazonS3Client.putObject(new PutObjectRequest(bucket, fileName, file).withCannedAcl(CannedAccessControlList.PublicRead));

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
}
