package com.mobileinvitation.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VideoEntity {
    @Id
    @GeneratedValue
    @Column(name = "video_id")
    private Long idx;

    @Column
    private String videoName;

    @Column
    private String videoPath;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private WeddingInfoEntity videoWeddingInfo;


}
