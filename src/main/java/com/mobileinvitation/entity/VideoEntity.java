package com.mobileinvitation.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VideoEntity {

  @Id
  @GeneratedValue
  private Long idx;

  @Column
  private String videoName;

  @Column
  private String videoPath;
}
