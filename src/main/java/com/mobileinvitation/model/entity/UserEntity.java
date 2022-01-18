package com.mobileinvitation.model.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserEntity extends TimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @OneToOne
    @JoinColumn(name = "idx")
    private WeddingInfoEntity weddingInfoEntity;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String userPass;

    @Builder
    public UserEntity(Long idx, String userName, String userPass) {
        this.idx = idx;
        this.userName = userName;
        this.userPass = userPass;
    }
}
