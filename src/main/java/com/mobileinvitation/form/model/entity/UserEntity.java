package com.mobileinvitation.form.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity extends TimeEntity {

  @Id
  @GeneratedValue(generator = "uuid2")
  @Column(columnDefinition = "BINARY(16)", name = "user_id")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  private UUID idx;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "weddinginfo_id")
  private WeddingInfoEntity weddingInfo;

  @Column(nullable = false, unique = true)
  private String userName;

  @Column(nullable = false)
  private String userPass;
}
