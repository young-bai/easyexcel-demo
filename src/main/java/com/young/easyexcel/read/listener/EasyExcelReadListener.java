package com.young.easyexcel.read.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.young.easyexcel.mapper.EasyExcelMapper;
import com.young.easyexcel.model.EasyExcelModel;
import com.young.easyexcel.service.IEasyExcelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author young
 * @version 1.0
 * @className EasyExcelReadListener
 * @date 2020/7/19 11:47
 */
@Slf4j
public class EasyExcelReadListener extends AnalysisEventListener<EasyExcelModel> {

	/**
	 * 每个长 SQL 插入的行数，可以根据数据库性能调整
	 */
	private final static int                  SIZE            = 1000;
	@Autowired
	private              IEasyExcelService    easyExcelService;
	//	40W
	private              List<EasyExcelModel> easyExcelModels = new ArrayList<>();

	public EasyExcelReadListener(IEasyExcelService easyExcelService) {
		this.easyExcelService = easyExcelService;
	}

	@Override
	public void invoke(EasyExcelModel easyExcel, AnalysisContext analysisContext) {
		easyExcelModels.add(easyExcel);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void doAfterAllAnalysed(AnalysisContext analysisContext) {
		log.info("进入到：doAfterAllAnalysed  方法中");
		long startTime = System.currentTimeMillis();
		List<List<EasyExcelModel>> lists = parseList(easyExcelModels);
		lists.parallelStream().forEach(ems -> {
			easyExcelService.insertEasyExcel(ems);
		});
		log.info("导入" + easyExcelModels.size() + "条数据到数据库 耗时 ： " + (System.currentTimeMillis() - startTime));
	}

	private <T> List<List<T>> parseList(List<T> list) {
		List<List<T>> streamList = new ArrayList<>();
		for (int i = 0; i < list.size(); i += SIZE) {
			int j = Math.min((i + SIZE), list.size());
			List<T> subList = list.subList(i, j);
			streamList.add(subList);
		}
		return streamList;
	}
}
