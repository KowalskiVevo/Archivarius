package ru.hostco.archivarius.controllers;

import ru.hostco.archivarius.config.ApplicationConfig;
import ru.hostco.archivarius.dto.MoContainer;
import ru.hostco.archivarius.dto.MoDTO;
import ru.hostco.archivarius.dto.UsersDTO;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

//import ru.hostco.archivarius.models.Mo;
//import ru.hostco.archivarius.models.User;
import ru.hostco.archivarius.repository.MoRepos;
//import ru.hostco.archivarius.repository.UsersRepos;
import ru.hostco.archivarius.soap_examples.SOAPConnector;
import ru.hostco.reguser.types.GetUserRequest;
import ru.hostco.reguser.types.GetUserResponse;

@RestController
@RequiredArgsConstructor(onConstructor_ = { @Autowired })
public class MainController {
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
        System.out.println(usersDTO);
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

}
