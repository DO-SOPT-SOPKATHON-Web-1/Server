package org.sopt.sopkathon.domain.user.api;

import lombok.RequiredArgsConstructor;
import org.sopt.sopkathon.domain.user.dto.request.UserSaveRequest;
import org.sopt.sopkathon.domain.user.dto.response.UserSaveResponse;
import org.sopt.sopkathon.domain.user.service.UserService;
import org.sopt.sopkathon.global.common.ApiResponse;
import org.sopt.sopkathon.global.common.SuccessStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RequestMapping("/api/users")
@Controller
public class UserApiController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<ApiResponse<?>> saveUser(@RequestBody final UserSaveRequest userSaveRequest) {
        final UserSaveResponse userSaveResponse = userService.saveUser(userSaveRequest);
        return ApiResponse.success(SuccessStatus.CREATED, userSaveResponse);
    }
}
