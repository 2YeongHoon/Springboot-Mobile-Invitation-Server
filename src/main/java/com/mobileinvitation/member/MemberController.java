package com.mobileinvitation.member;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * 회원 컨트롤러
 */
@Tag(name = "회원")
@RequestMapping("/member")
@RestController
@RequiredArgsConstructor
public class MemberController {

    @Operation(summary = "[미구현] 회원가입", tags = "회원")
    @ResponseStatus(value = HttpStatus.CREATED)
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Created"),
    })
    @PostMapping("{id}/password/{password}")
    public ResponseEntity<Void> registerMember(
        @PathVariable("id") Long memberId,
        @PathVariable("password") Long passwordId) {
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "[미구현] 회원조회", tags = "회원")
    @ResponseStatus(value = HttpStatus.OK)
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Success"),
        @ApiResponse(responseCode = "404", description = "존재하는 회원이 없습니다.")
    })
    @GetMapping("{id}")
    public ResponseEntity<Void> retrieveMember(
        @PathVariable("id") Long memberId) {
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
