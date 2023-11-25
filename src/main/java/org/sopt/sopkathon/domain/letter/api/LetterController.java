package org.sopt.sopkathon.domain.letter.api;

import lombok.RequiredArgsConstructor;
import org.sopt.sopkathon.domain.letter.dto.request.LetterCreateRequest;
import org.sopt.sopkathon.domain.letter.dto.request.LettersColorRequest;
import org.sopt.sopkathon.domain.letter.dto.response.LetterDetailResponse;
import org.sopt.sopkathon.domain.letter.dto.response.LettersColorResponse;
import org.sopt.sopkathon.domain.letter.service.LetterService;
import org.sopt.sopkathon.global.common.ApiResponse;
import org.sopt.sopkathon.global.common.SuccessStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/all")
    public ResponseEntity<ApiResponse<?>> getLetterColors(@RequestBody LettersColorRequest request){
        LettersColorResponse response = letterService.getLetterColors(request);
        return ApiResponse.success(SuccessStatus.OK, response);
    }

    @GetMapping("/{letterId}")
    public ResponseEntity<ApiResponse<?>> getLetter(@PathVariable Long letterId){
        LetterDetailResponse response = letterService.getLetter(letterId);
        return ApiResponse.success(SuccessStatus.OK, response);
    }

    @PostMapping("/sprinkle")
    public ResponseEntity<ApiResponse<?>> sprinkleLetter(@RequestBody LettersColorRequest request){
        letterService.sprinkleLetter(request);
        return ApiResponse.success(SuccessStatus.OK);
    }
}
