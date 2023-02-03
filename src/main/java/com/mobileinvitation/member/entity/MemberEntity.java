package com.mobileinvitation.member.entity;

import com.mobileinvitation.invitation.entity.InformationEntity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberEntity {

  @Id
  @GeneratedValue
  private Long idx;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "information_id")
  private InformationEntity information;

  @Column(nullable = false, unique = true)
  private String phone;

  @Column(nullable = false, unique = true)
  private String password;
}
