package com.mobileinvitation.core.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * 최상위 엔티티
 *
 * <pre>
 * {@link #createId} 생성ID
 * {@link #createDt} 생성일
 * {@link #updateId} 업데이트ID
 * {@link #updateDt} 업데이트일
 * </pre>
 * */
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class RootEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @CreatedBy
  @Column(name = "create_id", nullable = false, updatable = false)
  protected String createId;

  @CreatedDate
  @Column(name = "create_dt", nullable = false, updatable = false)
  protected LocalDateTime createDt;

  @LastModifiedBy
  @Column(name = "update_id", nullable = false)
  protected String updateId;

  @LastModifiedDate
  @Column(name = "update_dt", nullable = false)
  protected LocalDateTime updateDt;
}
