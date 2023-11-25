package org.sopt.sopkathon.domain.user.repository;

import org.sopt.sopkathon.domain.user.domain.User;
import org.sopt.sopkathon.global.error.BusinessException;
import org.sopt.sopkathon.global.error.ErrorStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByName(String name);

    Optional<User> findByName(String name);

    default User findByNameOrThrow(String name) {
        return findByName(name)
                .orElseThrow(() -> new BusinessException(ErrorStatus.USER_NOT_FOUND));
    }

    default User findByIdOrThrow(Long userId) {
        return findById(userId)
                .orElseThrow(() -> new BusinessException(ErrorStatus.USER_NOT_FOUND));
    }
}
