package com.codegym.controller;

import com.codegym.model.Smartphone;
import com.codegym.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phone/api/v1")
@CrossOrigin
public class SmartPhoneController {
    @Autowired
    private ISmartphoneService smartphoneService;

    @GetMapping
    public ResponseEntity<Iterable<Smartphone>> allPhones() {
        return new ResponseEntity<>(smartphoneService.findAll(), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Smartphone> createSmartphone(@RequestBody Smartphone smartphone) {
        return new ResponseEntity<>(smartphoneService.save(smartphone), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Smartphone> findById(@PathVariable Long id) {
//        if (!smartphoneService.findById(id).isPresent()){
//            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
//        }
        return new ResponseEntity<>(smartphoneService.findById(id), HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Smartphone> updatePhone(@PathVariable Long id,
                                                 @RequestBody Smartphone smartphone) {
        Smartphone currentSmartphone = smartphoneService.findById(id);
        if (currentSmartphone == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        currentSmartphone.setModel(smartphone.getModel());
        currentSmartphone.setPrice(smartphone.getPrice());
        currentSmartphone.setProducer(smartphone.getProducer());

        smartphoneService.save(currentSmartphone);
        return new ResponseEntity<>(currentSmartphone, HttpStatus.OK);
    }
}
