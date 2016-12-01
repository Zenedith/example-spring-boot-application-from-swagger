package com.mobulum.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(builder = Pet.PetBuilder.class)
public class Pet {
    private final Long id;
    private final Category category;
    private final String name;
    private final List<String> photoUrls;
    private final List<Tag> tags;
    private final PetStatus status;
    

    private Pet(Long id, Category category, String name, List<String> photoUrls, List<Tag> tags, PetStatus status) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
        
    }

    public Long getId() {
      return id;
    }
    public Category getCategory() {
      return category;
    }
    public String getName() {
      return name;
    }
    public List<String> getPhotoUrls() {
      return photoUrls;
    }
    public List<Tag> getTags() {
      return tags;
    }
    public PetStatus getStatus() {
      return status;
    }
    


    @Override
    public int hashCode() {
        return Objects.hash(id, category, name, photoUrls, tags, status);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Pet other = (Pet) obj;
        return Objects.equals(this.id, other.id) && 
                Objects.equals(this.category, other.category) && 
                Objects.equals(this.name, other.name) && 
                Objects.equals(this.photoUrls, other.photoUrls) && 
                Objects.equals(this.tags, other.tags) && 
                Objects.equals(this.status, other.status);
                
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id='" + id + "', " +
                "category='" + category + "', " +
                "name='" + name + "', " +
                "photoUrls='" + photoUrls + "', " +
                "tags='" + tags + "', " +
                "status='" + status + "'" +
                '}';
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonPOJOBuilder
    public static final class PetBuilder {
        private Long id;
        private Category category;
        private String name;
        private List<String> photoUrls;
        private List<Tag> tags;
        private PetStatus status;
        

        private PetBuilder() {
        }

        public static PetBuilder aPet() {
            return new PetBuilder();
        }

        public PetBuilder withId(Long id) {
          this.id = id;
          return this;
        }
        public PetBuilder withCategory(Category category) {
          this.category = category;
          return this;
        }
        public PetBuilder withName(String name) {
          this.name = name;
          return this;
        }
        public PetBuilder withPhotoUrls(List<String> photoUrls) {
          this.photoUrls = photoUrls;
          return this;
        }
        public PetBuilder withTags(List<Tag> tags) {
          this.tags = tags;
          return this;
        }
        public PetBuilder withStatus(PetStatus status) {
          this.status = status;
          return this;
        }
        

        public Pet build() {
            return new Pet(id, category, name, photoUrls, tags, status);
        }
    }
}
