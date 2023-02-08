package com.magnumbridge.BOSS.member.domain;

import com.magnumbridge.BOSS.common.entity.BaseAuditingTimeEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Member extends BaseAuditingTimeEntity<Member> {
  @Id
  @Column(name = "id", nullable = false)
  private UUID id;

  @Column(length = 20)
  private String userId;

  @Column(length = 200)
  private String password;

  private Integer memberNumber;

  @Column(length = 10)
  private String name;

  @Column(length = 8)
  private String birthday;

  @Column(length = 13)
  private String phoneNumber;

  @Column(length = 100)
  private String email;

  @Column(length = 8)
  private String startDate;

  private Float type; //enum

  private Float auth; //enum

  public void delete(UUID id) {
    this.setDeletedBy(id);
    this.setDeletedAt(LocalDateTime.now());
  }
}
