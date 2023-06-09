package com.example.maalm.service;

import com.example.maalm.Dto.MaalmDto;
import com.example.maalm.Dto.PublicationDto;
import com.example.maalm.Dto.ServiceDto;
import com.example.maalm.entities.Etat;
import com.example.maalm.entities.Maalm;
import com.example.maalm.entities.Publication;
import com.example.maalm.repository.PublicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
                    PublicationDto pub=PublicationDto.builder().build();
                    Maalm maalm=publication.getMaalm();
                    MaalmDto maalmDto=MaalmDto.builder().build();
                    BeanUtils.copyProperties(maalm,maalmDto);
                    ServiceDto serviceDto=ServiceDto.builder().build();
                    com.example.maalm.entities.Service service=publication.getService();
                    BeanUtils.copyProperties(service,serviceDto);
                    BeanUtils.copyProperties(publication,pub);
                    pub.setMaalm(maalmDto);
                    pub.setService(serviceDto);
                    return pub;
                })
                .collect(Collectors.toList());
        return  listeDto;
    }

    @Override
    public List<PublicationDto> refuserPublication() {
        List<Publication> liste=publicationRepository.findByEtat(Etat.ATTENTE);
        List<PublicationDto> listeDto=liste.stream()
                .map(publication ->{
                    PublicationDto pub=PublicationDto.builder().build();
                    Maalm maalm=publication.getMaalm();
                    MaalmDto maalmDto=MaalmDto.builder().build();
                    BeanUtils.copyProperties(maalm,maalmDto);
                    ServiceDto serviceDto=ServiceDto.builder().build();
                    com.example.maalm.entities.Service service=publication.getService();
                    BeanUtils.copyProperties(service,serviceDto);
                    BeanUtils.copyProperties(publication,pub);
                    pub.setMaalm(maalmDto);
                    pub.setService(serviceDto);
                    return pub;
                })
                .collect(Collectors.toList());
        return  listeDto;    }

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
    public boolean updatePublication(Publication PUB) {
        Publication publication=publicationRepository.findById(PUB.getId()).get();
        publication.setDescription(PUB.getDescription());
        publicationRepository.save(publication);
        return true;
    }
    @Override
    public boolean update(Publication PUB) {
        Publication publication=publicationRepository.findById(PUB.getId()).get();
        publication.setDescription(PUB.getDescription());
        publication.setEtat(PUB.getEtat());
        publication.setDatecreation(PUB.getDatecreation());
        publicationRepository.save(publication);
        return true;
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
