package com.mobileinvitation.invitation;

import com.mobileinvitation.invitation.dto.WeddingInfoRequest;
import com.mobileinvitation.invitation.service.ChangeWeddingInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * 웨딩정보 컨트롤러
 */
@Tag(name = "웨딩정보")
@RequestMapping("/wedding/member")
@RestController
@RequiredArgsConstructor
public class MobileInvitationController {

  private final ChangeWeddingInfoService changeWeddingInfoService;

  @Operation(summary = "웨딩정보 저장", tags = "웨딩정보")
  @ResponseStatus(value = HttpStatus.CREATED)
  @ApiResponses(value = {
      @ApiResponse(responseCode = "201", description = "Created"),
      @ApiResponse(responseCode = "404", description = "존재하는 회원이 없습니다.")
  })
  @PostMapping("{member-id}")
  public ResponseEntity<Void> registerWeddingInfo(
      @PathVariable("member-id") Long memberId,
      WeddingInfoRequest request) {

    changeWeddingInfoService.save(memberId, request);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @Operation(summary = "[미구현] 웨딩정보 조회", tags = "웨딩정보")
  @ResponseStatus(value = HttpStatus.OK)
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Success"),
      @ApiResponse(responseCode = "404", description = "존재하는 회원이 없습니다.")
  })
  @GetMapping("{member-id}")
  public ResponseEntity<Void> retrieveWeddingInfo(
      @PathVariable("member-id") String memberId) {

    return ResponseEntity.status(HttpStatus.OK).build();
  }
}
