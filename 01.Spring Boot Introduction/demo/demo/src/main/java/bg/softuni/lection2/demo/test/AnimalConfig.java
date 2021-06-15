package bg.softuni.lection2.demo.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class AnimalConfig {

    @Profile("kitty-app")
    @Bean
    public Animal createCat() {
        return new Cat();
    }

    //    @Primary
    @Profile("doggy-app")
    @Bean
    public Animal createDog() {
        return new Dog();
    }
}
