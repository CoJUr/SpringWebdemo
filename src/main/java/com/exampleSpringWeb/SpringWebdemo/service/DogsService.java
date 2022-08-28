package com.exampleSpringWeb.SpringWebdemo.service;

import com.exampleSpringWeb.SpringWebdemo.model.DogDto;
import com.exampleSpringWeb.SpringWebdemo.repo.Dog;
import com.exampleSpringWeb.SpringWebdemo.repo.MockDogProvider;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DogsService {

    private MockDogProvider mockDogProvider;

  public void setMockDogProvider(MockDogProvider mockDogProvider) {
    this.mockDogProvider = mockDogProvider;
  }

    public MockDogProvider getMockDogProvider() {
        return mockDogProvider;
    }

    public void add(DogDto dto) {
        mockDogProvider.add(dto);
    }

    public void delete(long id) {
        mockDogProvider.delete(id);
    }

    public List<Dog> getDogs() {
        return mockDogProvider.getDogs();
    }

    public Dog getDogById(long id) {
        return mockDogProvider.findDogById(id);
    }


}
