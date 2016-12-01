package com.mobulum.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(builder = Tag.TagBuilder.class)
public class Tag {
    private final Long id;
    private final String name;
    

    private Tag(Long id, String name) {
        this.id = id;
        this.name = name;
        
    }

    public Long getId() {
      return id;
    }
    public String getName() {
      return name;
    }
    


    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Tag other = (Tag) obj;
        return Objects.equals(this.id, other.id) && 
                Objects.equals(this.name, other.name);
                
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id='" + id + "', " +
                "name='" + name + "'" +
                '}';
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonPOJOBuilder
    public static final class TagBuilder {
        private Long id;
        private String name;
        

        private TagBuilder() {
        }

        public static TagBuilder aTag() {
            return new TagBuilder();
        }

        public TagBuilder withId(Long id) {
          this.id = id;
          return this;
        }
        public TagBuilder withName(String name) {
          this.name = name;
          return this;
        }
        

        public Tag build() {
            return new Tag(id, name);
        }
    }
}
