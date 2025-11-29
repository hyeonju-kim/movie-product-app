package com.clean.product_app.common.util;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import org.springframework.stereotype.Component;

/**
 * description    : SnowflakeId 생성기
 * packageName    : com.clean.product_app.common.util
 * fileName       : SnowflakeIdGenerator
 * author         : hyeonju
 * date           : 25. 7. 7.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 7. 7.        hyeonju             최초 생성
 */
@Component
public class SnowflakeIdGenerator {
    private final Snowflake snowflake;

    public SnowflakeIdGenerator() {
        this.snowflake = IdUtil.getSnowflake(1, 1); // workerId, datacenterId
    }

    public Long generateId() {
        return snowflake.nextId();  // 그대로 Long 반환
    }
}
