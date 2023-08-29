package com.challenge.nisum.repository;

import com.challenge.nisum.model.City;
import com.challenge.nisum.model.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {

    Optional<City> findByIdAndCountryId(Long id, Long countryId);
}
