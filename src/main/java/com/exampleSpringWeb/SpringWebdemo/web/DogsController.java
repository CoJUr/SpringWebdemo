package com.exampleSpringWeb.SpringWebdemo.web;

import com.exampleSpringWeb.SpringWebdemo.model.DogDto;
import com.exampleSpringWeb.SpringWebdemo.repo.Dog;
import com.exampleSpringWeb.SpringWebdemo.service.DogsService;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dogs")
@RequiredArgsConstructor
@Setter
public class DogsController {

    @Autowired
    private final DogsService dogsService;

    @PostMapping
    public void postDogs(@RequestBody DogDto dto) {
        dogsService.add(dto);
    }

//    @GetMapping
//    public List<Dog> getDogs() {
//        return dogsService.getDogs();
//    }

    @GetMapping
    public ResponseEntity<List<Dog>> getDogs() {
        return new ResponseEntity<>(dogsService.getDogs(), HttpStatus.OK);
                List<Dog> dogs;

//        try{
//            dogs = dogsService.getDogs();
//        } catch (DogsServiceException ex) {
//            return new ResponseEntity<>(null, null, HttpStatus.INTERNAL_SERVER_ERROR);
////               return ResponseEntity.badRequest().build();
//        } catch (DogsNotFoundException e) {
//            return new ResponseEntity<>(null, null, HttpStatus.NOT_FOUND);
//        }
//          return new ResponseEntity<>(dogs, HttpStatus.OK);
//        }
        //duplication = bad. generic catch blocks, and will need them at other endpoints (post, delete). better to make a ControllerAdvice

    }


    @GetMapping("/{id}")
    public Dog getById(@PathVariable(required = true) long id) {
        return dogsService.getDogById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(required = true) long id) {
        dogsService.delete(id);
    }




    //sample POST with curl:
/*    curl -X POST \
    http://localhost:8080/dogs \
           -H 'Content-Type: application/json' \
            -H 'Postman-Token: c6813aea-146c-49cd-9eba-1370aad4bff9' \
          -H 'cache-control: no-cache' \
           -d '{
           "id": 6,
           "name": "Hooch",
            "age": 11
}' */

    //delete request with curl:
    /*
    curl -X DELETE \
    http://localhost:8080/dogs/5 \
            -H 'Content-Type: application/json' \
            -H 'Postman-Token: b4b93304-7ee7-45c2-917b-c3bc2985a250' \
            -H 'cache-control: no-cache' */

//general form for curl command making a POST request:
//    curl -X POST [options] [URL]

    //curl post with -f flag: field=value pairs. example sending a POST request to a form with name and email fields:
//    curl -X POST -F 'name=linuxize' -F 'email=linuxize@example.com' https://example.com/contact.php


    //curl POST request with -d flag sends data using the application/x-www-form-urlencoded content type:
    //curl -X POST -d 'name=linuxize' -d 'email=linuxize@example.com' https://example.com/contact.php




}
