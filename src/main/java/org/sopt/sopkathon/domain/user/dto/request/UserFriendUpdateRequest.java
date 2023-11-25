package org.sopt.sopkathon.domain.user.dto.request;

public record UserFriendUpdateRequest(
        Long userId,
        String friendEmail,
        String friendName
) {
}
