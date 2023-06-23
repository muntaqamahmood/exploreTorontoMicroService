package com.example.ec.exploretoronto.service;

import com.example.ec.exploretoronto.domain.Difficulty;
import com.example.ec.exploretoronto.domain.Region;
import com.example.ec.exploretoronto.domain.Tour;
import com.example.ec.exploretoronto.domain.TourPackage;
import com.example.ec.exploretoronto.repo.TourPackageRepository;
import com.example.ec.exploretoronto.repo.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TourService {
    private TourRepository tourRepository;
    private TourPackageRepository tourPackageRepository;
    @Autowired
    public TourService(TourRepository tourRepository, TourPackageRepository tourPackageRepository) {
        this.tourRepository = tourRepository;
        this.tourPackageRepository = tourPackageRepository;
    }

    public Tour createTour(String title, String description, String blurb,
                           Integer price, String duration, String bullets,
                           String keywords, String tourPackageName,
                           Difficulty difficulty, Region region) {
        TourPackage tourPackage = tourPackageRepository.findById(tourPackageName)
                .orElseThrow(() -> new RuntimeException("Tour Package not found!"));

        return tourRepository.save(new Tour(title, description, blurb,
                price, duration, bullets, keywords, tourPackage, difficulty,
                 region));
    }
    /**
     *Calculate number of Tours in the Database
     * @return the total
     * */
    public long total() {
        return tourRepository.count();
    }
}
