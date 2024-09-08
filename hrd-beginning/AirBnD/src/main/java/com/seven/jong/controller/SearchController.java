package com.seven.jong.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/search")
public class SearchController {
	
	@GetMapping("/searchview")
	public String searchView() {
		System.out.println("searchview연결");
		return "search/searchview";
	}
}
