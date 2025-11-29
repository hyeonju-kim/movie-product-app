package com.clean.product_app.domain.article;

import com.clean.product_app.common.util.SnowflakeIdGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * description    : 영화 JDBC 저장소
 * packageName    : com.clean.product_app.domain.article
 * fileName       : ArticleJdbcRepository
 * author         : hyeonju
 * date           : 25. 7. 7.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 7. 7.        hyeonju             최초 생성
 */
@Repository
@RequiredArgsConstructor
public class ArticleJdbcRepository {

    private final JdbcTemplate jdbcTemplate;
    private final SnowflakeIdGenerator snowflakeIdGenerator;

    public void batchInsertArticles(int batchSize) {
        List<Object[]> batchArgs = new ArrayList<>();
        for (int i = 0; i < batchSize; i++) {
            batchArgs.add(new Object[]{
                    snowflakeIdGenerator.generateId(), // idx
                    "writer_" + (i % 100),
                    (i % 10) + 1L,
                    "Sample content " + i,
                    LocalDateTime.now(),
                    LocalDateTime.now()
            });
        }

        jdbcTemplate.batchUpdate(
                "INSERT INTO tb_article (idx, writer_id, board_id, content, created_at, updated_at) " +
                        "VALUES (?, ?, ?, ?, ?, ?)", batchArgs);
    }
}
