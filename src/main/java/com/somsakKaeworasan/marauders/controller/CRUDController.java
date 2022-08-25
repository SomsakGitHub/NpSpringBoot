package com.somsakKaeworasan.marauders.controller;

import com.somsakKaeworasan.marauders.model.CRUD;
import com.somsakKaeworasan.marauders.service.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/CRUD")
public class CRUDController {

    @Autowired
    private CRUDService crudService;

    @GetMapping("/getAll")
    public ResponseEntity getAll(){

        try {
            var res = crudService.getAll();
            return ResponseEntity.status(HttpStatus.OK).body(res);
        }
        catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.toString());
        }
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody CRUD crud){

        try {
            var res = crudService.add(crud);
            return ResponseEntity.status(HttpStatus.OK).body(res);
        }
        catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.toString());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody CRUD crud){

        try {
            var res = crudService.update(id, crud);
            return ResponseEntity.status(HttpStatus.OK).body(res);
        }
        catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.toString());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){

        try {
            var res = crudService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body(res);
        }
        catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.toString());
        }
    }

}
