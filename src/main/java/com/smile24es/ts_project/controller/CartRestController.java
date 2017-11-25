package com.smile24es.ts_project.controller;

import com.smile24es.ts_project.beans.MockObject;
import com.smile24es.ts_project.beans.Model.CartResult;
import com.smile24es.ts_project.beans.Model.CartTestResult;
import com.smile24es.ts_project.beans.Model.DataSet;
import com.smile24es.ts_project.beans.Model.Recode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.MediaType;
import com.smile24es.ts_project.service.CartService;
import java.io.FileNotFoundException;

/**
 * Created by hasithagamage on 5/15/17.
 */
@RestController
public class CartRestController extends BaseRestController {

    private static final Logger SL4J_LOGGER = LoggerFactory.getLogger(CartRestController.class);

    @Autowired
    CartService cartService;

    @RequestMapping(value = "cart-predict", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity predictFromAlgo(@RequestBody Recode recode) {
        SL4J_LOGGER.info("Starting to cart with recode [{}]", recode);
        CartResult niveByarseResult = cartService.getPrediction(recode);
        return new ResponseEntity<>(niveByarseResult, HttpStatus.OK);
    }

    @RequestMapping(value = "traing-cart-algo", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity trainAlgo(@RequestBody DataSet dataSet) throws FileNotFoundException {
        SL4J_LOGGER.info("Starting to train algo with data set [{0}]", dataSet);
        String cartURL = cartService.trainAlgo(dataSet);
        return new ResponseEntity<>(cartURL, HttpStatus.CREATED);
    }

    @RequestMapping(value = "test-cart", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity testAlgo(@RequestBody DataSet dataSet) {
        SL4J_LOGGER.info("Starting to test algo with data set [{}]", dataSet);
        CartTestResult testResults = cartService.testAlgo(dataSet);
        return new ResponseEntity<>(testResults, HttpStatus.OK);
    }

    @RequestMapping(value = "mock1/{movieId}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity mockAPI1(@PathVariable String movieId) {
        SL4J_LOGGER.info("Starting to mock 1 end point [{}]", movieId);
        MockObject mockObject = new MockObject("Titanic",false,50,187);
        return new ResponseEntity<>(mockObject, HttpStatus.OK);
    }
    
    @RequestMapping(value = "mock2/{movieName}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity mockAPI2(@PathVariable String movieName) {
        SL4J_LOGGER.info("Starting to mock 2 end point [{}]", movieName);
        MockObject mockObject = new MockObject(movieName,false,47,126);
        return new ResponseEntity<>(mockObject, HttpStatus.OK);
    }
}
