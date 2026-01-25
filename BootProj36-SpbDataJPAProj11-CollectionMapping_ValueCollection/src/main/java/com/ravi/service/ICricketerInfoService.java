package com.ravi.service;

import java.util.List;

import com.ravi.entity.CricketerInfo;

public interface ICricketerInfoService {
public String registerCricketer(CricketerInfo info);
public List<CricketerInfo> showAllCricketer();
public CricketerInfo showCricketerById(Integer id);

}
