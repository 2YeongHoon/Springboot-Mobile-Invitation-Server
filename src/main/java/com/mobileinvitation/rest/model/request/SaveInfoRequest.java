package com.mobileinvitation.rest.model.request;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import lombok.Builder;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Builder
public class SaveInfoRequest implements Serializable {

  private String phone;
  private String password;
  private String manName;
  private String womanName;
  private String manFather;
  private String manMother;
  private String womanFather;
  private String womanMother;
  private String date;
  private String time;
  private String add1;
  private String add2;
  private String text;
}
