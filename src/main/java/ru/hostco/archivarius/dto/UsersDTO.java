package ru.hostco.archivarius.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UsersDTO {
	private Long id;
    private String Firstname;
    private String Lastname;
    private String Middlename;
}
