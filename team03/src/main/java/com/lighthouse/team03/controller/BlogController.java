package com.lighthouse.team03.controller;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.lighthouse.team03.entity.User;
import com.lighthouse.team03.mapper.ImageMapper;
import com.lighthouse.team03.mapper.User2Mapper;

@Controller
public class BlogController {
	@Autowired
	ImageMapper imageMapper;
	
	@PostMapping("value = /")
	public String uploadImafe(@RequestParam("image") MultipartFile imgFile, Model model) throws IOException {
	    byte[]img = imgFile.getBytes();
	    imageMapper.saveImage1(img);
	    
	    byte[]firstImg = imageMapper.getAllImages1().get(0);
	    
	    String encodedImage = Base64.getEncoder().encodeToString(firstImg);
	    
	    model.addAttribute("image", encodedImage);
	     return"failed_page";
	}

}