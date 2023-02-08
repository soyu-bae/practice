package com.magnumbridge.BOSS.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
public abstract class BaseAuditingTimeEntity<T extends AbstractAggregateRoot<T>> extends AbstractAggregateRoot<T> implements Cloneable {
  @CreatedDate
  @Column(updatable = false)
  @Comment("최초생성일시")
  private LocalDateTime createdAt;

  @CreatedBy
  @Column(columnDefinition = "UUID", updatable = false)
  @Comment("최초생성자")
  private UUID createdBy;

  @LastModifiedDate
  @Comment("마지막수정일시")
  private LocalDateTime lastModifiedAt;

  @LastModifiedBy
  @Column(columnDefinition = "UUID")
  @Comment("마지막수정자")
  private UUID lastModifiedBy;

  @Column(columnDefinition = "UUID")
  @Comment("삭제일시")
  private LocalDateTime deletedAt;

  @Column(columnDefinition = "UUID")
  @Comment("마지막삭제자")
  private UUID deletedBy;

  public BaseAuditingTimeEntity(UUID createdBy, UUID lastModifiedBy){
    this.createdBy = createdBy;
    this.lastModifiedBy = lastModifiedBy;
  }

  public BaseAuditingTimeEntity(UUID lastModifiedBy){
    this.lastModifiedBy = lastModifiedBy;
  }
}
