package com.clean.product_app.domain.article;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * description    : 영화 Entity
 * packageName    : com.clean.product_app.domain.movie.entity;
 * fileName       : Article
 * author         : 김현주
 * date           : 25. 7. 7.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 7. 7.        김현주             최초 생성
 */
@Entity
@Getter
@Setter
@ToString
public class Article {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String writerId;
    private Long boardId;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}