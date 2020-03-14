package com.jeongje.webservice.service;

import com.jeongje.webservice.PostsSaveRequestDto;
import com.jeongje.webservice.domain.posts.Posts;
import com.jeongje.webservice.domain.posts.PostsRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PostsServiceTest {

    @Autowired
    private PostsService postsService;

    @Autowired
    private PostsRepository postsRepository;

    @AfterEach
    public void cleanup () {
        postsRepository.deleteAll();
    }

    @Test
    public void Dto데이터가_posts테이블에_저장된다 () {
        //given
        PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
                .author("jojoldu@gmail.com")
                .content("테스트")
                .title("테스트 타이틀")
                .build();

        //when
        postsService.save(dto);

        //then
        Posts posts = postsRepository.findAll().get(0);
        assertEquals(posts.getAuthor(),dto.getAuthor());
        assertEquals(posts.getContent(),dto.getContent());
        assertEquals(posts.getTitle(),dto.getTitle());
//        assertThat(posts.getAuthor()).isEqualTo(dto.getAuthor());
//        assertThat(posts.getContent()).isEqualTo(dto.getContent());
//        assertThat(posts.getTitle()).isEqualTo(dto.getTitle());
    }
}