package ru.hostco.archivarius.controllers;

import ru.hostco.archivarius.config.ApplicationConfig;
import ru.hostco.archivarius.dto.MoContainer;
import ru.hostco.archivarius.dto.MoDTO;
import ru.hostco.archivarius.dto.UsersDTO;
import ru.hostco.archivarius.dto.UsersDataContainer;
//import ru.hostco.archivarius.dto.UsersDataContainer;
import ru.hostco.archivarius.models.User;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.hostco.archivarius.repository.MoRepos;
import ru.hostco.archivarius.repository.UsersRepos;
import ru.hostco.archivarius.soap_examples.SOAPConnector;
import ru.hostco.reguser.types.GetUserRequest;
import ru.hostco.reguser.types.GetUserResponse;

@RestController
@RequiredArgsConstructor(onConstructor_ = { @Autowired })
public class MainController {
    private final IemkClient iemkClient;
    private final UsersRepos usersRepos;
    private final SOAPConnector soapConnector;
    private final MoRepos moRepos;
    private final ApplicationConfig applicationConfig;

    @GetMapping("/user")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<UsersDTO> getUserDTO(@RequestParam(value = "snils") String SNILS) {
        GetUserRequest requets = new GetUserRequest();
        requets.setSNILS(SNILS);
		requets.setToken(applicationConfig.getSoapToken());
        GetUserResponse response = (GetUserResponse) soapConnector.callWebService(
                applicationConfig.getSoapUrl(),
                requets);
        UsersDTO usersDTO = new UsersDTO(
            Long.parseLong(response.getSNILS()),
            response.getLogin().getFirstname(),
            response.getLogin().getLastname(),
            response.getLogin().getMiddlename());
        return new ResponseEntity<>(usersDTO,HttpStatus.OK);
    }

    @GetMapping("/mo")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<MoContainer> getMo(){
        MoContainer moContainer = new MoContainer();
        moRepos.findAll().stream().filter(i -> i.getIs_shown() == true)
            .forEach(o -> moContainer.add(new MoDTO
                (o.getOid(),o.getVersion(),o.getNamefull(),o.getNameshort(),o.getGuid(),o.getIs_shown())));
        return new ResponseEntity<>(moContainer,HttpStatus.OK);
    }

    //@RequestMapping(value="/data" , method = RequestMethod.GET)
    @PostMapping("/data")
    public void dataAdd(@RequestBody User user){
        user.setDate_insert(OffsetDateTime.now());
        usersRepos.save(user);
    }

    @GetMapping("/iemk")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<UsersDataContainer> getPatients(
            @RequestParam(value = "UserSnils", required = false) String UserSnils,
            @RequestParam(value = "UserLastName", required = false) String UserLastName) {
        final UsersDataContainer userList = iemkClient.getContainer(UserSnils, UserLastName);
        if (userList.getUsersContainer().size() == 0){
            return null;
        }
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }
}
