package com.hellowd;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ComponentScan
@SpringBootApplication
@PropertySources({@PropertySource("classpath:resources-${spring.profiles.active}/api.properties"),
		@PropertySource("classpath:resources-${spring.profiles.active}/db.properties")})
public class Application {

	@Autowired
	private MessageSource messageSource;

	@Bean
	public MessageSourceAccessor messageSourceAccessor() {
		return new MessageSourceAccessor(messageSource);
	}

	@Bean
	public Jackson2ObjectMapperBuilder configureObjectMapper() {
		//-- Hibernate module
		Hibernate4Module hbm = new Hibernate4Module();
		hbm.enable(Hibernate4Module.Feature.FORCE_LAZY_LOADING);
		hbm.disable(Hibernate4Module.Feature.USE_TRANSIENT_ANNOTATION);
		//-- Java time module
		JavaTimeModule jtm = new JavaTimeModule();
		jtm.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.ISO_DATE_TIME));
		//- Builder
		Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder() {
			@Override
			public void configure(ObjectMapper objectMapper) {
				super.configure(objectMapper);
				objectMapper.setVisibility(PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
				objectMapper.setVisibility(PropertyAccessor.IS_GETTER, JsonAutoDetect.Visibility.NONE);
				objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
			}
		};
		builder.serializationInclusion(JsonInclude.Include.NON_NULL);
		builder.featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		builder.modulesToInstall(hbm, jtm);
		return builder;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}
}
