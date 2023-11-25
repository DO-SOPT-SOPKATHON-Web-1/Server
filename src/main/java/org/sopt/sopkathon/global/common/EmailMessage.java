package org.sopt.sopkathon.global.common;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum EmailMessage {
    LETTER_TITLE("HAPPYDEATHDAY 편지가 도착했어요."),
    LETTER_CONTENT("안녕하세요.\n" +
            "HAPPYDEATHDAY입니다\uD83D\uDE0A\n" +
            "%s님께서 보내신 편지가 도착했습니다.\n" +
            "%s\n" +
            "이 편지는 고인이 생전에 사랑했던 이들이 죽음에 슬퍼하는 대신, 고인을 행복하게 추억할 수 있도록 미리 보내 둔 편지입니다.\n" +
            "%s님의 죽음에 슬퍼만 하기 보다는, 그와의 행복한 추억을 떠올려 보시는 건 어떨까요?\n" +
            "%s님의 HAPPY DEATH DAY를 위해. HDD 드림."),
    MATCHES_TITLE("HAPPYDEATHDAY의 성냥이 되셨어요!"),
    MATCHES_CONTENT("안녕하세요.\n" +
            "HAPPYDEATHDAY입니다\uD83D\uDE0A\n" +
            "%s님께서 %s님을 성냥으로 지정하셨습니다.\n" +
            "HDD는 고인이 생전에 사랑했던 이들이 죽음에 슬퍼하는 대신, 고인을 행복하게 추억할 수 있도록 미리 편지를 작성해둘 수 있는 서비스입니다.\n" +
            "%s님은 ‘불 붙이기’기능을 통해 %s님이 죽음을 맞이했을 때 편지들을 대신 전송해주실 수 있습니다. %s님이 죽은 후, 아래 링크에 접속해 불을 붙여 편지를 전송해주세요.\n" +
            "%s\n" +
            "%s님의 HAPPY DEATH DAY를 위해. HDD 드림.");

    private final String message;
}
