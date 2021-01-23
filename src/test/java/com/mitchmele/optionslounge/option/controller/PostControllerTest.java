package com.mitchmele.optionslounge.option.controller;

import com.mitchmele.optionslounge.option.model.Post;
import com.mitchmele.optionslounge.option.post.PostService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import static java.util.Arrays.asList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(MockitoExtension.class)
class PostControllerTest {

    @Mock
    private PostService postService;

    @InjectMocks
    private PostController postController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(postController).build();
    }

    @Test
    void getAllPosts_callsServiceAndReturnsAllPostsInRepo() throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        Post post1 = Post.builder().id(1L).title("Bad Beat on AAPL").content("Bought 200 at 150.00").author("Bob").build();
        Post post2 = Post.builder().id(2L).title("Bad Beat on GOOG").content("Bought 20 at 250.00").author("FRED").build();

        List<Post> posts = asList(post1, post2);
        when(postService.getPosts()).thenReturn(posts);

        mockMvc.perform(get("/api/v1/posts"))
                .andExpect(status().isOk())
                .andExpect(content().string(mapper.writeValueAsString(posts)));

        verify(postService).getPosts();
    }

    @Test
    void savePost_savesNewPostFromRequestBody_callsService() throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        Post post1 = Post.builder().id(1L).title("Bad Beat on AAPL").content("Bought 200 at 150.00").author("Bob").build();

        mockMvc.perform(post("/api/v1/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(post1)))
                .andExpect(status().isOk())
                .andExpect(content().string("Success"));

        verify(postService).savePost(post1);
    }
}