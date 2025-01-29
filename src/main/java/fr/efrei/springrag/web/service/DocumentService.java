package fr.efrei.springrag.web.service;

import fr.efrei.springrag.domain.Document;
import fr.efrei.springrag.web.repository.DocumentRepository;

import java.util.List;
import java.util.Optional;

import fr.efrei.springrag.web.rest.DocumentResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DocumentService {
    private static final Logger log = LoggerFactory.getLogger(DocumentResource.class);
    private final DocumentRepository documentRepository;

    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public Document buildAndSave(Document document){
        log.debug("REST request to buildAndSave Document: {}", document);
        return documentRepository.save(document);
    }

    public Optional<Document> findById(Long id){
        log.debug("Request to find Document by id : {}", id);
        return documentRepository.findById(id);
    }

    public void deleteById(Long id){
        log.debug("Request to delete Document by id : {}", id);
        documentRepository.deleteById(id);
    }

    public List<Document> findAll(){
        log.debug("Request to find all Documents");
        return documentRepository.findAll();
    }
}





