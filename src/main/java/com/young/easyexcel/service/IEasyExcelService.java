package com.young.easyexcel.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.young.easyexcel.model.EasyExcelModel;

import java.util.List;

/**
 * @author young
 * @version 1.0
 * @className IEasyExcelService
 * @date 2020/7/19 11:38
 */
public interface IEasyExcelService extends IService<EasyExcelModel> {

	void insertEasyExcel(List<EasyExcelModel> ems);
}
