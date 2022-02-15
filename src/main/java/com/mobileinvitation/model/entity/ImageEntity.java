package com.mobileinvitation.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImageEntity {

    @Id
    @GeneratedValue
    private Long idx;

    @Column
    private String imageName;

    @Column
    private String imagePath;
}
