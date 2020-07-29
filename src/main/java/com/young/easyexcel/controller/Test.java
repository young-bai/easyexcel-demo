package com.young.easyexcel.controller;

import java.util.ArrayList;
import java.util.List;

public class Test {
	/**
	 * 每个长 SQL 插入的行数，可以根据数据库性能调整
	 */
	private final static int SIZE = 10;
	public static void main(String[] args) {
		List<String> strings = new ArrayList<>(10000);
		for (int i = 0; i < 10000; i++) {
				strings.add("" + i);
		}
		List<List<String>> lists = parseList(strings);
	}
	private static  <T> List<List<T>> parseList(List<T> list) {
		List<List<T>> streamList = new ArrayList<>();
		for (int i = 0; i < list.size(); i += SIZE) {
			int j = Math.min((i + SIZE), list.size());
			List<T> subList = list.subList(i, j);
			streamList.add(subList);
		}
		return streamList;
	}
}
