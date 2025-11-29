package com.clean.product_app.domain.article;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * description    : 영화 DTO
 * packageName    : com.clean.product_app.domain.article
 * fileName       : ArticleDto
 * author         : hyeonju
 * date           : 25. 7. 7.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 7. 7.        hyeonju             최초 생성
 */
@Data
public class ArticleDto {
    private Long id;
    private String writerId;
    private Long boardId;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
