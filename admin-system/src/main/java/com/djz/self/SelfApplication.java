package com.djz.self;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;
;


@SpringBootApplication
@EnableSwagger2
@MapperScan(basePackages={"com.djz.self.modules.*.mapper"})
public class SelfApplication {

	public static void main(String[] args) {
		SpringApplication.run(SelfApplication.class, args);
	}
}
