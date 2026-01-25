package com.ravi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravi.entity.CricketerInfo;
import com.ravi.repository.ICricketerInfoRepository;

@Service
public class CricketerInfoServiceImpl implements ICricketerInfoService {

	@Autowired
	ICricketerInfoRepository repository;
	
	@Override
	public String registerCricketer(CricketerInfo info) {
		CricketerInfo save = repository.save(info);
		return "cricketer info is saved with id value: "+save.getCId();
	}

	@Override
	public List<CricketerInfo> showAllCricketer() {
		List<CricketerInfo> all = repository.findAll();
		return all;
	}

	@Override
	public CricketerInfo showCricketerById(Integer id) {
		CricketerInfo info=repository.findById(id).orElseThrow(()->new IllegalArgumentException("invalid id"));
		return info;
	}

}
