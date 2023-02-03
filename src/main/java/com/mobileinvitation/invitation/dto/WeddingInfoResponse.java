package com.mobileinvitation.invitation.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JsonInclude(Include.NON_EMPTY)
public class WeddingInfoResponse implements Serializable {

  @Schema(description = "신랑이름")
  private String manName;

  @Schema(description = "신부이름")
  private String womanName;

  @Schema(description = "신랑 아버지 이름")
  private String manFather;

  @Schema(description = "신랑 어머니 이름")
  private String manMother;

  @Schema(description = "신부 아버지 이름")
  private String womanFather;

  @Schema(description = "신부 어머니 이름")
  private String womanMother;

  @Schema(description = "결혼식 날짜")
  private String date;

  @Schema(description = "결혼식 시간")
  private String time;

  @Schema(description = "주소")
  private String add1;

  @Schema(description = "상세주소")
  private String add2;

  @Schema(description = "글귀")
  private String text;
}
