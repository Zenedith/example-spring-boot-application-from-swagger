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

import com.mobulum.api.model.User;


import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/v2")
public class V2UserController {
    private static final Logger logger = LoggerFactory.getLogger(V2UserController.class);



    /**
     * summary: Create user
     * description: This can only be done by the logged in user.
     * consumes: application/json
     * produces: application/xml, application/json
     * operationId: createUser
     * returnType: void
     */


    @RequestMapping(method = RequestMethod.POST, path = "/user", produces = {"application/xml", "application/json"}, consumes = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @Timed(absolute = true)
    @ApiOperation(value = "createUser", nickname = "createUser", produces = "application/xml, application/json", consumes = "application/json")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "successful operation")
    })
    public void createUser(
        @RequestBody User body
    ) {
      
    }
  


    /**
     * summary: Creates list of users with given input array
     * description: 
     * consumes: application/json
     * produces: application/xml, application/json
     * operationId: createUsersWithArrayInput
     * returnType: void
     */


    @RequestMapping(method = RequestMethod.POST, path = "/user/createWithArray", produces = {"application/xml", "application/json"}, consumes = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @Timed(absolute = true)
    @ApiOperation(value = "createUsersWithArrayInput", nickname = "createUsersWithArrayInput", produces = "application/xml, application/json", consumes = "application/json")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "successful operation")
    })
    public void createUsersWithArrayInput(
        @RequestBody List<User> body
    ) {
      
    }
  


    /**
     * summary: Creates list of users with given input array
     * description: 
     * consumes: application/json
     * produces: application/xml, application/json
     * operationId: createUsersWithListInput
     * returnType: void
     */


    @RequestMapping(method = RequestMethod.POST, path = "/user/createWithList", produces = {"application/xml", "application/json"}, consumes = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @Timed(absolute = true)
    @ApiOperation(value = "createUsersWithListInput", nickname = "createUsersWithListInput", produces = "application/xml, application/json", consumes = "application/json")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "successful operation")
    })
    public void createUsersWithListInput(
        @RequestBody List<User> body
    ) {
      
    }
  


    /**
     * summary: Logs user into the system
     * description: 
     * consumes: 
     * produces: application/xml, application/json
     * operationId: loginUser
     * returnType: void
     */


    @RequestMapping(method = RequestMethod.GET, path = "/user/login", produces = {"application/xml", "application/json"})
    @ResponseStatus(HttpStatus.OK)
    @Timed(absolute = true)
    @ApiOperation(value = "loginUser", nickname = "loginUser", produces = "application/xml, application/json")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "successful operation"),
        @ApiResponse(code = 400, message = "Invalid username/password supplied")
    })
    public void loginUser(
        @RequestParam("username") String username,
        @RequestParam("password") String password
    ) {
      
    }
  


    /**
     * summary: Logs out current logged in user session
     * description: 
     * consumes: 
     * produces: application/xml, application/json
     * operationId: logoutUser
     * returnType: void
     */


    @RequestMapping(method = RequestMethod.GET, path = "/user/logout", produces = {"application/xml", "application/json"})
    @ResponseStatus(HttpStatus.OK)
    @Timed(absolute = true)
    @ApiOperation(value = "logoutUser", nickname = "logoutUser", produces = "application/xml, application/json")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "successful operation")
    })
    public void logoutUser(
    
    ) {
      
    }
  


    /**
     * summary: Get user by user name
     * description: 
     * consumes: 
     * produces: application/xml, application/json
     * operationId: getUserByName
     * returnType: User
     */

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, path = "/user/{username}", produces = {"application/xml", "application/json"})
    @ResponseStatus(HttpStatus.OK)
    @Timed(absolute = true)
    @ApiOperation(value = "getUserByName", nickname = "getUserByName", produces = "application/xml, application/json")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "successful operation"),
        @ApiResponse(code = 400, message = "Invalid username supplied"),
        @ApiResponse(code = 404, message = "User not found")
    })
    public User getUserByName(
        @PathVariable("username") String username
    ) {
      return User.UserBuilder.aUser().build();
    }
  /**
     * summary: Updated user
     * description: This can only be done by the logged in user.
     * consumes: application/json
     * produces: application/xml, application/json
     * operationId: updateUser
     * returnType: void
     */


    @RequestMapping(method = RequestMethod.PUT, path = "/user/{username}", produces = {"application/xml", "application/json"}, consumes = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @Timed(absolute = true)
    @ApiOperation(value = "updateUser", nickname = "updateUser", produces = "application/xml, application/json", consumes = "application/json")
    @ApiResponses(value = {
        @ApiResponse(code = 400, message = "Invalid user supplied"),
        @ApiResponse(code = 404, message = "User not found")
    })
    public void updateUser(
        @PathVariable("username") String username,
        @RequestBody User body
    ) {
      
    }
  /**
     * summary: Delete user
     * description: This can only be done by the logged in user.
     * consumes: 
     * produces: application/xml, application/json
     * operationId: deleteUser
     * returnType: void
     */


    @RequestMapping(method = RequestMethod.DELETE, path = "/user/{username}", produces = {"application/xml", "application/json"})
    @ResponseStatus(HttpStatus.OK)
    @Timed(absolute = true)
    @ApiOperation(value = "deleteUser", nickname = "deleteUser", produces = "application/xml, application/json")
    @ApiResponses(value = {
        @ApiResponse(code = 400, message = "Invalid username supplied"),
        @ApiResponse(code = 404, message = "User not found")
    })
    public void deleteUser(
        @PathVariable("username") String username
    ) {
      
    }
  

}
