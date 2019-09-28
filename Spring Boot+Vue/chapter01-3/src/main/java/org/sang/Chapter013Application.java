package org.sang;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuyanbin
 */
@SpringBootApplication
@RestController
public class Chapter013Application {
    @Value("${server.port}")
    private String port;
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name",defaultValue = "刘衍斌")String name) {
        return "hello jetty,"+name+"::"+port;
    }

    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(Chapter013Application.class);
        builder.application().setAdditionalProfiles("dev");
        builder.run(args);
//        SpringApplication.run(Chapter013Application.class, args);
    }
}
