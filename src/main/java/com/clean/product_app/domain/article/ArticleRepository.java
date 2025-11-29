package com.clean.product_app.domain.article;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * description    : 영화 저장소
 * packageName    : com.clean.product_app.domain.article
 * fileName       : ArticleRepository
 * author         : hyeonju
 * date           : 25. 7. 7.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 7. 7.        hyeonju             최초 생성
 */
public interface ArticleRepository extends JpaRepository<Article, Long> {
}
