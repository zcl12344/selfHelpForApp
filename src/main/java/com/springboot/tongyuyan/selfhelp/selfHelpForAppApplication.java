package com.springboot.tongyuyan.selfhelp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan("com.springboot.tongyuyan.selfhelp.winter.mapper")//将项目中对应的mapper类的路径加进来就可以了
public class selfHelpForAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(selfHelpForAppApplication.class, args);
	}


	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer(){
		return new EmbeddedServletContainerCustomizer() {
			@Override
			public void customize(ConfigurableEmbeddedServletContainer Container) {
				Container.setSessionTimeout(20);//单位为S
			}
		};
	}



}
