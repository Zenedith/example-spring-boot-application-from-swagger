package com.mobulum.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(builder = UploadResponse.UploadResponseBuilder.class)
public class UploadResponse {
    private final Integer code;
    private final String type;
    private final String message;
    

    private UploadResponse(Integer code, String type, String message) {
        this.code = code;
        this.type = type;
        this.message = message;
        
    }

    public Integer getCode() {
      return code;
    }
    public String getType() {
      return type;
    }
    public String getMessage() {
      return message;
    }
    


    @Override
    public int hashCode() {
        return Objects.hash(code, type, message);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final UploadResponse other = (UploadResponse) obj;
        return Objects.equals(this.code, other.code) && 
                Objects.equals(this.type, other.type) && 
                Objects.equals(this.message, other.message);
                
    }

    @Override
    public String toString() {
        return "UploadResponse{" +
                "code='" + code + "', " +
                "type='" + type + "', " +
                "message='" + message + "'" +
                '}';
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonPOJOBuilder
    public static final class UploadResponseBuilder {
        private Integer code;
        private String type;
        private String message;
        

        private UploadResponseBuilder() {
        }

        public static UploadResponseBuilder aUploadResponse() {
            return new UploadResponseBuilder();
        }

        public UploadResponseBuilder withCode(Integer code) {
          this.code = code;
          return this;
        }
        public UploadResponseBuilder withType(String type) {
          this.type = type;
          return this;
        }
        public UploadResponseBuilder withMessage(String message) {
          this.message = message;
          return this;
        }
        

        public UploadResponse build() {
            return new UploadResponse(code, type, message);
        }
    }
}
