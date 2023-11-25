package org.sopt.sopkathon.domain.letter.repository;

import org.sopt.sopkathon.domain.letter.domain.Letter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LetterRepository extends JpaRepository<Letter, Long> {

}
