package udemysdetqa.jsonandjavaobjects;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ExtractJsonToJavaObject {
    public static void main(String[] args) throws IOException {
        String jsonPath = System.getProperty("user.dir") + "\\JsonFiles\\customerInfoNew.json";

        ObjectMapper objectMapper = new ObjectMapper();
        CustomerDetails customerDetails = objectMapper.readValue(new File(jsonPath), CustomerDetails.class);
        int id = customerDetails.getCustomerNumber();
        String name = customerDetails.getCustomerName();
        String contactFirstName = customerDetails.getContactFirstName();
        String contactLastName = customerDetails.getContactLastName();
        String city = customerDetails.getCity();
        String country = customerDetails.getCountry();

        System.out.printf("%d - %s (%s %s) => %s : %s", id, name, contactFirstName, contactLastName, city, country);

    }

}
