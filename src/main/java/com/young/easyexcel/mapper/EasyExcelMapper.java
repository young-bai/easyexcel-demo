package com.young.easyexcel.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.young.easyexcel.model.EasyExcelModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author youn
 * @version 1.0
 * @className EasyExcelMapper
 * @date 2020/7/19 11:42
 */
public interface EasyExcelMapper extends BaseMapper<EasyExcelModel> {

	/**
	 * @param easyExcelModels
	 */
	void insertEasyExcel(@Param("easyExcelModels") List<EasyExcelModel> easyExcelModels);
}
