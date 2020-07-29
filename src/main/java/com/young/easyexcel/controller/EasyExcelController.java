package com.young.easyexcel.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.young.easyexcel.model.EasyExcelModel;
import com.young.easyexcel.model.MallOrder;
import com.young.easyexcel.model.Model;
import com.young.easyexcel.read.listener.EasyExcelReadListener;
import com.young.easyexcel.read.listener.MallOrderReadListener;
import com.young.easyexcel.read.listener.ModelReadListener;
import com.young.easyexcel.service.IEasyExcelService;
import com.young.easyexcel.service.IMallOrderService;
import com.young.easyexcel.service.IRechargeCostOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.*;

/**
 * @author young
 * @version 1.0
 * @className EasyExcelController
 * @date 2020/7/19 11:46
 */
@Controller
@Slf4j
public class EasyExcelController {

	@Autowired
	private              IEasyExcelService         easyExcelService;
	@Autowired
	private              IMallOrderService         orderService;
	@Autowired
	private              IRechargeCostOrderService rechargeCostOrderService;
	private static final Integer                   SHEET_SIZE = 65535;

	@GetMapping("/template")
	public void template(HttpServletResponse response) throws IOException {
		//		response.setContentType("application/vnd.ms-excel");
		//		response.setCharacterEncoding("utf-8");
		//		String fileName = URLEncoder.encode("订单模板", "UTF-8");
		//		response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
		//		EasyExcel.write(response.getOutputStream(), MallOrder.class).sheet("order").doWrite(getList2());
	}

	@GetMapping("/template2")
	public void template2(HttpServletResponse response) throws IOException {
		response.setContentType("application/vnd.ms-excel");
		response.setCharacterEncoding("utf-8");
		String fileName = URLEncoder.encode("模板", "UTF-8");
		response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
		EasyExcel.write(response.getOutputStream(), EasyExcelModel.class).sheet("模板").doWrite(getList());
	}

	@PostMapping("/upload")
	@ResponseBody
	public String upload(HttpServletRequest request) throws IOException {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String,MultipartFile> fileMap = multipartRequest.getFileMap();
		for (Map.Entry<String,MultipartFile> entity : fileMap.entrySet()) {
			// 获取上传文件对象
			MultipartFile file = entity.getValue();
			EasyExcel.read(file.getInputStream(), EasyExcelModel.class, new EasyExcelReadListener(easyExcelService)).sheet().doRead();
		}
		return "success";
	}

	@PostMapping("/upload2")
	@ResponseBody
	public String upload2(HttpServletRequest request) throws IOException {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String,MultipartFile> fileMap = multipartRequest.getFileMap();
		for (Map.Entry<String,MultipartFile> entity : fileMap.entrySet()) {
			// 获取上传文件对象
			MultipartFile file = entity.getValue();
			ExcelReaderBuilder builder = EasyExcel.read(file.getInputStream(), MallOrder.class, new MallOrderReadListener(orderService));
			ExcelReader reader = builder.build();
			long startTime = System.currentTimeMillis();
			reader.readAll();
			log.info("导入Excel 共耗时 : {}毫秒", (System.currentTimeMillis() - startTime));
			//			List<ReadSheet> readSheets = reader.excelExecutor().sheetList();
			//			readSheets.forEach(readSheet -> {
			//				Integer sheetNo = readSheet.getSheetNo();
			//				String sheetName = readSheet.getSheetName();
			//				log.info("sheetNo: {}", sheetNo);
			//				log.info("sheetName: {}", sheetName);
			//				reader.read(readSheet);
			//			});
		}
		return "success";
	}

	@PostMapping("/upload3")
	@ResponseBody
	public String upload3(HttpServletRequest request) throws IOException {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String,MultipartFile> fileMap = multipartRequest.getFileMap();
		for (Map.Entry<String,MultipartFile> entity : fileMap.entrySet()) {
			// 获取上传文件对象
			MultipartFile file = entity.getValue();
			EasyExcel.read(file.getInputStream(), Model.class, new ModelReadListener()).sheet().doRead();
		}
		return "success";
	}

	@GetMapping("/download")
	public void download(HttpServletResponse response) throws IOException {
		response.setContentType("application/vnd.ms-excel");
		response.setCharacterEncoding("utf-8");
		String fileName = URLEncoder.encode("数据表格下载", "UTF-8");
		response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
		EasyExcel.write(response.getOutputStream(), EasyExcelModel.class).sheet("数据表格").doWrite(easyExcelService.list());
	}

	@GetMapping("/download2")
	public void download2(HttpServletResponse response) throws IOException {
		response.setContentType("application/vnd.ms-excel");
		response.setCharacterEncoding("utf-8");
		String fileName = URLEncoder.encode("数据表格下载", "UTF-8");
		response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
		ExcelWriter excelWriter = null;
		try {
			List<MallOrder> list = orderService.list();
			excelWriter = EasyExcel.write(response.getOutputStream(), MallOrder.class).build();
			List<List<MallOrder>> lists = preList(list);
			for (int i = 0; i < lists.size(); i++) {
				WriteSheet sheet = EasyExcel.writerSheet(i, "模板" + i).build();
				excelWriter.write(lists.get(i), sheet);
			}
		} catch (Exception e) {
		} finally {
			if (excelWriter != null) {
				excelWriter.finish();
			}
		}
		//		EasyExcel.write(response.getOutputStream(), MallOrder.class).sheet("数据表格").doWrite(orderService.list());
	}

	private List<EasyExcelModel> getList() {
		List<EasyExcelModel> list = new ArrayList<>();
		int num = 1000000;
		for (int i = 0; i < num; i++) {
			list.add(new EasyExcelModel(i + 1L, "张" + i, i + 1, "北京"));
		}
		return list;
	}

	private List<MallOrder> getList2() {
		List<MallOrder> list = new ArrayList<>();
		int num = 460000;
		for (int i = 0; i < num; i++) {
			list.add(new MallOrder(i, "order_" + i, "channel_" + i, "coop_" + i, "测试", "偷的", "mer_" + i, "pro_" + i, "规格_" + i, "待付款", BigDecimal.ONE.add(new BigDecimal(i)), BigDecimal.ONE.add(new BigDecimal(i)), "减免" + i + "元", BigDecimal.ZERO.add(new BigDecimal(i)), new Date(), new Date()));
		}
		return list;
	}

	private <T> List<List<T>> preList(List<T> list) {
		List<List<T>> lists = new ArrayList<>();
		if (null == list || list.isEmpty()) {
			return Collections.emptyList();
		}
		for (int i = 0; i < list.size(); i += SHEET_SIZE) {
			int min = Math.min((i + SHEET_SIZE), list.size());
			List<T> ts = list.subList(i, min);
			lists.add(ts);
		}
		return lists;
	}
}
