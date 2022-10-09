import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

public class CalculacteTest {

    @Test
    public void test_1() {
        final String line1 = "20.04.2022";
        final String line2 = "25.04.2022";
        final double money = 1000;
        final double result = 2000.0;

        final RestTemplate restTemplate = new RestTemplate();
        final double res = restTemplate.getForEntity("http://localhost:8081/CalculacteHolidayPay/" + line1 + "/" + line2 + "/" + money, double.class).getBody();

        Assertions.assertEquals(result, res);
    }

    @Test
    public void test_2() {
        final String line1 = "03.10.2022";
        final String line2 = "09.10.2022";
        final double money = 500;
        final double result = 2500.0;

        final RestTemplate restTemplate = new RestTemplate();
        final double res = restTemplate.getForEntity("http://localhost:8081/CalculacteHolidayPay/" + line1 + "/" + line2 + "/" + money, double.class).getBody();

        Assertions.assertEquals(result, res);
    }

    @Test
    public void test_3() {
        final String line1 = "01.09.2022";
        final String line2 = "30.09.2022";
        final double money = 1000;
        final double result = 22000.0;

        final RestTemplate restTemplate = new RestTemplate();
        final double res = restTemplate.getForEntity("http://localhost:8081/CalculacteHolidayPay/" + line1 + "/" + line2 + "/" + money, double.class).getBody();

        Assertions.assertEquals(result, res);
    }

    @Test
    public void test_4() {
        final String line1 = "01.07.2022";
        final String line2 = "31.08.2022";
        final double money = 500;
        final double result = 21500.0;

        final RestTemplate restTemplate = new RestTemplate();
        final double res = restTemplate.getForEntity("http://localhost:8081/CalculacteHolidayPay/" + line1 + "/" + line2 + "/" + money, double.class).getBody();

        Assertions.assertEquals(result, res);
    }

}
