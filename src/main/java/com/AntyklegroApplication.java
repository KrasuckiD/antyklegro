package com;

import com.domain.UserAccount;
import com.repository.UserAccountRepository;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AntyklegroApplication {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(AntyklegroApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AntyklegroApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(UserAccountRepository repository) {
        return args -> {
            repository.save(UserAccount.builder().login("DK").password("qwer").accountName("Kras")
                    .addressRegion("Wielkopolska").addressCity("Poznan").addressStreet("Katowicka")
                    .accountCreateDate("17.07.2018").accountStatus("active").accountTypePremium(true).build());

            repository.save(UserAccount.builder().login("DCz").password("tyui").accountName("Czech")
                    .addressRegion("Malopolska").addressCity("Kolo").addressStreet("Wloclawska")
                    .accountCreateDate("16.07.2018").accountStatus("active").accountTypePremium(false).build());

            repository.save(UserAccount.builder().login("ML").password("asdf").accountName("Lemon")
                    .addressRegion("Slask").addressCity("Smigiel").addressStreet("NieWiem")
                    .accountCreateDate("15.07.2018").accountStatus("inactive").accountTypePremium(false).build());

            repository.save(UserAccount.builder().login("LK").password("ghjk").accountName("Kwas")
                    .addressRegion("Zachodniopomorskie").addressCity("ZielonaGora").addressStreet("Jakas")
                    .accountCreateDate("14.07.2018").accountStatus("inactive").accountTypePremium(false).build());

            log.info("Users find witch findAll");
            log.info("_________________________________________");
            for (UserAccount user : repository.findAll()) {
                log.info(user.getAccountName());
            }
            log.info("_________________________________________");

        };
    }
}
