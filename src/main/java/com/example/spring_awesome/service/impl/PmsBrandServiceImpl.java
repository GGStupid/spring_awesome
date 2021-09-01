package com.example.spring_awesome.service.impl;

import com.example.spring_awesome.mbg.mapper.PmsBrandMapper;
import com.example.spring_awesome.mbg.model.PmsBrand;
import com.example.spring_awesome.mbg.model.PmsBrandExample;
import com.example.spring_awesome.service.PmsBrandService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @author:PmsBrandServiceImpl
 * @date: 2021/7/23 14:56
 */
@Service
public class PmsBrandServiceImpl implements PmsBrandService {
//    123123
	@Autowired
	private PmsBrandMapper brandMapper;

	@Override
	public List<PmsBrand> listAllBrand() {
		return brandMapper.selectByExample(new PmsBrandExample());
	}

	@Override
	public int createBrand(PmsBrand brand) {
		return brandMapper.insertSelective(brand);
	}

	@Override
	public int updateBrand(Long id, PmsBrand brand) {
		brand.setId(id);
		return brandMapper.updateByPrimaryKeySelective(brand);
	}

	@Override
	public int deleteBrand(Long id) {
		return brandMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<PmsBrand> listBrand(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		return brandMapper.selectByExample(new PmsBrandExample());
	}

	@Override
	public PmsBrand getBrand(Long id) {
		return brandMapper.selectByPrimaryKey(id);
	}
}
