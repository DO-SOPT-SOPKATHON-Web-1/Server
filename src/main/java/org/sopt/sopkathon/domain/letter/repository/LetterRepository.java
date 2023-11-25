package org.sopt.sopkathon.domain.letter.repository;

import org.sopt.sopkathon.domain.letter.domain.Color;
import org.sopt.sopkathon.domain.letter.domain.Letter;
import org.sopt.sopkathon.domain.user.domain.User;
import org.sopt.sopkathon.global.error.BusinessException;
import org.sopt.sopkathon.global.error.ErrorStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LetterRepository extends JpaRepository<Letter, Long> {

    @Query("SELECT e.color FROM Letter e where e.user = :user")
    List<Color> findAllColorsByUser(User user);

    default Letter findByIdOrThrow(Long letterId){
        return findById(letterId)
                .orElseThrow(() -> new BusinessException(ErrorStatus.LETTER_NOT_FOUND));
    }
}
