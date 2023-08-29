package com.challenge.nisum.repository;

import com.challenge.nisum.model.City;
import com.challenge.nisum.model.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {
}
