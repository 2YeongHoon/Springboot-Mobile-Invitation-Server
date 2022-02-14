package com.mobileinvitation.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VideoEntity {
    @Id
    @GeneratedValue
    private UUID idx;

    @Column
    private String videoName;

    @Column
    private String videoPath;
}
