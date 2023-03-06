package com.mobileinvitation.member.entity;

import com.mobileinvitation.core.entity.RootEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 회원 엔티티
 *
 * <pre>
 * </pre>
 */
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "member")
public class Member extends RootEntity {

  @Column(name = "content", nullable = false, unique = true)
  private String memberId;

  @Column(name = "password", nullable = false)
  private String password;
}
