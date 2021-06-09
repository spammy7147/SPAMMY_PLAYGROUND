package com.seven.jong.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class SearchController {
	
	@GetMapping("search/searchview")
	public String searchView() {
		System.out.println("searchview연결");
		return "search/searchview";
	}
}
