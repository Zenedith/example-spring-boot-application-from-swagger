package com.mobulum.service.rest.controllers;

import com.codahale.metrics.annotation.Timed;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mobulum.api.model.Order;


import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/v2")
public class V2StoreController {
    private static final Logger logger = LoggerFactory.getLogger(V2StoreController.class);



    /**
     * summary: Returns pet inventories by status
     * description: Returns a map of status codes to quantities
     * consumes: 
     * produces: application/json
     * operationId: getInventory
     * returnType: Integer
     */

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, path = "/store/inventory", produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @Timed(absolute = true)
    @ApiOperation(value = "getInventory", nickname = "getInventory", produces = "application/json")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "successful operation")
    })
    public Integer getInventory(
    
    ) {
      return Integer.valueOf("1");
    }
  


    /**
     * summary: Place an order for a pet
     * description: 
     * consumes: application/json
     * produces: application/xml, application/json
     * operationId: placeOrder
     * returnType: Order
     */

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, path = "/store/order", produces = {"application/xml", "application/json"}, consumes = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @Timed(absolute = true)
    @ApiOperation(value = "placeOrder", nickname = "placeOrder", produces = "application/xml, application/json", consumes = "application/json")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "successful operation"),
        @ApiResponse(code = 400, message = "Invalid Order")
    })
    public Order placeOrder(
        @RequestBody Order body
    ) {
      return Order.OrderBuilder.aOrder().build();
    }
  


    /**
     * summary: Find purchase order by ID
     * description: For valid response try integer IDs with value >= 1 and <= 10. Other values will generated exceptions
     * consumes: 
     * produces: application/xml, application/json
     * operationId: getOrderById
     * returnType: Order
     */

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, path = "/store/order/{orderId}", produces = {"application/xml", "application/json"})
    @ResponseStatus(HttpStatus.OK)
    @Timed(absolute = true)
    @ApiOperation(value = "getOrderById", nickname = "getOrderById", produces = "application/xml, application/json")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "successful operation"),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Order not found")
    })
    public Order getOrderById(
        @PathVariable("orderId") Long orderId
    ) {
      return Order.OrderBuilder.aOrder().build();
    }
  /**
     * summary: Delete purchase order by ID
     * description: For valid response try integer IDs with positive integer value. Negative or non-integer values will generate API errors
     * consumes: 
     * produces: 
     * operationId: deleteOrder
     * returnType: void
     */


    @RequestMapping(method = RequestMethod.DELETE, path = "/store/order/{orderId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Timed(absolute = true)
    @ApiOperation(value = "deleteOrder", nickname = "deleteOrder")
    @ApiResponses(value = {
        @ApiResponse(code = 204, message = "successful operation"),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Order not found")
    })
    public void deleteOrder(
        @PathVariable("orderId") Long orderId
    ) {
      
    }
  

}
