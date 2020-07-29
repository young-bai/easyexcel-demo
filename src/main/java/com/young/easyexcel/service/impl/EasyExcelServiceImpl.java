package com.young.easyexcel.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.young.easyexcel.mapper.EasyExcelMapper;
import com.young.easyexcel.model.EasyExcelModel;
import com.young.easyexcel.service.IEasyExcelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author young
 * @version 1.0
 * @className EasyExcelServiceImpl
 * @date 2020/7/19 11:39
 */
@Service
@Slf4j
public class EasyExcelServiceImpl extends ServiceImpl<EasyExcelMapper,EasyExcelModel> implements IEasyExcelService {

	@Autowired
	EasyExcelMapper easyExcelMapper;

	@Override public void insertEasyExcel(List<EasyExcelModel> ems) {
		easyExcelMapper.insertEasyExcel(ems);
	}
}
