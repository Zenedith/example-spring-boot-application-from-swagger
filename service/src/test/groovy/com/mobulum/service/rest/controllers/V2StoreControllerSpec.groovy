package com.mobulum.service.rest.controllers

import groovy.json.JsonOutput
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Specification
import spock.lang.Unroll

import java.util.Collections;

import com.mobulum.api.model.Order


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@SpringBootTest
public class V2StoreControllerSpec extends Specification {

    def underTest = new V2StoreController()

    def mockMvc = MockMvcBuilders.standaloneSetup(underTest).build()

    
      
    @Unroll
    def 'should return valid response from GET /v2/store/inventory with accepting: #produces'() {
        when:
        def response = mockMvc.perform(
                MockMvcRequestBuilders
                        .get('/v2/store/inventory')
                        
                        
                        .accept(produces)
        )

        then:
        response.andExpect(status().is(HttpStatus.OK.value()))
                .andExpect(content().contentTypeCompatibleWith(produces))

        
        where:
        produces << ['application/json']
    }
    
  
      
    @Unroll
    def 'should return valid response from POST /v2/store/order with accepting: #produces'() {
        when:
        def response = mockMvc.perform(
                MockMvcRequestBuilders
                        .post('/v2/store/order')
                        .content(JsonOutput.toJson(Order.OrderBuilder.aOrder().build()))
                            
                        .contentType('application/json')
                        .accept(produces)
        )

        then:
        response.andExpect(status().is(HttpStatus.CREATED.value()))
                .andExpect(content().contentTypeCompatibleWith(produces))

        
        where:
        produces << ['application/xml', 'application/json']
    }
    
  
      
    @Unroll
    def 'should return valid response from GET /v2/store/order/{orderId} with accepting: #produces'() {
        when:
        def response = mockMvc.perform(
                MockMvcRequestBuilders
                        .get('/v2/store/order/1')
                        
                            
                        
                        .accept(produces)
        )

        then:
        response.andExpect(status().is(HttpStatus.OK.value()))
                .andExpect(content().contentTypeCompatibleWith(produces))

        
        where:
        produces << ['application/xml', 'application/json']
    }
    
    
    def 'should return valid response from DELETE /v2/store/order/{orderId}'() {
        when:
        def response = mockMvc.perform(
                MockMvcRequestBuilders
                        .delete('/v2/store/order/1')
                        
                            
                        
                        
        )

        then:
        response.andExpect(status().is(HttpStatus.NO_CONTENT.value()))
                

        
    }
    
  
}
