package com.tectoro.mvc.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
import com.tectoro.mvc.dto.CityDto;
import com.tectoro.mvc.dto.CountryDto;
import com.tectoro.mvc.dto.FacilityDto;
import com.tectoro.mvc.dto.ImageDto;
import com.tectoro.mvc.dto.PaginationDto;
import com.tectoro.mvc.dto.RoomTypeDto;
import com.tectoro.mvc.dto.StateDto;
import com.tectoro.mvc.enums.GenderEnum;
import com.tectoro.mvc.enums.ImageEnum;
import com.tectoro.mvc.enums.SearchOperation;
import com.tectoro.mvc.enums.SqlClause;
import com.tectoro.mvc.service.AdminService;
import com.tectoro.mvc.service.CityService;
import com.tectoro.mvc.service.CountryService;
import com.tectoro.mvc.service.FacilityService;
import com.tectoro.mvc.service.ImageService;
import com.tectoro.mvc.service.RoomTypeService;
import com.tectoro.mvc.service.StateService;
import com.tectoro.mvc.utils.CommonUtils;

@Controller
@RequestMapping(value = "/superadmin/")
public class SuperAdminController {
	
	private static final Logger logger = LoggerFactory.getLogger(SuperAdminController.class);
	
	@Value("${superadmin.folder.path}")
	private String folderPath;
	@Value("${images.path}")
	private String resourcePath;
	@Autowired
	private AdminService adminService;
	@Autowired
	private ImageService imageService;
	@Autowired
	private RoomTypeService roomTypeService;
	@Autowired
	private FacilityService facilityService;
	@Autowired
	private CountryService countryService;
	@Autowired
	private StateService stateService;
	@Autowired
	private CityService cityService;
	
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
	public String saveAdminDetails(@RequestParam MultipartFile adminImage
			,@ModelAttribute AdminDto adminDto)	{
		logger.info("admin detils----------> {}",adminDto);
		adminDto = adminService.saveAdmin(adminDto);
		try	{
			if(null != adminImage && adminImage.getSize() > 0)	{
				String contentType = adminImage.getContentType();
				String originalFileName = adminImage.getOriginalFilename();
				logger.info("contentType---------> {} , originalFileName--------> {}",contentType,originalFileName);
				String extension = "." + originalFileName.substring(originalFileName.lastIndexOf(".") + 1, originalFileName.length());
				Long bytes = adminImage.getSize();
				logger.info("resourcePath----------------> {}",resourcePath);
				String imagePath = "images/admin/";
				String fileName = resourcePath + imagePath + "admin_" + adminDto.getAdminId() + extension;
				BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
						new FileOutputStream(new File(fileName)));
				bufferedOutputStream.write(adminImage.getBytes());
				bufferedOutputStream.flush();
				bufferedOutputStream.close();
				
				if(Files.exists(Paths.get(fileName)))	{
					ImageDto imageDto = new ImageDto();
					imageDto.setCreatedDate(LocalDateTime.now());
					imageDto.setFileExtension(extension);
					imageDto.setImagePath(imagePath);
					imageDto.setMimeType(contentType);
					imageDto.setImageSize(CommonUtils.bytesIntoHumanReadable(bytes));
					imageDto.setGeneratedFileName("admin_" + adminDto.getAdminId() + extension);
					imageDto.setIsDeleted((byte) 0);
					imageDto.setImageType(ImageEnum.ADMIN.name());
					imageDto.setAdminId(adminDto.getAdminId());
					imageDto.setOriginalFileName(originalFileName);
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
	
	@RequestMapping(value = "room-types",method = RequestMethod.GET)
	public ModelAndView getRoomTypes()	{
		ModelAndView mav = new ModelAndView(folderPath + "roomTypes");
		mav.addObject("roomTypes", roomTypeService.getAllRoomTypes()); 
		return mav;
	}
	
	@RequestMapping(value = "save-document-types",method = RequestMethod.POST)
	public String saveTestData(@ModelAttribute RoomTypeDto roomTypeDto)	{
		roomTypeDto.setRoomTypeName(roomTypeDto.getRoomTypeName().toUpperCase());
		roomTypeService.saveRoomType(roomTypeDto);
		return "redirect:room-types";
	}
	
	@RequestMapping(value = "hotel-facilities",method = RequestMethod.GET)
	public ModelAndView getFacilities()	{
		ModelAndView mav = new ModelAndView(folderPath + "facilities");
		mav.addObject("facilities", facilityService.getAllFacilities());
		return mav;
	}
	
	@RequestMapping(value = "save-facility",method = RequestMethod.POST)
	public String saveFacilityDetails(@ModelAttribute FacilityDto facilityDto)	{
		facilityService.saveFacility(facilityDto);
		return "redirect:hotel-facilities";
	}
	
	@RequestMapping(value = "update-facility",method = RequestMethod.POST)
	public @ResponseBody List<FacilityDto> updateFacility(@RequestBody FacilityDto facilityDto)	{
		facilityService.saveFacility(facilityDto);
		return facilityService.getAllFacilities();
	}
	
	@RequestMapping(value = "get-hotel-facilities",method = RequestMethod.GET)
	public @ResponseBody List<FacilityDto> getAllFacilities()	{
		return facilityService.getAllFacilities();
	}
	
	@RequestMapping(value = "get-countries",method = RequestMethod.GET)
	public ModelAndView getCountries()	{
		List<PaginationDto> list = countryService.getPaginatedDataOfCountries();
		Optional<PaginationDto> dto = list.stream().filter(item -> item.getIsActive()).findAny();
		List<Long> ids = Stream.of(dto.get().getCommaSeparatedIds().split(","))
				.mapToLong(Long::parseLong).boxed().collect(Collectors.toList());
		logger.info("ids----------------> {}",ids);
		List<CountryDto> countries = countryService.getCountriesByIds(ids);
		ModelAndView mav = new ModelAndView(folderPath + "countries");
		mav.addObject("countries", countries);
		mav.addObject("numbers", list);
		return mav;
	}
	
	@RequestMapping(value = "get-countries-by-ids",method = RequestMethod.GET)
	public @ResponseBody List<CountryDto> getCountriesByIds(@RequestParam String ids)	{
		List<Long> nos = Stream.of(ids.split(","))
				.mapToLong(Long::parseLong).boxed().collect(Collectors.toList());
		return countryService.getCountriesByIds(nos);
	}
	
	@RequestMapping(value = "get-states",method = RequestMethod.GET)
	public ModelAndView getStates()	{
		ModelAndView mav = new ModelAndView(folderPath + "states");
		List<CountryDto> countryList = countryService.getAllCountries();
		List<PaginationDto> list = stateService.getPaginatedDataOfStatesBsdOnCountry(countryList.get(0).getCountryId());
		Optional<PaginationDto> dto = list.stream().filter(item -> item.getIsActive()).findAny();
		List<Long> ids = Stream.of(dto.get().getCommaSeparatedIds().split(","))
				.mapToLong(Long::parseLong).boxed().collect(Collectors.toList());
		
		mav.addObject("countries", countryList);
		mav.addObject("numbers", list);
		mav.addObject("states", stateService.getSatesBsdOnIds(ids));
		return mav;
	}
	
	@RequestMapping(value = "get-cities",method = RequestMethod.GET)
	public ModelAndView getCities()	{
		ModelAndView mav = new ModelAndView(folderPath + "cities");
		List<CountryDto> countryList = countryService.getAllCountries();
		List<StateDto> states = stateService.getStatesBsdOnCountry(countryList.get(0).getCountryId());
		List<PaginationDto> list = cityService.getPaginatedDataForCitiesBsdOnState(states.get(0).getStateId());
		Optional<PaginationDto> dto = list.stream().filter(item -> item.getIsActive()).findAny();
		List<Long> ids = Stream.of(dto.get().getCommaSeparatedIds().split(","))
				.mapToLong(Long::parseLong).boxed().collect(Collectors.toList());
		
		mav.addObject("countries", countryList);
		mav.addObject("states", states);
		mav.addObject("numbers", list);
		mav.addObject("cities", cityService.getCountriesByIds(ids));
		return mav;
	}
	
	@RequestMapping(value = "get-state-page-numbers-by-country",method = RequestMethod.GET)
	public @ResponseBody List<PaginationDto> getStatePageNumbersByCountry(@RequestParam Long countryId)	{
		return stateService.getPaginatedDataOfStatesBsdOnCountry(countryId);
	}
	
	@RequestMapping(value = "get-states-by-ids",method = RequestMethod.GET)
	public @ResponseBody List<StateDto> getStatesBsdOnIds(@RequestParam String commaSeparatedIds)	{
		List<Long> ids = Stream.of(commaSeparatedIds.split(","))
				.mapToLong(Long::parseLong).boxed().collect(Collectors.toList());
		return stateService.getSatesBsdOnIds(ids);
	}
	
	@RequestMapping(value = "get-states-by-country",method = RequestMethod.GET)
	public @ResponseBody List<StateDto> getStatesByCountry(@RequestParam Long countryId)	{
		return stateService.getStatesBsdOnCountry(countryId);
	}
	
	@RequestMapping(value = "get-city-page-numbers-by-state",method = RequestMethod.GET)
	public @ResponseBody List<PaginationDto> getCityPageNumbersByState(@RequestParam Long stateId)	{
		return cityService.getPaginatedDataForCitiesBsdOnState(stateId);
	}
	
	@RequestMapping(value = "get-cities-by-ids",method = RequestMethod.GET)
	public @ResponseBody List<CityDto> getCitiesByIds(@RequestParam String commaSeparatedIds)	{
		List<Long> ids = Stream.of(commaSeparatedIds.split(","))
				.mapToLong(Long::parseLong).boxed().collect(Collectors.toList());
		return cityService.getCountriesByIds(ids);
	}
}
