package lk.ijse.cmjd.researchtracker.project.service;

import lk.ijse.cmjd.researchtracker.project.DTO.UserDTO;
import java.util.ArrayList;

public interface UserService {

    void save(UserDTO userDTO) throws Exception;
    void update(String id, UserDTO userDTO) throws Exception;
    void delete(String id) throws Exception;
    UserDTO search(String id) throws Exception;
    ArrayList<UserDTO> getAll() throws Exception;

}
