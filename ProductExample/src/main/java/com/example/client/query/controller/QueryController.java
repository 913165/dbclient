package com.example.client.query.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.client.query.data.service.QueryService;

@Controller
public class QueryController {
	@Autowired
	QueryService queryService;

	@RequestMapping("/dbquery")
	public String viewHomePage(Model model, @Param("keyword") String keyword,@Param("test") String test) {
		System.out.println("QUery... : " + keyword);
		System.out.println("test... : " + test);
		Set<String> dblist = queryService.getListOfDB();
		model.addAttribute("dblist", dblist);
		List<String> headers = new ArrayList<String>();
		if (keyword != null) {
			List<Map<String, Object>> list = queryService.getData(keyword,test);
			System.out.println("list " + list);
			System.out.println("list " + list.get(0).keySet());
			model.addAttribute("rows", list);
			headers.addAll(list.get(0).keySet());
			model.addAttribute("headers", headers);
		}
		return "dbquery";
	}

}
