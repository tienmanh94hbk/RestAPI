package com.example.provincecrud.repository;

import com.example.provincecrud.entity.Province;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinceRepository extends CrudRepository<Province, Integer> {}