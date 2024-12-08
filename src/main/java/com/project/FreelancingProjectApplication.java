package com.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FreelancingProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FreelancingProjectApplication.class, args);
	}

	
	/*
	 * @Bean public BCryptPasswordEncoder passwordEncoder() { return new
	 * BCryptPasswordEncoder(); // will be available as a dependency in any other
	 * spring bean }
	 */

	
//	@Bean //equivalent to <bean id ..../> in xml file
//	//use cases-->for configuration 3rd party java classes as spring beans
//	public ModelMapper modelMapper() {
//		ModelMapper modelMapper = new ModelMapper();	
//		modelMapper.getConfiguration().
//		setMatchingStrategy(MatchingStrategies.STRICT) //only MATCHING prop names and data types between src n dest will be transferred , during the mapping
//		.setPropertyCondition(Conditions.isNotNull());// only non null properties will be transferred from src --> dest , during the mapping
//	return modelMapper;
//	//returns configure modelMapper instance to the caller-->SC
//	}
}
