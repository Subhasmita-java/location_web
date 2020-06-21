package com.subha.location.controllers;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.subha.location.Util.EmailUtil;
import com.subha.location.Util.ReportUtil;
import com.subha.location.entities.Location;
import com.subha.location.repos.LocationRepository;
import com.subha.location.service.LocationService;

@Controller
public class LocationController {
	@Autowired
	LocationService locationServ;
	@Autowired
	LocationRepository locationRepo;
	@Autowired
	ServletContext sc;
	@Autowired
	EmailUtil emailUtil;
	@Autowired
	ReportUtil reportUtil;
	
	@RequestMapping("/showCreate")
	public String showcreate() {
		return "createLocation";
	}
	
	@RequestMapping("/saveLoc")
	public String saveLocation(@ModelAttribute("location")Location location,ModelMap modelMap ){
		Location savedLocation = locationServ.saveLocation(location);
		String msg = "Location saved with ID : "+savedLocation.getId();
		modelMap.addAttribute("msg", msg);
		emailUtil.sendEmail("subhafortesting@gmail.com", "Location Saved",
				"Location Saved Successfully and returning a response");
		return "createLocation";
	}
	
	@RequestMapping("/displayLocations")
	public String displayLocations(ModelMap modelmap) {
		List<Location> locations = locationServ.getAllLocation();
		modelmap.addAttribute("locations", locations);
		return "displayLocations";
	}
	
	@RequestMapping("/deleteLocation")
	public String deleteLocation(@RequestParam("id") int id, ModelMap modelmap) {
		Location location = new Location();
		location.setId(id);
		locationServ.deleteLocation(location);
		List<Location> locations = locationServ.getAllLocation();
		modelmap.addAttribute("locations", locations);
		return "displayLocations";
	}
	@RequestMapping("/updateLocation")
	public String updateLocation(@RequestParam("id") int id,ModelMap modelmap) {
		Location location = locationServ.getLocationById(id);
		modelmap.addAttribute("location", location);
		return "updateLocation";
	}
	
	@RequestMapping("/updateLoc")
	public String updatedLocation(@ModelAttribute("location")Location location,ModelMap modelmap) {
		locationServ.updateLocation(location);
		List<Location> locations = locationServ.getAllLocation();
		modelmap.addAttribute("locations", locations);
		return "displayLocations";
	}
	@RequestMapping("/generateReport")
	public String generatePieChart() {
		String path= sc.getRealPath("/");
		List<Object[]> data = locationRepo.findTypeAndTypeCount();
		reportUtil.generateTypeReport(path, data);
		return "report";
	}
	
}
