package Client;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class ClientStart {
    public static void main(String[] args) {
        String line1 = "20.04.2022";
        String line2 = "25.04.2022";
        double money = 1000;

        RestTemplate restTemplate = new RestTemplate();
        double result = restTemplate.getForEntity("http://localhost:8081/CalculacteHolidayPay/" + line1 + "/" + line2 + "/" + money, double.class).getBody();
        System.out.println(result);
    }
}
