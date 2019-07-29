package com.example.provincecrud.controller;

import com.example.provincecrud.entity.Province;
import com.example.provincecrud.service.ProvinceService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class ProvinceController {
    @Autowired private ProvinceService provinceService;

    @RequestMapping("/")
    public String showProvinces(){
        List<Province> provinces = provinceService.getAllProvince();
        Gson gson = new Gson();
        return gson.toJson(provinces);
    }

    @RequestMapping(value = "add",method = RequestMethod.POST)
    public Province addProvince(@Valid @RequestBody Province province){
        return provinceService.saveProvince(province);
    }

    @RequestMapping(value = "/edit/{provinceId}",method = RequestMethod.PUT)
    public ResponseEntity<Province> updateProvince(
            @PathVariable(value = "provinceId") Integer provinceId, @RequestBody Province provinceDetails)
            throws ResourceNotFoundException{
        Province province = provinceService.findProvinceById(provinceId).orElseThrow(()-> new ResourceNotFoundException("Province not found on :: "+ provinceId));
        province.setProvinceName(provinceDetails.getProvinceName());
        province.setRegion(provinceDetails.getRegion());
        final Province updateProvince = provinceService.saveProvince(province);
        return ResponseEntity.ok(updateProvince);
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public Province save(Province province){
        return provinceService.saveProvince(province);
    }

    @RequestMapping(value = "/delete/{provinceId}",method = RequestMethod.DELETE)
    public Map<String, Boolean> deleteProvince(@PathVariable(value = "provinceId")Integer provinceId){
        provinceService.findProvinceById(provinceId).orElseThrow(()-> new ResourceNotFoundException("Province not found :: "+provinceId));
        provinceService.deleteProvince(provinceId);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
