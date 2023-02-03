package com.mobileinvitation.invitation.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImageEntity {

  @Id
  @GeneratedValue
  private Long idx;

  @Column
  private String imageName;

  @Column
  private String imagePath;
}
