package com.mobileinvitation.model.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;

@Getter
@Entity
@NoArgsConstructor( access = AccessLevel.PROTECTED )
public class UserEntity extends TimeEntity {

    @Id
    @GeneratedValue
    private Long idx;

    @OneToOne
    @JoinColumn(name = "idx")
    private WeddingInfoEntity weddingInfoEntity;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String userPass;

    @Builder
    public UserEntity(String userName, String userPass)
    {
        this.userName = userName;
        this.userPass = userPass;
    }
}
