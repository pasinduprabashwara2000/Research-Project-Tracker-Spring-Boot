package lk.ijse.cmjd.researchtracker.project.service.impl;

import lk.ijse.cmjd.researchtracker.project.DAO.DocumentDAO;
import lk.ijse.cmjd.researchtracker.project.DTO.DocumentDTO;
import lk.ijse.cmjd.researchtracker.project.entity.DocumentEntity;
import lk.ijse.cmjd.researchtracker.project.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DocumentServiceImpl implements DocumentService {

    private final DocumentDAO documentDAO;

    @Override
    public void save(DocumentDTO documentDTO) throws Exception {

        try {
            DocumentEntity documentEntity = new DocumentEntity(
                documentDTO.getId(),
                documentDTO.getProjectID(),
                documentDTO.getTitle(),
                documentDTO.getDescription(),
                documentDTO.getUrlOrPath(),
                documentDTO.getUploadedBy(),
                documentDTO.getUploadedAt()
            );
            documentDAO.save(documentEntity);
        } catch (Exception e) {
            throw new Exception("Document Saved Failed "+e.getMessage());
        }
    }

    @Override
    public void update(String id, DocumentDTO documentDTO) throws Exception {
        Optional <DocumentEntity> documentExists = documentDAO.findById(id);

        try {
            if(documentExists.isPresent()){
                DocumentEntity documentEntity = documentExists.get();
                documentEntity.setProjectID(documentDTO.getProjectID());
                documentEntity.setTitle(documentDTO.getTitle());
                documentEntity.setDescription(documentDTO.getDescription());
                documentEntity.setUrlOrPath(documentDTO.getUrlOrPath());
                documentEntity.setUploadedBy(documentDTO.getUploadedBy());
                documentEntity.setUploadedAt(documentDTO.getUploadedAt());
                documentDAO.save(documentEntity);
            } else {
                throw new Exception("Document with "+id+" not found");
            }
        } catch (Exception e) {
            throw new Exception("Document Update Failed "+e.getMessage());
        }
    }

    @Override
    public void delete(String id) throws Exception {

        try {
            if(documentDAO.existsById(id)){
                documentDAO.deleteById(id);
            } else {
                throw new Exception("Document with "+id+" not found");
            }
        } catch (Exception e) {
            throw new Exception("Document Deleted Failed "+e.getMessage());
        }
    }

    @Override
    public DocumentDTO search(String id) throws Exception {

        Optional <DocumentEntity> documentExists = documentDAO.findById(id);

        try {
            if (documentExists.isPresent()) {
                DocumentEntity documentEntity = documentExists.get();
                return new DocumentDTO(
                        documentEntity.getId(),
                        documentEntity.getProjectID(),
                        documentEntity.getTitle(),
                        documentEntity.getDescription(),
                        documentEntity.getUrlOrPath(),
                        documentEntity.getUploadedBy(),
                        documentEntity.getUploadedAt()
                );
            } else {
                throw new Exception("Document with " + id + " not found");
            }
        } catch (Exception e) {
            throw new Exception("Document Search Failed : "+e.getMessage());
        }

    }

    @Override
    public ArrayList<DocumentDTO> getAll() throws Exception {

        List <DocumentEntity> documentEntities = documentDAO.findAll();

        try {
            ArrayList <DocumentDTO> documentDTOS = new ArrayList<>();
        for(DocumentEntity documentEntity : documentEntities) {
            documentDTOS.add(new DocumentDTO(
                    documentEntity.getId(),
                    documentEntity.getProjectID(),
                    documentEntity.getTitle(),
                    documentEntity.getDescription(),
                    documentEntity.getUrlOrPath(),
                    documentEntity.getUploadedBy(),
                    documentEntity.getUploadedAt()
            ));
        }
            return documentDTOS;

        } catch (Exception e) {
            throw new Exception("Can't Retrieve Data : "+e.getMessage());
        }
    }
}
