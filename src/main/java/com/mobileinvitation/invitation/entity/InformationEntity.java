package com.mobileinvitation.invitation.entity;

import com.mobileinvitation.member.entity.MemberEntity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InformationEntity {

  @Id
  @GeneratedValue
  private Long idx;

  @OneToOne(cascade = CascadeType.ALL, mappedBy = "information")
  private MemberEntity member;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "weddinginfo_idx")
  private List<VideoEntity> videoEntityList = new ArrayList<>();

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "weddinginfo_idx")
  private List<ImageEntity> imageEntityList = new ArrayList<>();

  @Column
  private String manName;

  @Column
  private String womanName;

  @Column
  private String manFather;

  @Column
  private String manMother;

  @Column
  private String womanFather;

  @Column
  private String womanMother;

  @Column
  private String date;

  @Column
  private String time;

  @Column
  private String add1;

  @Column
  private String add2;

  @Column
  private String text;
}
