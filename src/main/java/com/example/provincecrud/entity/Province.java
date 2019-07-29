package com.example.provincecrud.entity;

import javax.persistence.*;

@Entity
@Table(name = "Province")
public class Province {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "province_id")
    private int provinceId;
    @Column(name = "province_name")
    private String provinceName;
    @Column(name = "region")
    private  int region;

    public Province(String province_name,int region) {
        this.provinceName = province_name;
        this.region = region;
    }
    public Province(){

    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int province_id) {
        this.provinceId = province_id;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String province_name) {
        this.provinceName = province_name;
    }

    public int getRegion() {
        return region;
    }

    public void setRegion(int region) {
        this.region = region;
    }

}
