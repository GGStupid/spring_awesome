package com.example.spring_awesome.controller;

import com.example.spring_awesome.common.api.CommonPage;
import com.example.spring_awesome.common.api.ResultData;
import com.example.spring_awesome.mbg.model.PmsBrand;
import com.example.spring_awesome.service.PmsBrandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @author:PmsBrandController
 * @date: 2021/7/23 14:42
 */
@Controller
@RequestMapping("/brand")
public class PmsBrandController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PmsBrandController.class);
	@Autowired
	private PmsBrandService demoService;


	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	@ResponseBody
	public List<String> getBrandList() {
		List<String> list = new ArrayList<>();
		list.add("aaa");
		return list;
	}

	@RequestMapping(value = "/listAll2", method = RequestMethod.GET)
	@ResponseBody
	public void getBrandList2() {
		throw  new RuntimeException("xxxxxxx");
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public ResultData createBrand(@RequestBody PmsBrand pmsBrand) {
		ResultData commonResult;
		int count = demoService.createBrand(pmsBrand);
		if (count == 1) {
			commonResult = ResultData.success(pmsBrand);
			LOGGER.debug("createBrand success:{}", pmsBrand);
		} else {
			commonResult = ResultData.fail(1, "操作失败");
			LOGGER.debug("createBrand fail:{}", pmsBrand);
		}
		return commonResult;
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	@ResponseBody
	public ResultData updateBrand(@PathVariable("id") Long id, @RequestBody PmsBrand pmsBrandDto,
								  BindingResult result) {
		ResultData commonResult;
		int count = demoService.updateBrand(id, pmsBrandDto);
		if (count == 1) {
			commonResult = ResultData.success(pmsBrandDto);
			LOGGER.debug("updateBrand success:{}", pmsBrandDto);
		} else {
			commonResult = ResultData.fail(1, "操作失败");
			LOGGER.debug("updateBrand fail:{}", pmsBrandDto);
		}
		return commonResult;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResultData deleteBrand(@PathVariable("id") Long id) {
		int count = demoService.deleteBrand(id);
		if (count == 1) {
			LOGGER.debug("deleteBrand success :id={}", id);
			return ResultData.success(null);
		} else {
			LOGGER.debug("deleteBrand fail :id={}", id);
			return ResultData.fail(1, "操作失败");
		}
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public ResultData<CommonPage<PmsBrand>> listBrand(
			@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
			@RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {
		List<PmsBrand> brandList = demoService.listBrand(pageNum, pageSize);
		return ResultData.success(CommonPage.restPage(brandList));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResultData<PmsBrand> brand(@PathVariable("id") Long id) {
		return ResultData.success(demoService.getBrand(id));
	}
}
