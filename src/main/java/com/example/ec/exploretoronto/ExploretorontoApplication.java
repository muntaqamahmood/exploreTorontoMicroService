package com.example.ec.exploretoronto;

import com.example.ec.exploretoronto.domain.Difficulty;
import com.example.ec.exploretoronto.domain.Region;
import com.example.ec.exploretoronto.service.TourPackageService;
import com.example.ec.exploretoronto.service.TourService;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

//this is where our microservice starts with the main function and
@SpringBootApplication
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
		try{
			createTourPackages();
			long numOfPackages = tourPackageService.totalTourPackage();
			//load the tours from an external file
			createTours("/D://LinkedInLearning//exploretoronto//exploretoronto//ExploreToronto.json/");
			long numOfTours = tourService.total();
		} catch (Exception e) {
			System.out.println("Error while creating Tour: " + e.getMessage());
			e.printStackTrace();
		}

	}

	// create Tours from external file data
	private void createTours(String fileImport) throws IOException {
		TourFromJSON.read(fileImport).forEach(importedTour ->
				tourService.createTour(importedTour.getTitle(),
						importedTour.getDescription(),
						importedTour.getBlurb(),
						importedTour.getPrice(),
						importedTour.getLength(),
						importedTour.getBullets(),
						importedTour.getKeywords(),
						importedTour.getPackageType(),
						importedTour.getDifficulty(),
						importedTour.getRegion()));
	}

	public void createTourPackages(){
		tourPackageService.createTourPackage("BC", "Backpack Tor");
		tourPackageService.createTourPackage("CC", "Toronto Calm");
		tourPackageService.createTourPackage("CH", "Toronto Hot springs");
		tourPackageService.createTourPackage("CY", "Cycle Toronto");
		tourPackageService.createTourPackage("DS", "From Desert to Sea");
		tourPackageService.createTourPackage("KC", "Kids Toronto");
		tourPackageService.createTourPackage("NW", "Nature Watch");
		tourPackageService.createTourPackage("SC", "Snowboard Toronto");
		tourPackageService.createTourPackage("TC", "Taste of Toronto");
	}

	/**
	* Helper class to import ExploreToronto.json file
	* */
	private static class TourFromJSON {
		// fields
		private String packageType, title, description, blurb, price, length,
				bullets, keywords, difficulty, region;

		// reader
		static List<TourFromJSON> read(String fileToImport) throws IOException {
			return new ObjectMapper().setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY)
					.readValue(new FileInputStream(fileToImport), new TypeReference<List<TourFromJSON>>() {
					});
		}

		protected TourFromJSON() {}

		String getPackageType() {
			return packageType;
		}

		String getTitle() {
			return title;
		}

		String getDescription() {
			return description;
		}

		String getBlurb() {
			return blurb;
		}

		Integer getPrice() {
			return Integer.parseInt(price);
		}

		String getLength() {
			return length;
		}

		String getBullets() {
			return bullets;
		}

		String getKeywords() {
			return keywords;
		}

		Difficulty getDifficulty() {
			return Difficulty.valueOf(difficulty);
		}

		Region getRegion() {
			return Region.findByLabel(region);
		}
	}
}
