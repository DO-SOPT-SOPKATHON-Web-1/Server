package org.sopt.sopkathon.domain.user.domain;

import jakarta.persistence.*;
import lombok.*;
import org.sopt.sopkathon.domain.letter.domain.Letter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    @Column(nullable = false)
    private String name;
    private String friendEmail;
    @OneToMany(mappedBy = "user")
    @Builder.Default
    private List<Letter> letters = new ArrayList<>();

    public static User createUser(String name, String friendEmail) {
        return User.builder()
                .name(name)
                .friendEmail(friendEmail)
                .build();
    }

    public void addLetter(Letter letter) {
        letters.add(letter);
    }

    public void removeLetter(Letter letter) {
        letters.remove(letter);
    }
}
