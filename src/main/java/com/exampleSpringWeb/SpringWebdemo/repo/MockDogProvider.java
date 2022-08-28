package com.exampleSpringWeb.SpringWebdemo.repo;

import com.exampleSpringWeb.SpringWebdemo.model.DogDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//this will be a mock data provider component. CRUD methods perform operations on the list of Dogs
@Component
public class MockDogProvider {
    private List<Dog> mockDogStore;

    public MockDogProvider() {
        mockDogStore = new ArrayList<>(Arrays.asList(
                new Dog(1, "Rex", 3),
                new Dog(2, "Buddy", 5),
                new Dog(3, "Max", 2),
                new Dog(4, "Bella", 4),
                new Dog(5, "Lucy", 1)
        ));

//        mockDogStore.Add(Dog.of(1, "Benji", 10));
//        mockDogStore.Add(Dog.of(2, "Snoopy", 9));
//        mockDogStore.Add(Dog.of(3, "Lassie", 8));
//        mockDogStore.Add(Dog.of(4, "Scooby", 10));
//        mockDogStore.Add(Dog.of(5, "Rin Tin Tin", 12));
    }

    public List<Dog> getDogs() {
        return mockDogStore;
    }

    public Dog findDogById(long id) {
        for (Dog dog : mockDogStore) {
            if (dog.getId() == id) {
                return dog;
            }
        }
        return null;
    }

    public void add(DogDto dto) {
        mockDogStore.add(new Dog(dto.getId(), dto.getName(), dto.getAge()));
    }

    public void delete(long id) {

        int idx = 0;
        for (; idx < mockDogStore.size(); idx++) {
            if (mockDogStore.get(idx).getId() == id) {
                break;
            }
        }
        mockDogStore.remove(idx);
//        mockDogStore.removeIf(dog -> dog.getId() == id);
    }
}

//now need to create a controller to handle the requests and delegate to the service layer