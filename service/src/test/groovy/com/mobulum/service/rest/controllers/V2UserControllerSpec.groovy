package com.mobulum.service.rest.controllers

import groovy.json.JsonOutput
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Specification
import spock.lang.Unroll

import java.util.Collections;

import com.mobulum.api.model.User


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@SpringBootTest
public class V2UserControllerSpec extends Specification {

    def underTest = new V2UserController()

    def mockMvc = MockMvcBuilders.standaloneSetup(underTest).build()

    
      
    @Unroll
    def 'should return valid response from POST /v2/user with accepting: #produces'() {
        when:
        def response = mockMvc.perform(
                MockMvcRequestBuilders
                        .post('/v2/user')
                        .content(JsonOutput.toJson(User.UserBuilder.aUser().build()))
                            
                        .contentType('application/json')
                        .accept(produces)
        )

        then:
        response.andExpect(status().is(HttpStatus.CREATED.value()))
                

        
        where:
        produces << ['application/xml', 'application/json']
    }
    
  
      
    @Unroll
    def 'should return valid response from POST /v2/user/createWithArray with accepting: #produces'() {
        when:
        def response = mockMvc.perform(
                MockMvcRequestBuilders
                        .post('/v2/user/createWithArray')
                        .content(JsonOutput.toJson(Collections.singletonList(User.UserBuilder.aUser().build())))
                            
                        .contentType('application/json')
                        .accept(produces)
        )

        then:
        response.andExpect(status().is(HttpStatus.CREATED.value()))
                

        
        where:
        produces << ['application/xml', 'application/json']
    }
    
  
      
    @Unroll
    def 'should return valid response from POST /v2/user/createWithList with accepting: #produces'() {
        when:
        def response = mockMvc.perform(
                MockMvcRequestBuilders
                        .post('/v2/user/createWithList')
                        .content(JsonOutput.toJson(Collections.singletonList(User.UserBuilder.aUser().build())))
                            
                        .contentType('application/json')
                        .accept(produces)
        )

        then:
        response.andExpect(status().is(HttpStatus.CREATED.value()))
                

        
        where:
        produces << ['application/xml', 'application/json']
    }
    
  
      
    @Unroll
    def 'should return valid response from GET /v2/user/login with accepting: #produces'() {
        when:
        def response = mockMvc.perform(
                MockMvcRequestBuilders
                        .get('/v2/user/login')
                        .param('username', 'user1')
                            .param('password', 'user-password')
                            
                        
                        .accept(produces)
        )

        then:
        response.andExpect(status().is(HttpStatus.OK.value()))
                .andExpect(content().contentTypeCompatibleWith(produces))

        
        where:
        produces << ['text/plain']
    }
    
  
      
    @Unroll
    def 'should return valid response from GET /v2/user/logout with accepting: #produces'() {
        when:
        def response = mockMvc.perform(
                MockMvcRequestBuilders
                        .get('/v2/user/logout')
                        
                        
                        .accept(produces)
        )

        then:
        response.andExpect(status().is(HttpStatus.OK.value()))
                

        
        where:
        produces << ['application/xml', 'application/json']
    }
    
  
      
    @Unroll
    def 'should return valid response from GET /v2/user/{username} with accepting: #produces'() {
        when:
        def response = mockMvc.perform(
                MockMvcRequestBuilders
                        .get('/v2/user/user1')
                        
                            
                        
                        .accept(produces)
        )

        then:
        response.andExpect(status().is(HttpStatus.OK.value()))
                .andExpect(content().contentTypeCompatibleWith(produces))

        
        where:
        produces << ['application/xml', 'application/json']
    }
    
    @Unroll
    def 'should return valid response from PUT /v2/user/{username} with accepting: #produces'() {
        when:
        def response = mockMvc.perform(
                MockMvcRequestBuilders
                        .put('/v2/user/user1')
                        
                            .content(JsonOutput.toJson(User.UserBuilder.aUser().build()))
                            
                        .contentType('application/json')
                        .accept(produces)
        )

        then:
        response.andExpect(status().is(HttpStatus.OK.value()))
                

        
        where:
        produces << ['application/xml', 'application/json']
    }
    
    @Unroll
    def 'should return valid response from DELETE /v2/user/{username} with accepting: #produces'() {
        when:
        def response = mockMvc.perform(
                MockMvcRequestBuilders
                        .delete('/v2/user/user1')
                        
                            
                        
                        .accept(produces)
        )

        then:
        response.andExpect(status().is(HttpStatus.OK.value()))
                

        
        where:
        produces << ['application/xml', 'application/json']
    }
    
  
}
