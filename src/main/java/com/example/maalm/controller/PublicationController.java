package com.example.maalm.controller;

import com.example.maalm.Dto.PublicationDto;
import com.example.maalm.entities.Publication;
import com.example.maalm.service.PublicationService;
import lombok.RequiredArgsConstructor;
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
    @PutMapping
    public boolean updatePublication(@RequestBody Publication publication) throws Exception {
        return publicationService.update(publication);
    }
    @GetMapping
    public List<Publication> publicationAll() {
        return publicationService.publicationAll();
    }

    @GetMapping("/{IDPUB}")
    public Publication findById(@PathVariable Long IDPUB) {
        return publicationService.findById(IDPUB);
    }

    @PutMapping("/accepter/{idPub}")
    public Publication accepterPublication(@PathVariable Long idPub){
        return publicationService.acceptePublication(idPub);
    }
    @GetMapping("/accepter")
    public  List<PublicationDto> publicationAccepter(){
        return publicationService.accepterPublication();
    }

    @GetMapping("/refuser")
    public  List<PublicationDto> publicationRefudser(){
        return publicationService.refuserPublication();
    }

    @DeleteMapping("/{IDPUB}")
    public boolean deleteById(@PathVariable Long IDPUB) {
        return publicationService.deleteById(IDPUB);
    }

    @PostMapping("/publicateur/{idPublicateur}/service/{serviceName}")
    public Publication insert(@RequestBody Publication publication,@PathVariable Long idPublicateur,@PathVariable String serviceName) throws Exception {
        return publicationService.insert(publication,idPublicateur,serviceName);
    }
}
