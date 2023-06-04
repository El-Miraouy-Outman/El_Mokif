package com.example.maalm.controller;

import com.example.maalm.entities.Publication;
import com.example.maalm.service.PublicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/publications")
public class PublicationController {
    private final  PublicationService publicationService;
    @GetMapping("/maalm/{idMaalm}")
    public List<Publication> findByMaalm(@PathVariable Long idMaalm) throws Exception {
        return publicationService.findByMaalm(idMaalm);
    }
    @GetMapping
    public List<Publication> publicationAll() {
        return publicationService.publicationAll();
    }
    @GetMapping("/{IDPUB}")
    public Publication findById(@PathVariable Long IDPUB) {
        return publicationService.findById(IDPUB);
    }
    @GetMapping("/accepter/{idPub}")
    public Publication accepterPublication(@PathVariable Long idPub){
        return publicationService.acceptePublication(idPub);
    }
    @GetMapping("/accepter")
    public  List<Publication> accepterPublication(){
        return publicationService.accepterPublication();
    }
    @DeleteMapping("/{IDPUB}")
    public boolean deleteById(@PathVariable Long IDPUB) {
        return publicationService.deleteById(IDPUB);
    }

    @PostMapping("/service/{idPublicateur}/publicateur/{serviceName}")
    public Publication insert(@RequestBody Publication publication,@PathVariable Long idPublicateur,@PathVariable String serviceName) throws Exception {
        return publicationService.insert(publication,idPublicateur,serviceName);
    }
}
