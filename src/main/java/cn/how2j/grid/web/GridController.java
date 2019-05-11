package cn.how2j.grid.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.how2j.grid.pojo.Grid;
import cn.how2j.grid.service.ConfigService;
 
@RestController
public class GridController {
	@Autowired ConfigService configService;

	
	
	@GetMapping("/grids")
	public Map<String,Object> list() throws Exception {
		List<Grid> grids = new ArrayList<>();
		
		
		float gearFloat = configService.getFloat(ConfigService.gearEach);
		int gearTotal = configService.getInt(ConfigService.gearTotal);
		int buyingAmount = configService.getInt(ConfigService.buyingAmount);
		float buyCost = buyingAmount;
		
		for (int i = 0; i < gearTotal; i++) {
			grids.add(new Grid(i+1,gearFloat,buyCost));
		}
		
		float buyTotal = 0;
		float profitTotal = 0;
		
		for (Grid grid : grids) {
			buyTotal+=grid.getBuyCost();
			profitTotal +=grid.getProfit();
		}
		
		Map<String,Object> result = new HashMap<>();
		result.put("buyTotal", buyTotal);
		result.put("profitTotal", profitTotal);
		result.put("grids", grids);
		
		return result;
	}
}

