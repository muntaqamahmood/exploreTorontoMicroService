package com.example.ec.exploretoronto.repo;

import com.example.ec.exploretoronto.domain.Tour;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TourRepository extends CrudRepository<Tour, Integer> {
    // list of Tours the Tour Package is in
    Page<Tour> findByTourPackageCode(@Param("code") String tourPackage_code, Pageable pageable);
}
