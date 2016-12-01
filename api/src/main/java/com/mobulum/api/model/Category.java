package com.mobulum.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(builder = Category.CategoryBuilder.class)
public class Category {
    private final Long id;
    private final String name;
    

    private Category(Long id, String name) {
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
        final Category other = (Category) obj;
        return Objects.equals(this.id, other.id) && 
                Objects.equals(this.name, other.name);
                
    }

    @Override
    public String toString() {
        return "Category{" +
                "id='" + id + "', " +
                "name='" + name + "'" +
                '}';
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonPOJOBuilder
    public static final class CategoryBuilder {
        private Long id;
        private String name;
        

        private CategoryBuilder() {
        }

        public static CategoryBuilder aCategory() {
            return new CategoryBuilder();
        }

        public CategoryBuilder withId(Long id) {
          this.id = id;
          return this;
        }
        public CategoryBuilder withName(String name) {
          this.name = name;
          return this;
        }
        

        public Category build() {
            return new Category(id, name);
        }
    }
}
