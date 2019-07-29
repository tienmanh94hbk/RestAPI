package com.example.provincecrud.service.impl;

import com.example.provincecrud.service.ProvinceService;
import com.example.provincecrud.entity.Province;
import com.example.provincecrud.repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProvinceServiceImpl implements ProvinceService {
    @Autowired
    private ProvinceRepository provinceRepository;

    @Override
    public List<Province> getAllProvince() {
        return (List<Province>) provinceRepository.findAll();
    }

    @Override
    public Province saveProvince(Province user) {
        provinceRepository.save(user);
        return user;
    }

    @Override
    public void deleteProvince(Integer provinceId) {
        provinceRepository.deleteById(provinceId);
    }

    @Override
    public Optional<Province> findProvinceById(Integer provinceId) {
        return provinceRepository.findById(provinceId);
    }
}
