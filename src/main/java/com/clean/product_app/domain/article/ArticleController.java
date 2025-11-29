package com.clean.product_app.domain.article;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description    : 영화 컨트롤러
 * packageName    : com.clean.product_app.domain.movie.controller
 * fileName       : ArticleController
 * author         : hyeonju
 * date           : 25. 7. 7.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 7. 7.        hyeonju             최초 생성
 */
@RestController
@RequiredArgsConstructor
@Slf4j
public class ArticleController {
    private final ArticleJdbcRepository articleJdbcRepository;

    @GetMapping("/insert-bulk")
    public String insertBulk() {
        int total = 1_000_000;
        int batchSize = 5_000;
        for (int i = 0; i < total / batchSize; i++) {
            articleJdbcRepository.batchInsertArticles(batchSize);
            log.info("Inserted: {}", (i + 1) * batchSize);
        }
        return "Insert Completed";
    }
}
