package com.example.provincecrud.service;

import com.example.provincecrud.entity.Province;
import java.util.List;
import java.util.Optional;

public interface ProvinceService {
    List<Province> getAllProvince();

    void saveProvince(Province province);

    void deleteProvince(Integer ProvinceId);

    Optional<Province> findProvinceById(Integer provinceId);
}