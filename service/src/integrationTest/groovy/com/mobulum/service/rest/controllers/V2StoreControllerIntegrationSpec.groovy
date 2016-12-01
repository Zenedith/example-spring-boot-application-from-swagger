package com.mobulum.service.rest.controllers

import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus
import org.springframework.core.io.ClassPathResource
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap
import spock.lang.Unroll

import java.util.Collections;

import com.mobulum.api.model.Order


public class V2StoreControllerIntegrationSpec extends AbstractRestControllerIntegrationSpec {

    @Autowired
    private TestRestTemplate restTemplate;

    def HttpHeaders headers = new HttpHeaders();
    def HttpEntity entity

    def setup() {
        headers.clear()
    }

    def HttpEntity prepareEntity(def HttpEntity entity) {
        if (entity) {
            return entity;
        }

        return new HttpEntity<Void>(null, headers)
    }

    
      
    @Unroll
    def 'should return valid response from GET /v2/store/inventory with accepting: #produces'() {
        given:
            
            headers.setAccept(Arrays.asList(MediaType.parseMediaType(produces)))
            
            

            
            
            

        when:
        def ResponseEntity<Integer> responseEntity = restTemplate.exchange(
                        '/v2/store/inventory',
                        HttpMethod.GET,
                        prepareEntity(entity),
                        Integer
                )
        then:
        responseEntity.statusCode.value() == HttpStatus.OK.value()

        
        where:
        produces << ['application/json']
    }
    
  
      
    @Unroll
    def 'should return valid response from POST /v2/store/order with accepting: #produces'() {
        given:
            
            headers.setAccept(Arrays.asList(MediaType.parseMediaType(produces)))
            headers.setContentType(MediaType.parseMediaType('application/json'))
            
            

            
            HttpEntity<Order> entity = new HttpEntity<Order>(Order.OrderBuilder.aOrder().build(), headers)
            
            

        when:
        def ResponseEntity<Order> responseEntity = restTemplate.exchange(
                        '/v2/store/order',
                        HttpMethod.POST,
                        prepareEntity(entity),
                        Order
                )
        then:
        responseEntity.statusCode.value() == HttpStatus.CREATED.value()

        
        where:
        produces << ['application/xml', 'application/json']
    }
    
  
      
    @Unroll
    def 'should return valid response from GET /v2/store/order/{orderId} with accepting: #produces'() {
        given:
            
            headers.setAccept(Arrays.asList(MediaType.parseMediaType(produces)))
            
            
            

            
            
            
            

        when:
        def ResponseEntity<Order> responseEntity = restTemplate.exchange(
                        '/v2/store/order/1',
                        HttpMethod.GET,
                        prepareEntity(entity),
                        Order
                )
        then:
        responseEntity.statusCode.value() == HttpStatus.OK.value()

        
        where:
        produces << ['application/xml', 'application/json']
    }
    
    
    def 'should return valid response from DELETE /v2/store/order/{orderId}'() {
        given:
            
            
            
            

            
            
            
            

        when:
        def ResponseEntity<Void> responseEntity = restTemplate.exchange(
                        '/v2/store/order/1',
                        HttpMethod.DELETE,
                        prepareEntity(entity),
                        Void
                )
        then:
        responseEntity.statusCode.value() == HttpStatus.NO_CONTENT.value()

        
    }
    
  
}
