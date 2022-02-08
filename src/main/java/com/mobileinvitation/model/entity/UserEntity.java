package com.mobileinvitation.model.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity extends TimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_idx", unique = true, nullable = false)
    private Long idx;

    @OneToOne
    @JoinColumn(name = "wedding_idx")
    private WeddingInfoEntity weddingInfoEntity;

    @Column(nullable = false, unique = true)
    private String userName;

    @Column(nullable = false)
    private String userPass;

//    @Builder
//    public UserEntity(Long idx, String userName, String userPass, WeddingInfoEntity weddingInfoEntity) {
//        this.idx = idx;
//        this.userName = userName;
//        this.userPass = userPass;
//        this.weddingInfoEntity = weddingInfoEntity;
//    }
}
