package com.springcloud.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * @author oswin
 *
 **RibbonClient的configuration如果放到@SpringBootApplication的包或其子包下面
 **会导致所有的RibbonClient使用相同的configuration
 **如果您使用@ComponentScan（或@SpringBootApplication），则需要采取措施避免包含（例如将其放在一个单独的，不重叠的包中，或者指定要在@ComponentScan）。
 **或者在configuration目录创新一个Annotation，并使用line  27 方式
 */


@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "eureka-user", configuration = TestConfiguration.class)
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = ExcludeFromComponentScan.class)})
public class SpringdemoMovieRibbonApplication {
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringdemoMovieRibbonApplication.class, args);
	}
}
