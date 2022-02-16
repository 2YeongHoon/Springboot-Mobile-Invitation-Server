package com.mobileinvitation.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity extends TimeEntity {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long idx;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "weddinginfo_id")
    private WeddingInfoEntity weddingInfo;

    @Column(nullable = false, unique = true)
    private String userName;

    @Column(nullable = false)
    private String userPass;
}
