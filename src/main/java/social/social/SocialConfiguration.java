package social.social;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.social.config.annotation.SocialConfigurer;

import javax.sql.DataSource;

@Configuration
public class SocialConfiguration {

    @Primary
    @Bean
    public SocialConfigurer socialConfigurerAdapter(DataSource dataSource) {
        // https://github.com/spring-projects/spring-social/blob/master/spring-social-config/src/main/java/org/springframework/social/config/annotation/SocialConfiguration.java#L87
        return new DatabaseSocialConfigurer(dataSource);
    }

}
