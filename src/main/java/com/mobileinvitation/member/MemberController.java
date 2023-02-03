package com.mobileinvitation.member;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 회원 컨트롤러
 */
@Tag(name = "회원")
@RequestMapping("/member")
@RestController
@RequiredArgsConstructor
public class MemberController {

}
