package com.mobileinvitation.invitation.entity;

import com.mobileinvitation.core.entity.RootEntity;
import com.mobileinvitation.core.entity.utils.YesOrNo;
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
 */
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "video")
public class VideoEntity extends RootEntity {
  
  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "url", nullable = false)
  private String url;

  @Column(name = "represent_yn", columnDefinition = "varchar(1)")
  private YesOrNo representYn;
}
