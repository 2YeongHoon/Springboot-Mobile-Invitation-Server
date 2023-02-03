package com.mobileinvitation.invitation.entity;

import com.mobileinvitation.core.entity.RootEntity;
import javax.persistence.Table;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 이미지 엔티티
 *
 * <pre>
 * </pre>
 * */
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "image")
public class ImageEntity extends RootEntity {

  @Id
  @GeneratedValue
  private Long idx;

  @Column
  private String imageName;

  @Column
  private String imagePath;
}
