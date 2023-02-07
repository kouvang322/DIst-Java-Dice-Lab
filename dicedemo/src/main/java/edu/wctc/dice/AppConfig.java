package edu.wctc.dice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("edu.wctc.dice")
public class AppConfig {
//    @Bean
//    public GameInput gameInput(){
//        return new ConsoleInput();
//    }
//
//    @Bean
//    public GameOutput gameOutput() {
//        return new ConsoleOutput();
//    }
//
    @Bean
    public GameInput gameInput() {
        return new PopupInput();
    }

    @Bean
    public GameOutput gameOutput() {
        return new PopupOutput();
    }

//    @Bean
//    public DieRoller sixSided(){
//        return new SixSidedDie();
//    }

    @Bean
    public DieRoller eightSided(){
        return new EightSidedDie();
    }

}
