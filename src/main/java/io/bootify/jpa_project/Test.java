package io.bootify.jpa_project;

import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import io.bootify.jpa_project.model.CustomerDTO;
import io.bootify.jpa_project.model.UserDTO;

public class Test
{
    public static void main(String[] args) throws JsonProcessingException {
        System.out.println(LocalDateTime.now());

        CustomerDTO c = new CustomerDTO();
        c.setCustId(111L);
        c.setThresholdAmt(50000L);
        c.setUtilizedThresholdAmt(30000L);
//        c.setCreatedDate(LocalDateTime.now());
//        c.setLastUpdated(LocalDateTime.now());

        UserDTO u = new UserDTO();
        u.setUserName("Admin");


        c.setUsr(u.getId());



        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(c);

        System.out.println(json);

    }

}
