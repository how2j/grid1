package cn.how2j.grid.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.how2j.grid.dao.ConfigDAO;
import cn.how2j.grid.pojo.Config;
import cn.hutool.core.convert.Convert;

@Service
public class ConfigService {

	public static final String admin_authentication = "admin_authentication";
	public static final String fore_authentication = "fore_authentication";
	
	
	public static final String gearTotal = "gearTotal";
	public static final String gearEach = "gearEach";
	public static final String indicePrice = "indicePrice";
	public static final String foundPrice = "foundPrice";
	public static final String buyingAmount = "buyingAmount";
	
	public static String initInfo[][] = {
			{"总档数",gearTotal,"一般说来总挡数是 7 为宜","7"},
			{"每档变化",gearEach,"一般说来每挡变化是0.05","0.05"},
//			{"指数开始位置",indicePrice,"指数入仓位置","0"},
//			{"基金开始位置",foundPrice,"基金用于跟踪指数","0"},
			{"每次购买金额",buyingAmount,"每次购买金额","10000"},
	};
	public static String passwordFront;
	public static String passwordAdmin;
	public static String babyName;
	public String birthday;
	
	@Autowired ConfigDAO configDAO;
	



	public synchronized List<Config> list() {
		List<Config> configs=configDAO.findByOrderByIdAsc();
		return configs;
	}

	public synchronized void init() {
		for (String[] init : initInfo) {
			String name = init[0];
			String key = init[1];
			String desc = init[2];
			String defaultValue = init[3];
			
			Config config= configDAO.getByKey(key);
			if(null!=config)
				continue;
			
			Config bean= new  Config();
			bean.setName(name);
			bean.setKey(key);
			bean.setDesc(desc);
			bean.setValue(defaultValue);
			configDAO.save(bean);
		}
	}

	public synchronized void add(Config bean) {
		configDAO.save(bean);
	}

	public synchronized void delete(int id) {
		configDAO.delete(id);
	}

	public synchronized Config get(int id) {
		Config c= configDAO.findOne(id);
		return c;
	}
	public synchronized String get(String key) {
		Config c= configDAO.getByKey(key);
		if(null==c)
			return null;
		return c.getValue();
	}
	public synchronized int getInt(String key) {
		return Convert.toInt(get(key));
	}
	public synchronized float getFloat(String key) {
		return Convert.toFloat(get(key));
	}
	
	
	public synchronized void update(Config bean) {
		configDAO.save(bean);
	}
}
