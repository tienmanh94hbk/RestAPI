package com.example.provincecrud.controller;

import com.example.provincecrud.entity.Province;
import com.example.provincecrud.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class ProvinceController {
    @Autowired private ProvinceService provinceService;

    @RequestMapping("/")
    public String index(Model model){
        List<Province> provinces = provinceService.getAllProvince();

        model.addAttribute("province", provinces);
        return "index";
    }

    @RequestMapping(value = "add")
    public String addProvince(Model model){
        model.addAttribute("province",new Province());
        return "addProvince";
    }

    @RequestMapping(value = "/edit",method = RequestMethod.GET)
    public String editProvince(@RequestParam("provinceId") Integer provinceId, Model model){
        Optional<Province> provinceEdit = provinceService.findProvinceById(provinceId);
        model.addAttribute("province", provinceEdit.get());
        return "editProvince";
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(Province province){
        provinceService.saveProvince(province);
        return "redirect:/";
    }

    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public String deleteProvince(@RequestParam("provinceId") Integer provinceId,Model model){
        provinceService.deleteProvince(provinceId);
        return "redirect:/";
    }
}
