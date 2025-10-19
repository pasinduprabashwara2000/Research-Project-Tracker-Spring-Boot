package lk.ijse.cmjd.researchtracker.project.service;

import lk.ijse.cmjd.researchtracker.project.DTO.DocumentDTO;
import java.util.ArrayList;

public interface DocumentService {

    void save(DocumentDTO documentDTO) throws Exception;
    void update(String id, DocumentDTO documentDTO) throws Exception;
    void delete(String id) throws Exception;
    DocumentDTO search (String id) throws Exception;
    ArrayList <DocumentDTO> getAll() throws Exception;

}
