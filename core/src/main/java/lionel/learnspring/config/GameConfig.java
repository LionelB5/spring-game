package lionel.learnspring.config;

import lionel.learnspring.GuessCount;
import lionel.learnspring.MaxNumber;
import lionel.learnspring.MinNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config/game.properties")
public class GameConfig {

    @Value("${game.maxNumber:20}")
    private int maxNumber;

    @Value("${game.minNumber:0}")
    private int minNumber;

    @Value("${game.maxCount:5}")
    private int guessCount;

    @Bean
    @MaxNumber
    public int maxNumber() {
        return maxNumber;
    }

    @Bean
    @GuessCount
    public int guessCount() {
        return guessCount;
    }

    @Bean
    @MinNumber
    public int minNumber() {
        return minNumber;
    }

}
