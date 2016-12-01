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

import com.mobulum.api.model.Pet
import com.mobulum.api.model.UploadResponse


public class V2PetControllerIntegrationSpec extends AbstractRestControllerIntegrationSpec {

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
    def 'should return valid response from POST /v2/pet with accepting: #produces'() {
        given:
            
            headers.setAccept(Arrays.asList(MediaType.parseMediaType(produces)))
            headers.setContentType(MediaType.parseMediaType('application/json'))
            
            

            
            HttpEntity<Pet> entity = new HttpEntity<Pet>(Pet.PetBuilder.aPet().build(), headers)
            
            

        when:
        def ResponseEntity<Void> responseEntity = restTemplate.exchange(
                        '/v2/pet',
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
    def 'should return valid response from PUT /v2/pet with accepting: #produces'() {
        given:
            
            headers.setAccept(Arrays.asList(MediaType.parseMediaType(produces)))
            headers.setContentType(MediaType.parseMediaType('application/json'))
            
            

            
            HttpEntity<Pet> entity = new HttpEntity<Pet>(Pet.PetBuilder.aPet().build(), headers)
            
            

        when:
        def ResponseEntity<Void> responseEntity = restTemplate.exchange(
                        '/v2/pet',
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
    def 'should return valid response from GET /v2/pet/findByStatus with accepting: #produces'() {
        given:
            
            headers.setAccept(Arrays.asList(MediaType.parseMediaType(produces)))
            
            
            

            
            
            
            

        when:
        def ResponseEntity<List<Pet>> responseEntity = restTemplate.exchange(
                        '/v2/pet/findByStatus?status=1',
                        HttpMethod.GET,
                        prepareEntity(entity),
                        new ParameterizedTypeReference<List<Pet>>() {}
                )
        then:
        responseEntity.statusCode.value() == HttpStatus.OK.value()

        
        where:
        produces << ['application/xml', 'application/json']
    }
    
  
      
    @Unroll
    def 'should return valid response from GET /v2/pet/findByTags with accepting: #produces'() {
        given:
            
            headers.setAccept(Arrays.asList(MediaType.parseMediaType(produces)))
            
            
            

            
            
            
            

        when:
        def ResponseEntity<List<Pet>> responseEntity = restTemplate.exchange(
                        '/v2/pet/findByTags?tags=example',
                        HttpMethod.GET,
                        prepareEntity(entity),
                        new ParameterizedTypeReference<List<Pet>>() {}
                )
        then:
        responseEntity.statusCode.value() == HttpStatus.OK.value()

        
        where:
        produces << ['application/xml', 'application/json']
    }
    
  
      
    @Unroll
    def 'should return valid response from GET /v2/pet/{petId} with accepting: #produces'() {
        given:
            
            headers.setAccept(Arrays.asList(MediaType.parseMediaType(produces)))
            
            
            

            
            
            
            

        when:
        def ResponseEntity<Pet> responseEntity = restTemplate.exchange(
                        '/v2/pet/12345',
                        HttpMethod.GET,
                        prepareEntity(entity),
                        Pet
                )
        then:
        responseEntity.statusCode.value() == HttpStatus.OK.value()

        
        where:
        produces << ['application/xml', 'application/json']
    }
    
    @Unroll
    def 'should return valid response from POST /v2/pet/{petId} with accepting: #produces'() {
        given:
            
            headers.setAccept(Arrays.asList(MediaType.parseMediaType(produces)))
            headers.setContentType(MediaType.parseMediaType('application/x-www-form-urlencoded'))
            
            
            
            

            
            
            
            
            
            

        when:
        def ResponseEntity<Void> responseEntity = restTemplate.exchange(
                        '/v2/pet/12345?name=pet&status=available',
                        HttpMethod.POST,
                        prepareEntity(entity),
                        Void
                )
        then:
        responseEntity.statusCode.value() == HttpStatus.CREATED.value()

        
        where:
        produces << ['application/xml', 'application/json']
    }
    
    
    def 'should return valid response from DELETE /v2/pet/{petId}'() {
        given:
            
            
            headers.set('api_key', 'val')
            
            

            
            
            
            
            

        when:
        def ResponseEntity<Void> responseEntity = restTemplate.exchange(
                        '/v2/pet/12345',
                        HttpMethod.DELETE,
                        prepareEntity(entity),
                        Void
                )
        then:
        responseEntity.statusCode.value() == HttpStatus.NO_CONTENT.value()

        
    }
    
  
      
    @Unroll
    def 'should return valid response from POST /v2/pet/{petId}/uploadImage with accepting: #produces'() {
        given:
            
            headers.setAccept(Arrays.asList(MediaType.parseMediaType(produces)))
            headers.setContentType(MediaType.parseMediaType('multipart/form-data'))
            
            
            
            

            
            MultiValueMap<String, Object> multipartMap = new LinkedMultiValueMap<>()
            
            
            multipartMap.add('file', new ClassPathResource('application.yml'))
            
            HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<MultiValueMap<String, Object>>(multipartMap, headers)
            

        when:
        def ResponseEntity<UploadResponse> responseEntity = restTemplate.exchange(
                        '/v2/pet/12345/uploadImage?additionalMetadata=Additional%20data%20to%20pass%20to%20server',
                        HttpMethod.POST,
                        prepareEntity(entity),
                        UploadResponse
                )
        then:
        responseEntity.statusCode.value() == HttpStatus.CREATED.value()

        
        where:
        produces << ['application/json']
    }
    
  
}
