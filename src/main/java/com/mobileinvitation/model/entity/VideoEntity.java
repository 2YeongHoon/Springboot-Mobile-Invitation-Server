package com.mobileinvitation.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VideoEntity {
    @Id
    @GeneratedValue
//    @Column(name = "video_id")
    private Long idx;

    @Column
    private String videoName;

    @Column
    private String videoPath;

//    @ManyToOne
//    @JoinColumn(name = "weddinginfo_id")
//    private WeddingInfoEntity videoWeddingInfo;

}
