package com.mobileinvitation.invitation.entity;

import com.mobileinvitation.core.entity.RootEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

  @Column(name = "name")
  private String name;

  @Column(name = "url")
  private String url;
}
