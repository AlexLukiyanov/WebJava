package ru.geekbrains.less2.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

@Configuration
@ComponentScan("ru.geekbrains.less2")
public class AppConfig {

    @Bean
    public FileOutputStream fileOut() throws FileNotFoundException {
        return new FileOutputStream("1.txt");
    }

}
