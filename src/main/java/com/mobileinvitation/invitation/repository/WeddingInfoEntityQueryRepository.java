package com.mobileinvitation.invitation.repository;

import com.mobileinvitation.invitation.entity.QWeddingInfo;
import com.mobileinvitation.invitation.entity.WeddingInfo;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class WeddingInfoEntityQueryRepository {

  private final JPAQueryFactory queryFactory;
  private final QWeddingInfo qWeddingInfoEntity = QWeddingInfo.weddingInfo;

  public Optional<WeddingInfo> findWeddingInfoByMemberId(Long memberId) {
    WeddingInfo weddingInfoEntity = queryFactory.selectFrom(qWeddingInfoEntity)
        .where(qWeddingInfoEntity.member.id.eq(memberId))
        .orderBy(qWeddingInfoEntity.updateDt.desc())
        .fetchOne();

    return Optional.ofNullable(weddingInfoEntity);
  }
}

