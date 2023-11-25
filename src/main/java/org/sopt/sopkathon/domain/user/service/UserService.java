package org.sopt.sopkathon.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.sopt.sopkathon.domain.user.domain.User;
import org.sopt.sopkathon.domain.user.dto.request.UserFriendUpdateRequest;
import org.sopt.sopkathon.domain.user.dto.request.UserSaveRequest;
import org.sopt.sopkathon.domain.user.dto.response.UserSaveResponse;
import org.sopt.sopkathon.domain.user.repository.UserRepository;
import org.sopt.sopkathon.global.common.EmailMessage;
import org.sopt.sopkathon.global.error.BusinessException;
import org.sopt.sopkathon.global.error.ErrorStatus;
import org.sopt.sopkathon.global.smtp.EmailProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.sopt.sopkathon.domain.user.domain.User.createUser;

@RequiredArgsConstructor
@Transactional
@Service
public class UserService {
    @Value("${email.matches-domain}")
    private String matchesUrl;
    private final UserRepository userRepository;
    private final EmailProvider emailProvider;

    public UserSaveResponse saveUser(UserSaveRequest userSaveRequest) {
        validateDuplicateUser(userSaveRequest);
        User user = createUser(userSaveRequest.name(), null);
        User savedUser = userRepository.save(user);
        return new UserSaveResponse(savedUser.getId());
    }

    public UserSaveResponse getUserId(UserSaveRequest userSaveRequest) {
        User findUser = userRepository.findByNameOrThrow(userSaveRequest.name());
        return new UserSaveResponse(findUser.getId());
    }

    public void updateFriendInfo(UserFriendUpdateRequest userFriendUpdateRequest) {
        User findUser = findUser(userFriendUpdateRequest);
        String name = findUser.getName();
        String friendName = userFriendUpdateRequest.friendName();
        String friendEmail = userFriendUpdateRequest.friendEmail();
        updateFriendInfo(findUser, friendEmail, friendName);
        sendEmailToFriend(friendEmail, name, friendName, findUser);
    }

    private void validateDuplicateUser(UserSaveRequest userSaveRequest) {
        if (userRepository.existsByName(userSaveRequest.name())) {
            throw new BusinessException(ErrorStatus.DUPLICATE_USER);
        }
    }

    private User findUser(UserFriendUpdateRequest userFriendUpdateRequest) {
        return userRepository.findByIdOrThrow(userFriendUpdateRequest.userId());
    }

    private void updateFriendInfo(User user, String friendEmail, String friendName) {
        user.updateFriendEmail(friendEmail);
        user.updateFriendName(friendName);
    }

    private void sendEmailToFriend(String friendEmail, String name, String friendName, User findUser) {
        emailProvider.sendMail(friendEmail, String.format(EmailMessage.MATCHES_TITLE.getMessage()),
                String.format(EmailMessage.MATCHES_CONTENT.getMessage(), name, friendName, friendName,
                        name, friendName, matchesUrl + findUser.getId(), name));
    }
}
