//package com.clean.product_app.domain.article;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//
///**
// * description    :
// * packageName    : com.clean.product_app.domain.article
// * fileName       : ArticleService
// * author         : hyeonju
// * date           : 25. 7. 7.
// * ===========================================================
// * DATE              AUTHOR             NOTE
// * -----------------------------------------------------------
// * 25. 7. 7.        hyeonju             최초 생성
// */
//@Service
//@RequiredArgsConstructor
//@Slf4j
//public class ArticleService {
//    private final ArticleRepository articleRepository;
//
//    public void createArticle(ArticleDto dto) {
//        final Article article = new Article();
//        article.setId(dto.getId());
//        article.setWriterId(dto.getWriterId());
//        article.setBoardId(dto.getBoardId());
//        article.setContent(dto.getContent());
//        articleRepository.save(article);
//    }
//}
