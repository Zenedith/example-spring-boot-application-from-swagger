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

import com.mobulum.api.model.User


public class V2UserControllerIntegrationSpec extends AbstractRestControllerIntegrationSpec {

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
    def 'should return valid response from POST /v2/user with accepting: #produces'() {
        given:
            
            headers.setAccept(Arrays.asList(MediaType.parseMediaType(produces)))
            headers.setContentType(MediaType.parseMediaType('application/json'))
            
            

            
            HttpEntity<User> entity = new HttpEntity<User>(User.UserBuilder.aUser().build(), headers)
            
            

        when:
        def ResponseEntity<Void> responseEntity = restTemplate.exchange(
                        '/v2/user',
                        HttpMethod.POST,
                        prepareEntity(entity),
                        Void
                )
        then:
        responseEntity.statusCode.value() == HttpStatus.CREATED.value()

        
        where:
        produces << ['application/xml', 'application/json']
    }
    
  
      
    @Unroll
    def 'should return valid response from POST /v2/user/createWithArray with accepting: #produces'() {
        given:
            
            headers.setAccept(Arrays.asList(MediaType.parseMediaType(produces)))
            headers.setContentType(MediaType.parseMediaType('application/json'))
            
            

            
            HttpEntity<User> entity = new HttpEntity<User>(Collections.singletonList(User.UserBuilder.aUser().build()), headers)
            
            

        when:
        def ResponseEntity<Void> responseEntity = restTemplate.exchange(
                        '/v2/user/createWithArray',
                        HttpMethod.POST,
                        prepareEntity(entity),
                        Void
                )
        then:
        responseEntity.statusCode.value() == HttpStatus.CREATED.value()

        
        where:
        produces << ['application/xml', 'application/json']
    }
    
  
      
    @Unroll
    def 'should return valid response from POST /v2/user/createWithList with accepting: #produces'() {
        given:
            
            headers.setAccept(Arrays.asList(MediaType.parseMediaType(produces)))
            headers.setContentType(MediaType.parseMediaType('application/json'))
            
            

            
            HttpEntity<User> entity = new HttpEntity<User>(Collections.singletonList(User.UserBuilder.aUser().build()), headers)
            
            

        when:
        def ResponseEntity<Void> responseEntity = restTemplate.exchange(
                        '/v2/user/createWithList',
                        HttpMethod.POST,
                        prepareEntity(entity),
                        Void
                )
        then:
        responseEntity.statusCode.value() == HttpStatus.CREATED.value()

        
        where:
        produces << ['application/xml', 'application/json']
    }
    
  
      
    @Unroll
    def 'should return valid response from GET /v2/user/login with accepting: #produces'() {
        given:
            
            headers.setAccept(Arrays.asList(MediaType.parseMediaType(produces)))
            
            
            
            

            
            
            
            
            

        when:
        def ResponseEntity<String> responseEntity = restTemplate.exchange(
                        '/v2/user/login?username=user1&password=user-password',
                        HttpMethod.GET,
                        prepareEntity(entity),
                        String
                )
        then:
        responseEntity.statusCode.value() == HttpStatus.OK.value()

        
        where:
        produces << ['text/plain']
    }
    
  
      
    @Unroll
    def 'should return valid response from GET /v2/user/logout with accepting: #produces'() {
        given:
            
            headers.setAccept(Arrays.asList(MediaType.parseMediaType(produces)))
            
            

            
            
            

        when:
        def ResponseEntity<Void> responseEntity = restTemplate.exchange(
                        '/v2/user/logout',
                        HttpMethod.GET,
                        prepareEntity(entity),
                        Void
                )
        then:
        responseEntity.statusCode.value() == HttpStatus.OK.value()

        
        where:
        produces << ['application/xml', 'application/json']
    }
    
  
      
    @Unroll
    def 'should return valid response from GET /v2/user/{username} with accepting: #produces'() {
        given:
            
            headers.setAccept(Arrays.asList(MediaType.parseMediaType(produces)))
            
            
            

            
            
            
            

        when:
        def ResponseEntity<User> responseEntity = restTemplate.exchange(
                        '/v2/user/user1',
                        HttpMethod.GET,
                        prepareEntity(entity),
                        User
                )
        then:
        responseEntity.statusCode.value() == HttpStatus.OK.value()

        
        where:
        produces << ['application/xml', 'application/json']
    }
    
    @Unroll
    def 'should return valid response from PUT /v2/user/{username} with accepting: #produces'() {
        given:
            
            headers.setAccept(Arrays.asList(MediaType.parseMediaType(produces)))
            headers.setContentType(MediaType.parseMediaType('application/json'))
            
            
            

            
            
            HttpEntity<User> entity = new HttpEntity<User>(User.UserBuilder.aUser().build(), headers)
            
            

        when:
        def ResponseEntity<Void> responseEntity = restTemplate.exchange(
                        '/v2/user/user1',
                        HttpMethod.PUT,
                        prepareEntity(entity),
                        Void
                )
        then:
        responseEntity.statusCode.value() == HttpStatus.OK.value()

        
        where:
        produces << ['application/xml', 'application/json']
    }
    
    @Unroll
    def 'should return valid response from DELETE /v2/user/{username} with accepting: #produces'() {
        given:
            
            headers.setAccept(Arrays.asList(MediaType.parseMediaType(produces)))
            
            
            

            
            
            
            

        when:
        def ResponseEntity<Void> responseEntity = restTemplate.exchange(
                        '/v2/user/user1',
                        HttpMethod.DELETE,
                        prepareEntity(entity),
                        Void
                )
        then:
        responseEntity.statusCode.value() == HttpStatus.OK.value()

        
        where:
        produces << ['application/xml', 'application/json']
    }
    
  
}
