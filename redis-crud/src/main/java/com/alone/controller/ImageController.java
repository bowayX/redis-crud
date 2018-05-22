package com.alone.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alone.service.ImageService;
import com.alone.utils.FtpUtil;

@Controller
public class ImageController {

	@Autowired
	private ImageService imageService;
	
	@RequestMapping(value="/images",method=RequestMethod.POST)
	/*
	 * @ResponseBody
	 * 1.相当于调用ResponseBody对象的result方法，向客户端写值
	 * 2.当返回的事java对象的时候，java对象是不能直接写入客户端的，就算写入，浏览器也解析不了
	 * 所以spring会将对象转换为一个json字符串
	 * **/
	public String imgagesUP(@RequestParam("file") MultipartFile file){
		
		Map<?, ?> uploadPicture = imageService.uploadPicture(file);
		System.out.println(uploadPicture);
		//若上传失败可能是json和map不兼容的问题，可以将map转换为json
		return "index";
	}
	@RequestMapping(value="/images",method=RequestMethod.GET)
	public String imgagesUP(){
		System.out.println("ImageController.imgagesUP()");
		return "index";
	}
}
