/*******************************************************************************
 * Copyright 2018 TCS
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.  You may obtain a copy
 * of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations under
 * the License.
 ******************************************************************************/
package com.Allianz.TravelcompanionOuterLayer.Controller;

import java.io.IOException;
import java.util.Date;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Allianz.TravelcompanionOuterLayer.Model.ProductInfoVO;
import com.Allianz.TravelcompanionOuterLayer.Model.User;
import com.Allianz.TravelcompanionOuterLayer.service.TravelCompanionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.JsonSyntaxException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@PropertySource("classpath:application.properties")
@RestController
@Api(value = "Travel Companion Backend Service Outer Layer", description = "backend Service calls for TravelCompanion Application")
public class TravelCompanionOuterLayerController {

	@Autowired
	private TravelCompanionService productService;

	private static final Logger logger = Logger.getLogger(TravelCompanionOuterLayerController.class.getName());

	// To get the product info from inner layer
	@ApiOperation("To get Product and components from APL Service")
	@GetMapping("/Product/{productName}")
	public ProductInfoVO getProductInfo(@PathVariable String productName) throws JsonSyntaxException, JSONException {
		logger.debug("in get Product Info call");

		return productService.getProductInfo(productName);

	}

	// create an policy in CISL from Inner Layer
	@ApiOperation("To file the insurance policy")
	@PostMapping(value = "/fileMobilityInsurance")
	public boolean fileMobilityInsurance(@RequestBody User user) {
		user.setFiledDate(new Date().toString());
		try {
			return productService.fileMobilityInsurance(user);
		} catch (Exception ex) {
			logger.info(ex.getMessage());
			return false;
		}
	}

	// To get the quote by sending the configuration
	@ApiOperation("To file the insurance policy")
	@PostMapping(value = "/getTheQuote")
	public String getTheQuote(@RequestBody User user) {
		user.setFiledDate(new Date().toString());
		try {
			return productService.getTheQuote(user);
		} catch (Exception ex) {
			logger.info(ex.getMessage());
			return "error Ocuured while getting quote from inner layer";
		}
	}

	@ApiOperation("To test OAuth service To connect to inner layer")
	@GetMapping("/testoAuth")
	public String testOAuth() throws JsonProcessingException, IOException {
		return productService.testoAuth();
	}

	// To Test inner outer connection
	@ApiOperation("To Test inner outer connection")
	@GetMapping(value = "/testInnerOuterConnection")
	public String testInnerOuterConnection() throws JsonProcessingException, IOException {
		return productService.testInnerOuterConnection();

	}

}
