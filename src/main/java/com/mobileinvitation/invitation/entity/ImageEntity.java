package com.mobileinvitation.invitation.entity;

import com.mobileinvitation.core.entity.RootEntity;
import com.mobileinvitation.core.entity.utils.YesOrNo;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.criteria.Root;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 이미지 엔티티
 *
 * <pre>
 * </pre>
 */
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "image")
public class ImageEntity extends RootEntity {

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "url", nullable = false)
  private String url;

  @Column(name = "represent_yn", columnDefinition = "varchar(1)")
  private YesOrNo representYn;
}
