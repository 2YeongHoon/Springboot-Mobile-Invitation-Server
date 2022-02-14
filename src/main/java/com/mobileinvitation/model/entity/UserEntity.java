package com.mobileinvitation.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity extends TimeEntity {
    @Id
    @GeneratedValue
    @Column(name = "user_id", columnDefinition = "BINARY(16)")
    private UUID idx;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "weddinginfo_id")
    private WeddingInfoEntity weddingInfo;

    @Column(nullable = false, unique = true)
    private String userName;

    @Column(nullable = false)
    private String userPass;
}
