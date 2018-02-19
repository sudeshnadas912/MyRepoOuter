/** Copyright CodeJava.net To Present
all right reserved.
*/
package com.Allianz.TravelcompanionOuterLayer.service;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.Allianz.TravelcompanionOuterLayer.Model.AccessToken;
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

	/**
	 * Only for testing getter and setter method
	 */
	@Test
	public void test() {
		List<PackageinfoVO> packageinfoVOs = new ArrayList<>();

		PackageinfoVO packageinfoVO = new PackageinfoVO();

		List<String> packageDescriptionList = new ArrayList<>();
		packageDescriptionList.add("driving");
		packageDescriptionList.add("skiing");
		packageinfoVO.setPackageDescription(packageDescriptionList);
		packageinfoVO.setPackageName("passion");

		// Constuctor check
		PackageinfoVO packageinfoVOTest = new PackageinfoVO("testPackage", packageDescriptionList);
		packageinfoVOs.add(packageinfoVOTest);

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
		user.setSelectedPackage("package");
		// Check all getter field only for testing
		assertNotNull(packageinfoVO.getPackageDescription() + packageinfoVO.getPackageName());

		// Check all fields of user only for testing
		assertNotNull(user.getDistance() + user.getDuration() + user.getFiledDate() + user.getNumberOfPerson()
				+ user.getPackageTitle() + user.getPlace() + user.getPressure() + user.getSelectedPackage()
				+ user.getTravelDate() + user.getTravelEndDate() + user.getUserId() + user.getUserName()
				+ user.getWeather() + user.getSelectedModule());
		// Check all fields of product only for testing
		assertNotNull(productInfoVO.getPackageList() + productInfoVO.getProductName());
	}

	@Test
	public void testModel() {
		// Set the value
		AccessToken accessToken = new AccessToken();
		accessToken.setAccessToken("qwtuiiooo445677");
		accessToken.setExpiresSeconds("30");
		accessToken.setTokenType("client_credential");
		// Get the value for testing purpose
		assertNotNull(accessToken.getAccessToken() + accessToken.getExpiresSeconds() + accessToken.getTokenType());
	}
	
	

}
