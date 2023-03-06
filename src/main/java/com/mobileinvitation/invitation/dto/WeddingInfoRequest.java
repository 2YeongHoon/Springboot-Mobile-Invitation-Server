package com.mobileinvitation.invitation.dto;

import com.mobileinvitation.invitation.enums.Family;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Schema(description = "웨딩정보 저장 요청데이터")
public class WeddingInfoRequest {

  @Schema(description = "신랑이름", example = "이두", required = true)
  private String groomName;

  @Schema(description = "신랑아버지", example = "이수")
  private String groomFather;

  @Schema(description = "신랑어머니", example = "김명")
  private String groomMather;

  @Schema(description = "신랑형제관계", example = "LAST", required = true)
  private Family groomRelation;

  @Schema(description = "신랑핸드폰", example = "01012341234", required = true)
  private String groomPhone;

  @Schema(description = "신랑 은행명", example = "기업", required = true)
  private String groomBank;

  @Schema(description = "예금주 명", required = true)
  private String groomAccountOwn;

  @Schema(description = "계좌번호", example = "123123", required = true)
  private String groomAccountNum;

  @Schema(description = "신부", example = "김뿌", required = true)
  private String brideName;

  @Schema(description = "신부아버지", example = "김삐")
  private String brideFather;

  @Schema(description = "신부어머니", example = "냥뽀")
  private String brideMather;

  @Schema(description = "신부형제관계", example = "FIRST")
  private Family brideRelation;

  @Schema(description = "신부핸드폰", example = "01012341234", required = true)
  private String bridePhone;

  @Schema(description = "은행명", example = "김뿌은행", required = true)
  private String brideBank;

  @Schema(description = "예금주명", example = "김뿌", required = true)
  private String brideAccountOwn;

  @Schema(description = "계좌번호", example = "1234", required = true)
  private String brideAccountNum;

  @Schema(description = "웨딩홀명", example = "뿌리리홀", required = true)
  private String weddingHall;

  @Schema(description = "주소", example = "경기도 뿌리리", required = true)
  private String address;

  @Schema(description = "신랑어머니", example = "3623번지", required = true)
  private String detailAddress;

  @Schema(description = "결혼식날짜", example = "202301070100", required = true)
  private LocalDateTime weddingDate;

  @Schema(description = "인사말제목", example = "안녕하세요", required = true)
  private String greetingsTitle;

  @Schema(description = "인사말", example = "잘살겠습니다", required = true)
  private String greetingsBody;

  @Schema(description = "알림", example = "", required = true)
  private String notice;
}
