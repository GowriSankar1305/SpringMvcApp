package com.tectoro.mvc.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.tectoro.mvc.dto.AdminDto;
import com.tectoro.mvc.dto.ApiRequestDto;
import com.tectoro.mvc.dto.ApiResponse;
import com.tectoro.mvc.dto.ImageDto;
import com.tectoro.mvc.enums.GenderEnum;
import com.tectoro.mvc.enums.ImageEnum;
import com.tectoro.mvc.enums.SearchOperation;
import com.tectoro.mvc.enums.SqlClause;
import com.tectoro.mvc.service.AdminService;
import com.tectoro.mvc.service.ImageService;
import com.tectoro.mvc.utils.CommonUtils;

@Controller
@RequestMapping(value = "/superadmin/")
public class SuperAdminController {
	
	private static final Logger logger = LoggerFactory.getLogger(SuperAdminController.class);
	
	@Value("${superadmin.folder.path}")
	private String folderPath;
	@Autowired
	private AdminService adminService;
	@Autowired
	private ImageService imageService;
	
	@RequestMapping(value = "home",method = RequestMethod.GET)
	public String getSuperAdminDashBoard()	{
		logger.info("*************** Start of SuperAdminController.getSuperAdminDashBoard ***************");
		return "redirect:create-admin";
	}
	
	@RequestMapping(value = "create-admin",method = RequestMethod.GET)
	public ModelAndView createAdmin()	{
		ModelAndView mav = new ModelAndView(folderPath + "createAdmin");
		mav.addObject("genderList", Arrays.stream(GenderEnum.values()).collect(Collectors.toList()));
		return mav;
	}
	
	@RequestMapping(value = "validate-admin-email",method = RequestMethod.POST)
	 public @ResponseBody ApiResponse validateAdminEmail(@RequestBody ApiRequestDto request)	{
		logger.info("validateAdminEmail---------------------> {}",request.getEmailId());
		ApiResponse response = new ApiResponse();
		response.setEmailExists(false);
		if(null != adminService.getAdminByEmail(request.getEmailId()))	{
			response.setEmailExists(true);
		}
		return response;
	}
	
	@RequestMapping(value = "validate-admin-user-name",method = RequestMethod.POST)
	public @ResponseBody ApiResponse validateAdminUserName(@RequestBody ApiRequestDto request)	{
		logger.info("validateAdminUserName---------------------> {}",request.getUserName());
		ApiResponse response = new ApiResponse();
		response.setUserNameExists(false);
		if(null != adminService.getAdminByUserName(request.getUserName()))	{
			response.setUserNameExists(true);
		}
		return response;
	}
	
	@RequestMapping(value = "save-admin-details",method = RequestMethod.POST,consumes = "multipart/form-data")
	public String saveAdminDetails(@RequestParam("adminImage") MultipartFile multipartFile
			,@ModelAttribute AdminDto adminDto)	{
		logger.info("admin detils----------> {}",adminDto);
		adminDto = adminService.saveAdmin(adminDto);
		try	{
			if(null != multipartFile && multipartFile.getSize() > 0)	{
				String contentType = multipartFile.getContentType();
				String originalFileName = multipartFile.getOriginalFilename();
				String str[] = originalFileName.split(".");
				String extension = "." + str[str.length - 1];
				Long bytes = multipartFile.getSize();
				String imagePath = "resources/images/";
				String fileName = "admin_" + adminDto.getAdminId() + extension;
				
				BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
						new FileOutputStream(new File("classpath:resources/images/" + fileName)));
				bufferedOutputStream.write(multipartFile.getBytes());
				bufferedOutputStream.flush();
				bufferedOutputStream.close();
				
				if(Files.exists(Paths.get("classpath:resources/images/" + fileName)))	{
					ImageDto imageDto = new ImageDto();
					imageDto.setCreatedDate(LocalDateTime.now());
					imageDto.setFileExtension(extension);
					imageDto.setImagePath(imagePath);
					imageDto.setMimeType(contentType);
					imageDto.setImageSize(CommonUtils.bytesIntoHumanReadable(bytes));
					imageDto.setGeneratedFileName(fileName);
					imageDto.setIsDeleted((byte) 0);
					imageDto.setImageType(ImageEnum.ADMIN.name());
					imageDto.setAdminId(adminDto.getAdminId());
					imageService.saveOrUpdateImage(imageDto);
				}
			}
		}
		catch(Exception e)	{
			logger.error(">>>>>>>>>>>>>>> Exception while handling multipart"
					+ " file in saveAdminDetails:: {}",e);
		}
		return "redirect:create-admin";
	}
	
	@RequestMapping(value = "get-admins",method = RequestMethod.GET)
	public ModelAndView getAdministrators()	{
		ModelAndView mav = new ModelAndView(folderPath + "adminList");
		mav.addObject("sqlClauses", Arrays.stream(SqlClause.values()).collect(Collectors.toList()));
		mav.addObject("textOperations", SearchOperation.getTextFiledOperations());
		mav.addObject("dropdownOperations", SearchOperation.getDropdownOperations());
		mav.addObject("numberFieldOperations", SearchOperation.getNumberFieldOperations());
		mav.addObject("admins", adminService.getAllAdmins());
		return mav;
	}
}
