package com.mitchmele.optionslounge.option.services;

import com.mitchmele.optionslounge.option.model.Post;
import com.mitchmele.optionslounge.option.post.PostService;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("it-embedded")
@Tag("IT")
@SpringBootTest
class PostServiceIT {

    @Autowired
    private PostService postService;

    @Test
    void getMetadata_returnsAllDetailsFromRepoForProvidedSymbol() {
        Post post1 = Post.builder().id(1L).title("Bad Beat on AAPL").content("Bought 200 at 150.00").author("Bob").build();

        postService.savePost(post1);

        List<Post> actual = postService.getPosts();

        assertThat(actual).hasSize(1);
        assertThat(actual.get(0).getTitle()).isEqualTo("Bad Beat on AAPL");
        assertThat(actual.get(0).getContent()).isEqualTo("Bought 200 at 150.00");
        assertThat(actual.get(0).getAuthor()).isEqualTo("Bob");
    }
}