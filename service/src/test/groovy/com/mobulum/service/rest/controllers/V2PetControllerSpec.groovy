package com.mobulum.service.rest.controllers

import groovy.json.JsonOutput
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Specification
import spock.lang.Unroll

import java.util.Collections;

import com.mobulum.api.model.Pet
import com.mobulum.api.model.UploadResponse


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@SpringBootTest
public class V2PetControllerSpec extends Specification {

    def underTest = new V2PetController()

    def mockMvc = MockMvcBuilders.standaloneSetup(underTest).build()

    
      
    @Unroll
    def 'should return valid response from POST /v2/pet with accepting: #produces'() {
        when:
        def response = mockMvc.perform(
                MockMvcRequestBuilders
                        .post('/v2/pet')
                        .content(JsonOutput.toJson(Pet.PetBuilder.aPet().build()))
                            
                        .contentType('application/json')
                        .accept(produces)
        )

        then:
        response.andExpect(status().is(HttpStatus.CREATED.value()))
                

        
        where:
        produces << ['application/xml', 'application/json']
    }
    
    @Unroll
    def 'should return valid response from PUT /v2/pet with accepting: #produces'() {
        when:
        def response = mockMvc.perform(
                MockMvcRequestBuilders
                        .put('/v2/pet')
                        .content(JsonOutput.toJson(Pet.PetBuilder.aPet().build()))
                            
                        .contentType('application/json')
                        .accept(produces)
        )

        then:
        response.andExpect(status().is(HttpStatus.OK.value()))
                

        
        where:
        produces << ['application/xml', 'application/json']
    }
    
  
      
    @Unroll
    def 'should return valid response from GET /v2/pet/findByStatus with accepting: #produces'() {
        when:
        def response = mockMvc.perform(
                MockMvcRequestBuilders
                        .get('/v2/pet/findByStatus')
                        .param('status', '1')
                            
                        
                        .accept(produces)
        )

        then:
        response.andExpect(status().is(HttpStatus.OK.value()))
                .andExpect(content().contentTypeCompatibleWith(produces))

        
        where:
        produces << ['application/xml', 'application/json']
    }
    
  
      
    @Unroll
    def 'should return valid response from GET /v2/pet/findByTags with accepting: #produces'() {
        when:
        def response = mockMvc.perform(
                MockMvcRequestBuilders
                        .get('/v2/pet/findByTags')
                        .param('tags', 'example')
                            
                        
                        .accept(produces)
        )

        then:
        response.andExpect(status().is(HttpStatus.OK.value()))
                .andExpect(content().contentTypeCompatibleWith(produces))

        
        where:
        produces << ['application/xml', 'application/json']
    }
    
  
      
    @Unroll
    def 'should return valid response from GET /v2/pet/{petId} with accepting: #produces'() {
        when:
        def response = mockMvc.perform(
                MockMvcRequestBuilders
                        .get('/v2/pet/12345')
                        
                            
                        
                        .accept(produces)
        )

        then:
        response.andExpect(status().is(HttpStatus.OK.value()))
                .andExpect(content().contentTypeCompatibleWith(produces))

        
        where:
        produces << ['application/xml', 'application/json']
    }
    
    @Unroll
    def 'should return valid response from POST /v2/pet/{petId} with accepting: #produces'() {
        when:
        def response = mockMvc.perform(
                MockMvcRequestBuilders
                        .post('/v2/pet/12345')
                        
                            .param('name', 'pet')
                            .param('status', 'available')
                            
                        .contentType('application/x-www-form-urlencoded')
                        .accept(produces)
        )

        then:
        response.andExpect(status().is(HttpStatus.CREATED.value()))
                

        
        where:
        produces << ['application/xml', 'application/json']
    }
    
    
    def 'should return valid response from DELETE /v2/pet/{petId}'() {
        when:
        def response = mockMvc.perform(
                MockMvcRequestBuilders
                        .delete('/v2/pet/12345')
                        .header('api_key', 'val')
                            
                            
                        
                        
        )

        then:
        response.andExpect(status().is(HttpStatus.NO_CONTENT.value()))
                

        
    }
    
  
      
    @Unroll
    def 'should return valid response from POST /v2/pet/{petId}/uploadImage with accepting: #produces'() {
        when:
        def response = mockMvc.perform(
                MockMvcRequestBuilders
                        .fileUpload('/v2/pet/12345/uploadImage')
                        
                            .param('additionalMetadata', 'Additional data to pass to server')
                            .file('file', 'content'.getBytes())
                            
                        .contentType('multipart/form-data')
                        .accept(produces)
        )

        then:
        response.andExpect(status().is(HttpStatus.CREATED.value()))
                .andExpect(content().contentTypeCompatibleWith(produces))

        
        where:
        produces << ['application/json']
    }
    
  
}
