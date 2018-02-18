/** Copyright CodeJava.net To Present
all right reserved.
*/
package com.Allianz.TravelcompanionOuterLayer.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.Allianz.TravelcompanionOuterLayer.Model.PackageinfoVO;
import com.Allianz.TravelcompanionOuterLayer.Model.ProductInfoVO;
import com.Allianz.TravelcompanionOuterLayer.Model.User;

public class TravelCompanionServiceTest {
	
	@Mock
	ProductInfoVO productInfoVO = new ProductInfoVO();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		List<PackageinfoVO> packageinfoVOs = new ArrayList<>();

		PackageinfoVO packageinfoVO = new PackageinfoVO();

		List<String> packageDescriptionList = new ArrayList<>();
		packageDescriptionList.add("driving");
		packageDescriptionList.add("skiing");
		packageinfoVO.setPackageDescription(packageDescriptionList);
		packageinfoVO.setPackageName("passion");

		packageinfoVOs.add(packageinfoVO);

		productInfoVO.setPackageList(packageinfoVOs);
		productInfoVO.setProductName("SkiinSelekor");
		
		List<String> moduleList = new ArrayList<>();
		moduleList.add("mod1");
		moduleList.add("mod2");
		
		User user = new User();
		user.setFiledDate("12-12-2018");
		user.setPackageTitle("packageTitle");
		user.setPlace("place");
		user.setTravelDate("23-12-2018");
		user.setTravelEndDate("31-12-2018");
		user.setUserId(1004);
		user.setUserName("testNme");
		user.setWeather("good");
		user.setDistance(10);
		user.setDuration(5);
		user.setNumberOfPerson(2);
		user.setPressure(4);
		user.setSelectedModule(moduleList);
	}

}
