package org.sopt.sopkathon.domain.letter.dto.response;

import org.sopt.sopkathon.domain.letter.domain.Color;

public record LetterDetailResponse(
        String toName,
        Color color,
        String content,
        String fromName
) {
    public static LetterDetailResponse of(String toName, Color color, String content, String fromName) {
        return new LetterDetailResponse(toName, color, content, fromName);
    }
}
