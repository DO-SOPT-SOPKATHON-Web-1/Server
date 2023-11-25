package org.sopt.sopkathon.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.sopt.sopkathon.domain.user.domain.User;
import org.sopt.sopkathon.domain.user.dto.request.UserSaveRequest;
import org.sopt.sopkathon.domain.user.dto.response.UserSaveResponse;
import org.sopt.sopkathon.domain.user.repository.UserRepository;
import org.sopt.sopkathon.global.error.BusinessException;
import org.sopt.sopkathon.global.error.ErrorStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.sopt.sopkathon.domain.user.domain.User.createUser;

@RequiredArgsConstructor
@Transactional
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserSaveResponse saveUser(UserSaveRequest userSaveRequest) {
        validateDuplicateUser(userSaveRequest);
        User user = createUser(userSaveRequest.name(), null);
        User savedUser = userRepository.save(user);
        return new UserSaveResponse(savedUser.getId());
    }

    private void validateDuplicateUser(UserSaveRequest userSaveRequest) {
        if (userRepository.existsByName(userSaveRequest.name())) {
            throw new BusinessException(ErrorStatus.DUPLICATE_USER);
        }
    }
}
