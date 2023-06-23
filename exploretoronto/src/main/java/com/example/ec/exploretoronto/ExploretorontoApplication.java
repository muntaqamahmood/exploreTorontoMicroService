package com.example.ec.exploretoronto;

import com.example.ec.exploretoronto.service.TourPackageService;
import com.example.ec.exploretoronto.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//this is where our microservice starts with the main function and
public class ExploretorontoApplication implements CommandLineRunner {
	@Autowired
	private TourService tourService ;
	@Autowired
	private TourPackageService tourPackageService;
	public static void main(String[] args) {
		SpringApplication.run(ExploretorontoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		createTourPackages();
		long numOfPackages = tourPackageService.totalTourPackage();

		//load the tours from an external file
		createTours("ExploreToronto.json");
		long numOfTours = tourService.total();
	}

	private void createTours(String fileImport) {

	}

	public void createTourPackages(){
		tourPackageService.createTourPackage("TZ", "Toronto Zoo");
		tourPackageService.createTourPackage("NF", "Niagara Falls");
	}
}
