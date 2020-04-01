package com.djz.self;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;
;



@SpringBootApplication
@EnableTransactionManagement
@EnableSwagger2
@MapperScan("com.djz.self")
public class SelfApplication {

	public static void main(String[] args) {
		SpringApplication.run(SelfApplication.class, args);
	}
}
