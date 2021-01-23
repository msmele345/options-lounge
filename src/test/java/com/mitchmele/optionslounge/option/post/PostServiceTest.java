package com.mitchmele.optionslounge.option.post;

import com.mitchmele.optionslounge.option.model.Post;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PostServiceTest {

    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private PostService postService;

    @Test
    @DisplayName("Calls save on the repo")
    void savePost_callsSaveOnRepo() {

        Post newPost = Post.builder().id(1L).title("Bad Beat on AAPL").content("Bought 200 at 150.00").author("Bob").build();

        postService.savePost(newPost);

        verify(postRepository).save(newPost);
    }

    @Test
    @DisplayName("returns all posts")
    void getPosts_callsFindAllAndReturnsAllPosts() {

        Post post1 = Post.builder().id(1L).title("Bad Beat on AAPL").content("Bought 200 at 150.00").author("Bob").build();
        Post post2 = Post.builder().id(2L).title("Bad Beat on GOOG").content("Bought 20 at 250.00").author("FRED").build();

        List<Post> expected = asList(post1, post2);
        when(postRepository.findAll()).thenReturn(expected);

        List<Post> actual = postService.getPosts();

        assertThat(actual).isEqualTo(expected);
        verify(postRepository).findAll();
    }
}