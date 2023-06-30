package com.example.ec.exploretoronto.repo;

import com.example.ec.exploretoronto.domain.Tour;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

public interface TourRepository extends CrudRepository<Tour, Integer> {
    // list of Tours the Tour Package is in
    List<Tour> findByTourPackageCode(@Param("code") String tourPackage_code);
    //pagination of tours by its package code, url -> GET http://localhost:8080/tours/search/findByTourPackageCode?code=CC&size=2&sort=title,asc
    Page<Tour> findByTourPackageCode(@Param("code") String tourPackage_code, Pageable pageable);

    @Override
    @RestResource(exported = false)
    <S extends Tour> S save(S entity);

    @Override
    @RestResource(exported = false)
    <S extends Tour> Iterable<S> saveAll(Iterable<S> entities);

    @Override
    @RestResource(exported = false)
    void deleteById(Integer integer);

    @Override
    @RestResource(exported = false)
    void delete(Tour entity);

    @Override
    @RestResource(exported = false)
    void deleteAllById(Iterable<? extends Integer> integers);

    @Override
    @RestResource(exported = false)
    void deleteAll(Iterable<? extends Tour> entities);

    @Override
    @RestResource(exported = false)
    void deleteAll();

}
