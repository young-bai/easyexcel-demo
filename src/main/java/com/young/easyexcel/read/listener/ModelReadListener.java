package com.young.easyexcel.read.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.young.easyexcel.model.MallOrder;
import com.young.easyexcel.model.Model;
import com.young.easyexcel.service.IMallOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author young
 * @version 1.0
 * @className EasyExcelReadListener
 */
@Slf4j
public class ModelReadListener extends AnalysisEventListener<Model> {

	/**
	 * 每个长 SQL 插入的行数，可以根据数据库性能调整
	 */
	private final static int               SIZE = 1000;
	@Autowired
	private              IMallOrderService mallOrderService;
	private              List<Model>   objs = new ArrayList<>();

	public ModelReadListener() {

	}

	@Override
	public void invoke(Model o, AnalysisContext analysisContext) {
		objs.add(o);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void doAfterAllAnalysed(AnalysisContext analysisContext) {
		log.info("进入到：doAfterAllAnalysed  方法中");
		long startTime = System.currentTimeMillis();


		objs.forEach(obj ->{
			if(null == obj.getAmount()){
				System.out.println("");
			}
		});
		List<List<Model>> lists = parseList(objs);
		System.out.println(lists);
		//		lists.parallelStream().forEach(orders -> {
////			orders.forEach(order ->{
////				mallOrderService.save(order);
////			});
//			mallOrderService.insertOrders(orders);
//		});
		log.info("导入" + objs.size() + "条数据到数据库 耗时 ： " + (System.currentTimeMillis() - startTime));
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
