package com.exampleSpringWeb.SpringWebdemo.web;

import com.exampleSpringWeb.SpringWebdemo.repo.Dog;
import com.exampleSpringWeb.SpringWebdemo.service.DogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dogs")
public class DogsController {

    @Autowired
    private final DogsService dogsService;

    public DogsController(DogsService dogsService) {
        this.dogsService = dogsService;
    }

    @GetMapping
    public ResponseEntity<List<Dog>> getDogs() {
        return new ResponseEntity<>(dogsService.getDogs(), HttpStatus.OK);
        //        List<Dog> dogs;

//        try{
//            dogs = dogsService.getDogs();
//
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, null, HttpStatus.INTERNAL_SERVER_ERROR);
////               return ResponseEntity.badRequest().build();
//        } catch (DogsNotFoundException e) {
//            return new ResponseEntity<>(null, null, HttpStatus.NOT_FOUND);
//        }
//          return new ResponseEntity<>(dogs, HttpStatus.OK);
//        }
        //duplication bad. better to make a ControllerAdvice


    }
}
