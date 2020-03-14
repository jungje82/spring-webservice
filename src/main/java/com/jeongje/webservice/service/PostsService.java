package com.jeongje.webservice.service;

import com.jeongje.webservice.PostsMainResponseDto;
import com.jeongje.webservice.PostsSaveRequestDto;
import com.jeongje.webservice.domain.posts.PostsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@AllArgsConstructor
@Service
public class PostsService {
    private PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto dto){
        return postsRepository.save(dto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public List<PostsMainResponseDto> findAllDesc() {
        long count = 0;
        List<String> names = Arrays.asList("jeong", "pro", "jdk", "java");

        names.stream().filter(x -> x.contatins("o")).count();


        return postsRepository.findAllDesc()
                .map(PostsMainResponseDto::new)
                .collect(Collectors.toList());
    }

}
