package org.sopt.sopkathon.domain.letter.dto.response;

import org.sopt.sopkathon.domain.letter.domain.Color;

import java.util.List;

public record LettersColorResponse(
        Integer letterCount,
        List<Color> colors
) {
    public static LettersColorResponse of(Integer letterCount, List<Color> colors) {
        return new LettersColorResponse(letterCount, colors);
    }
}
