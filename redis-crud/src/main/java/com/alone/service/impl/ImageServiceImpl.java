package com.alone.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.alone.service.ImageService;
import com.alone.utils.FtpUtil;
import com.alone.utils.IDUtils;

/** 
  * ClassName: PrictureServiceImpl
  * date: 2018年4月24日 下午8:03:58 <br/> 
  * @author 项羽 
  * @version  
  * @since JDK 1.6 
  * @ DESC:	图片上传服务
  */  
@Service
public class ImageServiceImpl implements ImageService {

	@Value("${FTP_ADDRESS}")
	private String FTP_ADDRESS;
	
	@Value("${FTP_PORT}")
	private Integer FTP_PORT;
	
	@Value("${FTP_USERNAME}")
	private String FTP_USERNAME;
	
	@Value("${FTP_PASSWORD}")
	private String FTP_PASSWORD;
	
	@Value("${FTP_BASE_PATH}")
	private String FTP_BASE_PATH;
	
	@Value("${IMAGE_BASE_URL}")
	private String IMAGE_BASE_URL;
	
	@Override
	public Map<?, ?> uploadPicture(MultipartFile uploadFile) {
		Map<Object, Object> resultMap = new HashMap<>();
		try {
			//生成一个新的文件名
			//取原始文件名
			String oldName = uploadFile.getOriginalFilename();
			//生成一个新的文件名
			String newName = IDUtils.genImageName();
			//取旧文件名的后缀，添加给新的图片名称
			newName = newName + oldName.substring(oldName.lastIndexOf("."));
			//图片上传
			String imagePath = new DateTime().toString("/yyyy/MM/dd");
			boolean result = FtpUtil.  uploadFile(FTP_ADDRESS, FTP_PORT, FTP_USERNAME, FTP_PASSWORD, FTP_BASE_PATH, imagePath, newName, uploadFile.getInputStream());
			//返回结果
			if (!result) {
				resultMap.put("error", 1);
				resultMap.put("message","文件上传失败");
				return resultMap;
			}
			resultMap.put("error", 0);
			resultMap.put("url",IMAGE_BASE_URL + imagePath + "/" + newName);
			return resultMap;
		} catch (IOException e) {
			resultMap.put("error", 1);
			resultMap.put("message","文件上传异常");
			return resultMap;
		}
	}

}
