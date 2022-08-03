package io.bootify.jpa_project;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.bootify.jpa_project.domain.Customer;
import io.bootify.jpa_project.domain.Usr;
import io.bootify.jpa_project.repos.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;


@SpringBootApplication
@Slf4j
public class JpaProjectApplication implements CommandLineRunner {

    @Autowired
    CustomerRepository customerRepository;
    public static void main(final String[] args) {
        SpringApplication.run(JpaProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Customer customer = customerRepository.save(
                Customer.builder()
                        .custId(999L)
                        .createdDate(LocalDateTime.now())
                        .lastUpdatedDate(LocalDateTime.now())
                        .thresholdAmt(50000L)
                        .utilizedThresholdAmt(40000L)
                        .usr(Usr.builder().userName("Shakti").lastUpdatedDate(LocalDateTime.now()).build())
                        .build());

        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        String jsonInString2 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(customer);
        System.out.println("------ "+jsonInString2);

        Thread.sleep(1000);

        log.info("user id by ALL --> "+customerRepository.findAll());
        log.info("user id by 19292 --> "+customerRepository.findByCustId(19292L));

        Customer custToUpdate = customerRepository.findByCustId(999L);
        custToUpdate.setCustId(909L);
        customerRepository.save(custToUpdate);
    }
}
