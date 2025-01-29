package fr.efrei.springrag.repository;

import fr.efrei.springrag.domain.Document;
import fr.efrei.springrag.repository.dto.DocumentDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;


@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
    @Query(
            "select distinct new fr.efrei.springrag.repository.dto.DocumentDTO(document.title, document.content) from Document document"
    )
    List<DocumentDTO> findAllDocumentDTO();
}