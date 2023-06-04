package com.example.maalm.controller;

import com.example.maalm.entities.Maalm;
import com.example.maalm.service.MaalmService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/maalms")
@CrossOrigin(origins = "*")
public class MaalmController  {

    private final MaalmService service;


    @GetMapping("/cin/{cin}")
    public Maalm getMaalmByCni(@PathVariable String cin) throws Exception {
        return service.getMaalmByCni(cin);
    }
   @GetMapping("/email/{email}/code/{code}")
    public  Maalm findByEmailAndCode(@PathVariable String email,@PathVariable String code) throws Exception {
        return service.findByEmailAndPASS(email, code);
    }

    @PostMapping
    public Maalm saveMaalm(@RequestBody Maalm maalm) {
        return service.saveMaalm(maalm);
    }

    @PutMapping
    public Maalm updateMaalm(@RequestBody Maalm maalm) throws Exception {
        System.out.println(maalm);
        return service.updateMaalm(maalm);
    }

    @DeleteMapping("/{id}")
    public boolean deleteMaalmById(@PathVariable Long id) throws Exception {
        return service.deleteMaalmById(id);
    }

    @GetMapping("/{id}")
    public Maalm getMaalmById(@PathVariable Long id) throws Exception {
        return service.findById(id) ;
    }

    @GetMapping
    public List<Maalm> getAllMaalm() {
        return service.getAllMaalm();
    }
}
