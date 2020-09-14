package com.example.client.query.data.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class QueryService {

	@Autowired
	@Qualifier("mysql1db")
	DataSource dataSource;
	
	@Autowired
	Map<String, DataSource> datasources;


	public List<Map<String, Object>> getData(String query,String dsname) {
		System.out.println("dataSource " + dataSource);
		DataSource ds = datasources.get(dsname);
		JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);
		List<Map<String, Object>> list = jdbcTemplate.queryForList(query);
		return list;
	}

	public Set<String> getListOfDB() {
		System.out.println("list of data sources " + datasources);
		for (Map.Entry<String, DataSource> entry : datasources.entrySet()) {
			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		}
		return datasources.keySet();
	}
}
