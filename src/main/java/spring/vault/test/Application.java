package spring.vault.test;

import static org.springframework.boot.WebApplicationType.SERVLET;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class)
            .web(SERVLET)
            .run(args);
    }

    @RestController
    @RequestMapping("v1")
    public static class FakeVaultController {

        @GetMapping("sleep/{s}")
        public String slowguy20(
            @PathVariable("s") int s
        ) throws InterruptedException {
            Thread.sleep(s * 1000);
            return s + " seconds later...";
        }
    }

}
