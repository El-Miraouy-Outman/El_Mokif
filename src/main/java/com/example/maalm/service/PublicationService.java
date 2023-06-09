package com.example.maalm.service;

import com.example.maalm.Dto.PublicationDto;
import com.example.maalm.entities.Publication;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PublicationService {
    public List<Publication> publicationAll() ;
    public  List<PublicationDto> accepterPublication();
    List<PublicationDto> refuserPublication();
    public Publication findById(Long IDPUB);
    public List<Publication> findByMaalm(Long idMamm) throws Exception;

    public boolean deleteById(Long IDPUB);
    public Publication acceptePublication(Long idPub);
    public boolean updatePublication(Publication PUB);
    public boolean update(Publication PUB);

    public Publication insert(Publication publication,Long IdPublicateur,String servicaName) throws Exception;



}
