package com.social.enactive.bot.main;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import com.social.enactive.bot.configuration.log.Log;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@EnableAsync
@Configuration
@EnableAutoConfiguration
@EnableConfigurationProperties
@EnableEncryptableProperties
@ComponentScan({"com.social.enactive"})
@SpringBootApplication
public class SocialEnactiveImporterMain implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		Log.SYSTEM.info("Importer running with {}", args);
	}

}