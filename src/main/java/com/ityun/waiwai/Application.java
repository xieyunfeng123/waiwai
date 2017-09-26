package com.ityun.waiwai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

//@RestController 因为我们例子是写一个web应用，因此写的这个注解，这个注解相当于同时添加@Controller和@ResponseBody注解。

//@EnableAutoConfiguration

//Spring Boot建议只有一个带有该注解的类。

//@EnableAutoConfiguration作用：
//Spring Boot会自动根据你jar包的依赖来自动配置项目。
//例如当你项目下面有HSQLDB的依赖时，Spring Boot会创建默认的内存数据库的数据源DataSource，如果你自己创建了DataSource，Spring Boot就不会创建默认的DataSource。

//如果你不想让Spring Boot自动创建，你可以配置注解的exclude属性，例如：

/**
 * @Configuration
 * @EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class}) public
 *                                                                       class
 *                                                                       MyConfiguration
 *                                                                       { }
 *
 */

// @SpringBootApplication

// 由于大量项目都会在主要的配置类上添加@Configuration,@EnableAutoConfiguration,@ComponentScan三个注解。

// 因此Spring Boot提供了@SpringBootApplication注解，该注解可以替代上面三个注解（使用Spring注解继承实现）。

@SpringBootApplication
// @EnableAutoConfiguration
@RestController
public class Application {
	// @RequestMapping("/")
	// public String greeting() {
	// return "Hello World!";
	// }

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
