package com.seven.jong.service;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.seven.jong.DTO.FaqDTO;

public interface CsService {

	ArrayList<FaqDTO> faq(Model model);

}
