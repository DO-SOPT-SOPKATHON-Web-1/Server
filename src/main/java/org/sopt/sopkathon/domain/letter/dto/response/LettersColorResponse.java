package org.sopt.sopkathon.domain.letter.dto.response;

import org.sopt.sopkathon.domain.letter.domain.Color;

import java.util.List;

public record LettersColorResponse(
        String name,
        Integer letterCount,
        List<Color> colors
) {
    public static LettersColorResponse of(String name, Integer letterCount, List<Color> colors) {
        return new LettersColorResponse(name, letterCount, colors);
    }
}
