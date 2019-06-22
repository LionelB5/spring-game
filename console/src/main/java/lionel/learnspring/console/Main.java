package lionel.learnspring.console;

import lionel.learnspring.config.AppConfig;
import lionel.learnspring.Game;
import lionel.learnspring.MessageGenerator;
import lionel.learnspring.NumberGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        log.info("Guess The Number Game");

        // create context (container)
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);
        MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);

        log.info("main message = {}", messageGenerator.getMainMessage());
        log.info("result message = {}", messageGenerator.getResultMessage());

        int number = numberGenerator.next();

        log.info("number = {}", number);

        // get game bean from context (container)
        Game game = context.getBean(Game.class);

        // close context (container)
        context.close();
    }
}
