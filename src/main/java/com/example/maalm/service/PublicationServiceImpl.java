package com.example.maalm.service;

import com.example.maalm.Dto.PublicationDto;
import com.example.maalm.entities.Etat;
import com.example.maalm.entities.Maalm;
import com.example.maalm.entities.Publication;
import com.example.maalm.repository.PublicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class PublicationServiceImpl implements PublicationService {
    private final PublicationRepository publicationRepository;
    private final MaalmService maalmService;
    private final ServiceService serviceService;

    @Override
    public List<Publication> findByMaalm(Long idMamm) throws Exception {
        Maalm maalm=maalmService.findById(idMamm);
        List<Publication> listePub=publicationRepository.findByMaalm(maalm);

        return listePub;
    }


    @Override
    public List<Publication> publicationAll() {
        return publicationRepository.findAll();
    }

    @Override
    public List<PublicationDto> accepterPublication() {
        List<Publication> liste=publicationRepository.findByEtat(Etat.ACCEPTE);
        List<PublicationDto> listeDto=liste.stream()
                .map(publication ->{
                    PublicationDto pub=PublicationDto.builder()
                            .build();
                    BeanUtils.copyProperties(publication,pub);
                    return pub;
                })
                .collect(Collectors.toList());
        return  listeDto;
    }

    @Override
    public Publication findById(Long IDPUB) {
        return null;
    }

    @Override
    public boolean deleteById(Long IDPUB) {
       publicationRepository.deleteById(IDPUB);
       return  true;
    }

    @Override
    public Publication acceptePublication(Long idPub) {
        Publication pub=publicationRepository.findById(idPub).get();
        pub.setEtat(Etat.ACCEPTE);
        return publicationRepository.save(pub);

    }


    @Override
    public Publication insert(Publication publication, Long idPublicateur, String servicaName) throws Exception {
        Maalm maalm = maalmService.findById(idPublicateur);
        com.example.maalm.entities.Service service=serviceService.getServiceByName(servicaName);
        publication.setDatecreation(new Date());
        publication.setService(service);
        publication.setMaalm(maalm);
        publication.setEtat(Etat.ATTENTE);
        return publicationRepository.save(publication);
    }
}
