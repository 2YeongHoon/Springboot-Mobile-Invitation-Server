package com.mobileinvitation.core.repository;

import com.mobileinvitation.core.entity.RootEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * 최상위 도메인 레파지토리
 */
@NoRepositoryBean
public interface DomainRepository<ENTITY extends RootEntity, IDENTITY>
    extends JpaRepository<ENTITY, IDENTITY>, JpaSpecificationExecutor<ENTITY>,
    QuerydslPredicateExecutor<ENTITY> {

}

