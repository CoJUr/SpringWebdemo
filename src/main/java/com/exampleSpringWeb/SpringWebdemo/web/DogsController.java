package com.exampleSpringWeb.SpringWebdemo.web;

import com.exampleSpringWeb.SpringWebdemo.model.DogDto;
import com.exampleSpringWeb.SpringWebdemo.repo.Dog;
import com.exampleSpringWeb.SpringWebdemo.service.DogsService;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public List<Dog> getDogs() {
        return dogsService.getDogs();
    }

//    @GetMapping
//    public ResponseEntity<List<Dog>> getDogs() {
//        return new ResponseEntity<>(dogsService.getDogs(), HttpStatus.OK);
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
        //duplication = bad. better to make a ControllerAdvice

//    }


    @GetMapping("/{id}")
    public Dog getById(@PathVariable(required = true) long id) {
        return dogsService.getDogById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(required = true) long id) {
        dogsService.delete(id);
    }


}
