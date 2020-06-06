package com.example.webappSocket.controller;

import com.example.webappSocket.model.Dish;
import com.example.webappSocket.model.Response;
import com.example.webappSocket.model.TypeDish;
import com.example.webappSocket.repository.I_DishRepository;
import com.example.webappSocket.repository.I_TypeDishRepository;
import com.example.webappSocket.service.FilesStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@CrossOrigin(origins = "*")
public class DishController {

    @Autowired
    I_DishRepository dishRepository;

    @Autowired
    I_TypeDishRepository typeDishRepository;

    @Autowired
    FilesStorageService storageService;

    @GetMapping(value = "/pub/get-all-dish")
    public List<Dish> getAllDish() {
        List<Dish> allDish = new ArrayList<>();
        allDish = dishRepository.getAllDish();
        return allDish;
    }

    public String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/uploads";

    public String UPLOAD = "http://localhost:8080/files";

    @CrossOrigin
    @PostMapping(path = "/pub/add-dish", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseBody
    public Response addNewDish(@RequestParam("file") MultipartFile file, Dish dish, @RequestParam("type_name") String nameType) throws IOException {

        if(checkInfo(dish,nameType)){
            StringBuilder fileBuilder = new StringBuilder();

            Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, file.getOriginalFilename());
            fileBuilder.append(file.getOriginalFilename());
            Files.write(fileNameAndPath, file.getBytes());

            Dish new_dish = new Dish();
            new_dish.setName(dish.getName());
            new_dish.setImage(UPLOAD + "/" + file.getOriginalFilename());
            new_dish.setCost(dish.getCost());
            new_dish.setDescription(dish.getDescription());
            TypeDish type = new TypeDish();
            type.setName(nameType);
            if (typeDishRepository.getTypeDishByName(nameType).size() > 0) {
                TypeDish typeTmp = typeDishRepository.getTypeDishByName(nameType).get(0);
                type.setId(typeTmp.getId());
            } else {
                typeDishRepository.save(type);
                TypeDish typeTmp = typeDishRepository.getTypeDishByName(nameType).get(0);
                type.setId(typeTmp.getId());
            }
            new_dish.setTypeDish(type);
            dishRepository.save(new_dish);
            return (new Response("ok","200"));
        }
        else{
            return (new Response("error","400"));
        }
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = storageService.load(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    public boolean checkInfo(Dish dish, String nameType) {

        try {
            String name = dish.getName();
            int cost = dish.getCost();
            String des = dish.getDescription();
            String type = nameType;

            if(checkCharacter(name)&&checkCharacter(des)&&checkCharacter(type)){
                return true;
            }
            else {
                return false;
            }

        } catch (Exception e) {
            return false;
        }
    }

    public boolean checkCharacter(String str){
        if(str.contains("*")||str.contains("select")){
            return false;
        }
        else {
            return true;
        }
    }


}
