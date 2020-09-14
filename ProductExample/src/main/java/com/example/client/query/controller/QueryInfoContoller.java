package com.example.client.query.controller;

import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QueryInfoContoller {
	@Autowired
	Map<String, DataSource> datasources;

	@RequestMapping("/dblist")
	public Set<String> getListOfDB() {
		System.out.println("list of data sources " + datasources);
		// using for-each loop for iteration over Map.entrySet()
		for (Map.Entry<String, DataSource> entry : datasources.entrySet()) {
			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		}
		return  datasources.keySet();
	}
}
