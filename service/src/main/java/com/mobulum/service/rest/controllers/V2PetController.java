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

import com.mobulum.api.model.Pet;
import com.mobulum.api.model.UploadResponse;


import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/v2")
public class V2PetController {
    private static final Logger logger = LoggerFactory.getLogger(V2PetController.class);



    /**
     * summary: Add a new pet to the store
     * description: 
     * consumes: application/json
     * produces: application/xml, application/json
     * operationId: addPet
     * returnType: void
     */


    @RequestMapping(method = RequestMethod.POST, path = "/pet", produces = {"application/xml", "application/json"}, consumes = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @Timed(absolute = true)
    @ApiOperation(value = "addPet", nickname = "addPet", produces = "application/xml, application/json", consumes = "application/json")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "successful operation"),
        @ApiResponse(code = 405, message = "Invalid input")
    })
    public void addPet(
        @RequestBody Pet body
    ) {
      
    }
  /**
     * summary: Update an existing pet
     * description: 
     * consumes: application/json
     * produces: application/xml, application/json
     * operationId: updatePet
     * returnType: void
     */


    @RequestMapping(method = RequestMethod.PUT, path = "/pet", produces = {"application/xml", "application/json"}, consumes = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @Timed(absolute = true)
    @ApiOperation(value = "updatePet", nickname = "updatePet", produces = "application/xml, application/json", consumes = "application/json")
    @ApiResponses(value = {
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Pet not found"),
        @ApiResponse(code = 405, message = "Validation exception")
    })
    public void updatePet(
        @RequestBody Pet body
    ) {
      
    }
  


    /**
     * summary: Finds Pets by status
     * description: Multiple status values can be provided with comma separated strings
     * consumes: 
     * produces: application/xml, application/json
     * operationId: findPetsByStatus
     * returnType: List<Pet>
     */

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, path = "/pet/findByStatus", produces = {"application/xml", "application/json"})
    @ResponseStatus(HttpStatus.OK)
    @Timed(absolute = true)
    @ApiOperation(value = "findPetsByStatus", nickname = "findPetsByStatus", produces = "application/xml, application/json")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "successful operation", responseContainer = "List"),
        @ApiResponse(code = 400, message = "Invalid status value")
    })
    public List<Pet> findPetsByStatus(
        @RequestParam("status") List<String> status
    ) {
      return Collections.singletonList(Pet.PetBuilder.aPet().build());
    }
  


    /**
     * summary: Finds Pets by tags
     * description: Muliple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
     * consumes: 
     * produces: application/xml, application/json
     * operationId: findPetsByTags
     * returnType: List<Pet>
     */

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, path = "/pet/findByTags", produces = {"application/xml", "application/json"})
    @ResponseStatus(HttpStatus.OK)
    @Timed(absolute = true)
    @ApiOperation(value = "findPetsByTags", nickname = "findPetsByTags", produces = "application/xml, application/json")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "successful operation", responseContainer = "List"),
        @ApiResponse(code = 400, message = "Invalid tag value")
    })
    public List<Pet> findPetsByTags(
        @RequestParam("tags") List<String> tags
    ) {
      return Collections.singletonList(Pet.PetBuilder.aPet().build());
    }
  


    /**
     * summary: Find pet by ID
     * description: Returns a single pet
     * consumes: 
     * produces: application/xml, application/json
     * operationId: getPetById
     * returnType: Pet
     */

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, path = "/pet/{petId}", produces = {"application/xml", "application/json"})
    @ResponseStatus(HttpStatus.OK)
    @Timed(absolute = true)
    @ApiOperation(value = "getPetById", nickname = "getPetById", produces = "application/xml, application/json")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "successful operation"),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Pet not found")
    })
    public Pet getPetById(
        @PathVariable("petId") Long petId
    ) {
      return Pet.PetBuilder.aPet().build();
    }
  /**
     * summary: Updates a pet in the store with form data
     * description: 
     * consumes: application/x-www-form-urlencoded
     * produces: application/xml, application/json
     * operationId: updatePetWithForm
     * returnType: void
     */


    @RequestMapping(method = RequestMethod.POST, path = "/pet/{petId}", produces = {"application/xml", "application/json"}, consumes = {"application/x-www-form-urlencoded"})
    @ResponseStatus(HttpStatus.CREATED)
    @Timed(absolute = true)
    @ApiOperation(value = "updatePetWithForm", nickname = "updatePetWithForm", produces = "application/xml, application/json", consumes = "application/x-www-form-urlencoded")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "successful operation"),
        @ApiResponse(code = 405, message = "Invalid input")
    })
    public void updatePetWithForm(
        @PathVariable("petId") Long petId,
        @RequestParam("name") String name,
        @RequestParam("status") String status
    ) {
      
    }
  /**
     * summary: Deletes a pet
     * description: 
     * consumes: 
     * produces: 
     * operationId: deletePet
     * returnType: void
     */


    @RequestMapping(method = RequestMethod.DELETE, path = "/pet/{petId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Timed(absolute = true)
    @ApiOperation(value = "deletePet", nickname = "deletePet")
    @ApiResponses(value = {
        @ApiResponse(code = 204, message = "successful operation"),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Pet not found")
    })
    public void deletePet(
        @RequestHeader("api_key") String api_key,
        @PathVariable("petId") Long petId
    ) {
      
    }
  


    /**
     * summary: uploads an image
     * description: 
     * consumes: multipart/form-data
     * produces: application/json
     * operationId: uploadFile
     * returnType: UploadResponse
     */

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, path = "/pet/{petId}/uploadImage", produces = {"application/json"}, consumes = {"multipart/form-data"})
    @ResponseStatus(HttpStatus.CREATED)
    @Timed(absolute = true)
    @ApiOperation(value = "uploadFile", nickname = "uploadFile", produces = "application/json", consumes = "multipart/form-data")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "successful operation")
    })
    public UploadResponse uploadFile(
        @PathVariable("petId") Long petId,
        @RequestParam("additionalMetadata") String additionalMetadata,
        @RequestParam("file") MultipartFile file
    ) {
      return UploadResponse.UploadResponseBuilder.aUploadResponse().build();
    }
  

}
