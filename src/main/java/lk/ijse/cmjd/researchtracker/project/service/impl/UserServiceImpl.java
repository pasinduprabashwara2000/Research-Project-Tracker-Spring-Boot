package lk.ijse.cmjd.researchtracker.project.service.impl;

import lk.ijse.cmjd.researchtracker.project.DAO.UserDAO;
import lk.ijse.cmjd.researchtracker.project.DTO.UserDTO;
import lk.ijse.cmjd.researchtracker.project.entity.UserEntity;
import lk.ijse.cmjd.researchtracker.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Override
    public void save(UserDTO userDTO) throws Exception {
        try {
            UserEntity userEntity = new UserEntity(
                    userDTO.getId(),
                    userDTO.getUsername(),
                    userDTO.getPassword(),
                    userDTO.getFullName(),
                    userDTO.getUserRoleEnum(),
                    userDTO.getCreatedAt()
            );
            userDAO.save(userEntity);
        } catch (Exception e) {
            throw new Exception("User Saved Failed : " + e.getMessage());
        }
    }

    @Override
    public void update(String id, UserDTO userDTO) throws Exception {
        Optional<UserEntity> userExists = userDAO.findById(id);
        try {
            if (userExists.isPresent()) {
                UserEntity userEntity = userExists.get();
                userEntity.setUsername(userDTO.getUsername());
                userEntity.setPassword(userDTO.getPassword());
                userEntity.setFullName(userDTO.getFullName());
                userEntity.setUserRoleEnum(userDTO.getUserRoleEnum());
                userEntity.setCreatedAt(userDTO.getCreatedAt());
                userDAO.save(userEntity);
            } else {
                throw new Exception("User with " + id + " not found");
            }
        } catch (Exception e) {
            throw new Exception("User Update Failed " + e.getMessage());
        }
    }

    @Override
    public void delete(String id) throws Exception {
        try {
            if (userDAO.existsById(id)) {
                userDAO.deleteById(id);
            } else {
                throw new Exception("User with " + id + " not found");
            }
        } catch (Exception e) {
            throw new Exception("User Update Failed " + e.getMessage());
        }
    }

    @Override
    public UserDTO search(String id) throws Exception {
        Optional<UserEntity> userExists = userDAO.findById(id);
        try {
            if (userExists.isPresent()) {
                UserEntity userEntity = userExists.get();
                return new UserDTO(
                        userEntity.getId(),
                        userEntity.getUsername(),
                        userEntity.getPassword(),
                        userEntity.getFullName(),
                        userEntity.getUserRoleEnum(),
                        userEntity.getCreatedAt()
                );
            } else {
                throw new Exception("User with " + id + " not found");
            }
        } catch (Exception e) {
            throw new Exception("User Search Failed : " + e.getMessage());
        }
    }

    @Override
    public ArrayList<UserDTO> getAll() throws Exception {

        List<UserEntity> userEntities = userDAO.findAll();

        try {
            ArrayList<UserDTO> userDTOS = new ArrayList<>();

            for (UserEntity userEntity : userEntities) {
                userDTOS.add(new UserDTO(
                        userEntity.getId(),
                        userEntity.getUsername(),
                        userEntity.getPassword(),
                        userEntity.getFullName(),
                        userEntity.getUserRoleEnum(),
                        userEntity.getCreatedAt()
                ));
            }
            return userDTOS;
        } catch (Exception e) {
            throw new Exception("Can't Retrieve Data  : " + e.getMessage());
        }

    }
}