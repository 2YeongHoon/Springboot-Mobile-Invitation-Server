package com.mobileinvitation.invitation.entity;

import com.mobileinvitation.core.entity.RootEntity;
import javax.persistence.Table;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 비디오 엔티티
 *
 * <pre>
 * </pre>
 * */
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "video")
public class VideoEntity extends RootEntity {

  @Id
  @GeneratedValue
  private Long idx;

  @Column
  private String videoName;

  @Column
  private String videoPath;
}
