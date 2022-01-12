package com.ani.ormdemo.repository;

import com.ani.ormdemo.domain.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarCrudRepository extends CrudRepository<Car, Long> {
}
