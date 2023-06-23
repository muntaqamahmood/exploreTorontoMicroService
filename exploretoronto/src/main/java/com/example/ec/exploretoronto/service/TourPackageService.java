package com.example.ec.exploretoronto.service;

import com.example.ec.exploretoronto.domain.Tour;
import com.example.ec.exploretoronto.domain.TourPackage;
import com.example.ec.exploretoronto.repo.TourPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TourPackageService {
    private TourPackageRepository tourPackageRepository;
    @Autowired
    public TourPackageService(TourPackageRepository tourPackageRepository) {
        this.tourPackageRepository = tourPackageRepository;
    }
    /**
     *Create a Tour Package
     * @param code code of the package
     * @param name name of the package
     * @return new or existing Tour Package
     * */
    public TourPackage createTourPackage(String code, String name) {
        return tourPackageRepository.findById(code)
                .orElse(tourPackageRepository.save(new TourPackage(code, name)));
    }

    /**
     *Look up all Tour Packages
     * @return all Tour Packages from the db
     */
    public Iterable<TourPackage> lookupTourPackage() {
        return tourPackageRepository.findAll();
    }
    /**
     *Total amount of Tour Packages
     * @return number of Tour Package
     * */
    public long totalTourPackage() {
        return tourPackageRepository.count();
    }

}
