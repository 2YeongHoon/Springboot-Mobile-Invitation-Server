package com.mobileinvitation.model.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity extends TimeEntity {

    //    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(unique = true, nullable = false)
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
