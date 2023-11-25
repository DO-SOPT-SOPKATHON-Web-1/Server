package org.sopt.sopkathon.domain.letter.api;

import lombok.RequiredArgsConstructor;
import org.sopt.sopkathon.domain.letter.dto.request.LetterCreateRequest;
import org.sopt.sopkathon.domain.letter.service.LetterService;
import org.sopt.sopkathon.global.common.ApiResponse;
import org.sopt.sopkathon.global.common.SuccessStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/letters")
@RequiredArgsConstructor
public class LetterController {

    private final LetterService letterService;

    @PostMapping
    public ResponseEntity<ApiResponse<?>> createLetter(@RequestBody LetterCreateRequest request){
        letterService.createLetter(request);
        return ApiResponse.success(SuccessStatus.CREATED);
    }

}
