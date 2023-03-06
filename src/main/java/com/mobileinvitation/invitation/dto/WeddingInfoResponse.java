package com.mobileinvitation.invitation.dto;

import com.mobileinvitation.invitation.enums.Family;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
@Schema(description = "웨딩정보 조회 응답데이터")
public class WeddingInfoResponse {

  @Schema(description = "신랑이름")
  private String groomName;

  @Schema(description = "신랑아버지")
  private String groomFather;

  @Schema(description = "신랑어머니")
  private String groomMather;

  @Schema(description = "신랑형제관계")
  private Family groomRelation;

  @Schema(description = "신랑핸드폰")
  private String groomPhone;

  @Schema(description = "신랑 은행명")
  private String groomBank;

  @Schema(description = "예금주 명")
  private String groomAccountOwn;

  @Schema(description = "계좌번호")
  private String groomAccountNum;

  @Schema(description = "신부")
  private String brideName;

  @Schema(description = "신부아버지")
  private String brideFather;

  @Schema(description = "신부어머니")
  private String brideMather;

  @Schema(description = "신부형제관계")
  private Family brideRelation;

  @Schema(description = "신부핸드폰")
  private String bridePhone;

  @Schema(description = "은행명")
  private String brideBank;

  @Schema(description = "예금주명")
  private String brideAccountOwn;

  @Schema(description = "계좌번호")
  private String brideAccountNum;

  @Schema(description = "웨딩홀명")
  private String weddingHall;

  @Schema(description = "주소")
  private String address;

  @Schema(description = "신랑어머니")
  private String detailAddress;

  @Schema(description = "결혼식날짜")
  private LocalDateTime weddingDate;

  @Schema(description = "인사말제목")
  private String greetingsTitle;

  @Schema(description = "인사말")
  private String greetingsBody;

  @Schema(description = "알림")
  private String notice;
}
