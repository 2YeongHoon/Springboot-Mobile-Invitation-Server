package com.mobileinvitation.invitation.repository;

import com.mobileinvitation.invitation.entity.QWeddingInfoEntity;
import com.mobileinvitation.invitation.entity.WeddingInfoEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class WeddingInfoEntityQueryRepository {

    private final JPAQueryFactory queryFactory;
    private final QWeddingInfoEntity qWeddingInfoEntity = QWeddingInfoEntity.weddingInfoEntity;

    public Optional<WeddingInfoEntity> findWeddingInfoByMemberId(Long memberId){
        WeddingInfoEntity weddingInfoEntity = queryFactory.selectFrom(qWeddingInfoEntity)
            .where(qWeddingInfoEntity.member.id.eq(memberId))
            .orderBy(qWeddingInfoEntity.updateDt.desc())
            .fetchOne();

        return Optional.ofNullable(weddingInfoEntity);
    }
}

