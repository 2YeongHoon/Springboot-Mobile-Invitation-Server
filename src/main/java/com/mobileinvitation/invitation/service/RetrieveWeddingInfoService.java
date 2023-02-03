package com.mobileinvitation.invitation.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 웨딩정보 조회 서비스
 */
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RetrieveWeddingInfoService {

}
