package Pairings;

import java.util.Arrays;

import Pairings.Entities.Player;
import Pairings.Entities.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan(basePackages = {"Pairings"})
@EnableJpaRepositories(basePackages = {"Pairings.Entities"})
@EnableTransactionManagement
@EntityScan(basePackages="Pairings.Entities")
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);

    }
}