package com.aguillen.tournamentapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TournamentApplication {

	final static Logger LOG = LoggerFactory.getLogger(TournamentApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TournamentApplication.class, args);
		LOG.info( "The Tournament App is now running..." );
	}
	
}
