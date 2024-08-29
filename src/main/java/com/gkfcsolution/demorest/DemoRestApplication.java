package com.gkfcsolution.demorest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
@RestController
//@EnableScheduling
//@EnableSwagger2
public class DemoRestApplication extends SpringBootServletInitializer implements ApplicationRunner {

    @Value("${spring.application.name:DemoApp}")
    private String name;

//    private static final Logger logger = LoggerFactory.getLogger(DemoRestApplication.class);

    private static final Logger LOG =
            Logger.getLogger(DemoRestApplication.class.getName());

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

 /*   @Bean
    public Docket productApi(){
        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.gkfcsolution.demorest")).build();
    }*/

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        logger.info("This info message");
        logger.warn("This is warning message");
        logger.error("This is error message");
        return application.sources(DemoRestApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoRestApplication.class, args);
    }

    @RequestMapping("/")
    public String hello(){
        LOG.log(Level.INFO, "Index API is calling");
        return "Hello Frank";
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Hello World from Application Runner " + name);
    }

   /* @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/products").allowedOrigins("http://localhost:8080");
            }
        };
    }*/
}
