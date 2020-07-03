package cn.walls1717.service;

import cn.walls1717.domain.Province;

import java.util.List;

public interface ProvinceService {

    List<Province> findAll();

    String findAllJson();
}
