package com.clean.product_app.domain.movie.service.serviceImpl;

import com.clean.product_app.common.http.HttpClientWrapper;
import com.clean.product_app.domain.movie.entity.Movie;
import com.clean.product_app.domain.movie.repository.MovieRepository;
import com.clean.product_app.domain.movie.service.MovieService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nicole.user_app_common.domain.movie.controller.model.MovieResponse;
import com.nicole.user_app_common.domain.movie.controller.model.OpenApiResponse;
import com.nicole.user_app_common.domain.movie.service.command.MovieCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * description    : 영화 서비스 구현체
 * packageName    : com.clean.user_app.domain.movie.service.serviceImpl
 * fileName       : MovieServiceImpl
 * author         : 김현주
 * date           : 25. 6. 21.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 25. 6. 21.        김현주             최초 생성
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;
    private final HttpClientWrapper httpClientWrapper;
    private final ObjectMapper objectMapper;
    public static String MOVIE_API_URL = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json";
    public static String MOVIE_API_KEY = "ee170ae6b2dcb42e2c1499dae98b645e";
    public static String REQUEST_URL = MOVIE_API_URL + "?" + "key=" + MOVIE_API_KEY;

    @Override
    public List<MovieCommand> getMovieList(MovieCommand movieCommand) {
        Pageable pageable = PageRequest.of(movieCommand.getPNum() - 1, movieCommand.getPSize());

        Page<Movie> moviePage = movieRepository.findAll(pageable);
        List<Movie> movieList = moviePage.getContent();

        List<MovieCommand> movieCommandList = new ArrayList<MovieCommand>();
        for (Movie movie : movieList) {
            MovieCommand movieComm = new MovieCommand();
            movieComm.setId(movie.getId());
            movieComm.setMovieNm(movie.getMovieNm());
            movieComm.setMovieCd(movie.getMovieCd());
            movieComm.setRank(movie.getRank());
            movieComm.setRankInten(movie.getRankInten());
            movieComm.setOpenDt(movie.getOpenDt());
            movieComm.setAudiAcc(movie.getAudiAcc());
            movieComm.setScrnCnt(movie.getScrnCnt());
            movieComm.setShowCnt(movie.getShowCnt());
            movieComm.setSalesAmt(movie.getSalesAmt());
            movieComm.setAudiCnt(movie.getAudiCnt());
            movieComm.setManufacturedBy("kor");
            movieComm.setPrice("12000");
            movieCommandList.add(movieComm);
        }

        return movieCommandList;
    }

    @Override
    public List<MovieCommand> getOpenApiMovies() {
        String requestUrlFinal = REQUEST_URL + "&" + "targetDt=" + "20250620";

        String apiMovies = httpClientWrapper.get(requestUrlFinal, String.class);
        OpenApiResponse openApiResponse;
        try {
            openApiResponse = objectMapper.readValue(apiMovies, OpenApiResponse.class);
        } catch (JsonProcessingException e) {
            log.error("OpenAPI 응답 파싱 실패", e);
            throw new RuntimeException(e);
        }

        List<MovieResponse> movieResponses = openApiResponse.getBoxOfficeResult().getDailyBoxOfficeList();

        return movieResponses.stream()
                .map(MovieCommand::of)
                .toList();

    }


}
