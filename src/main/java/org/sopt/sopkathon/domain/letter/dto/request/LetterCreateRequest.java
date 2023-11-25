package org.sopt.sopkathon.domain.letter.dto.request;

import org.sopt.sopkathon.domain.letter.domain.Color;

public record LetterCreateRequest(
        Long userId,
        String name,
        String toEmail,
        Color color,
        String content
) {
}
