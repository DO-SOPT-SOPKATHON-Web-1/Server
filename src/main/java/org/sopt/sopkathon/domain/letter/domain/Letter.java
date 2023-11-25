package org.sopt.sopkathon.domain.letter.domain;

import jakarta.persistence.*;
import lombok.*;
import org.sopt.sopkathon.domain.user.domain.User;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Entity
public class Letter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "letter_id")
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String toEmail;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Color color;
    @Column(nullable = false)
    private String content;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public static Letter createLetter(String name, String toEmail, Color color, String content, User user) {
        Letter letter = Letter.builder()
                .name(name)
                .toEmail(toEmail)
                .color(color)
                .content(content)
                .build();
        letter.changeUser(user);
        return letter;
    }

    public void changeUser(User user) {
        if (this.user != null) {
            this.user.removeLetter(this);
        }
        this.user = user;
        user.addLetter(this);
    }
}
