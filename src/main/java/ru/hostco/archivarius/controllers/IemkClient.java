package ru.hostco.archivarius.controllers;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ru.hostco.archivarius.config.ApplicationConfig;
import ru.hostco.archivarius.dto.UsersDataContainer;

@FeignClient(value = "iemk-client", url = "${app.url}", configuration = ApplicationConfig.class)
public interface IemkClient{
    @RequestMapping(method = RequestMethod.GET, value = "iemk?UserSnils={snils}&UserLastName={lastName}", produces = "application/json")
    UsersDataContainer getContainer(@PathVariable("snils") String snils, @PathVariable("lastName") String lastName);

}
