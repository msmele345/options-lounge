package com.mitchmele.optionslounge;

import com.mitchmele.optionslounge.option.post.PostRepository;
import com.mitchmele.optionslounge.option.repository.OptionRepository;
import com.mitchmele.optionslounge.option.repository.TradeRepository;
import com.mitchmele.optionslounge.option.user.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = {UserRepository.class, OptionRepository.class, PostRepository.class})
@EnableMongoRepositories(basePackageClasses = TradeRepository.class)
public class OptionsLoungeApplication {

	public static void main(String[] args) {
		SpringApplication.run(OptionsLoungeApplication.class, args);
	}

}
