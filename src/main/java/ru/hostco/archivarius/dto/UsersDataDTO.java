package ru.hostco.archivarius.dto;

import java.math.BigDecimal;

import lombok.*;

@Data
@AllArgsConstructor
public class UsersDataDTO {
    private BigDecimal userId;
    private String cardnumber;
    private String lastname;
    private String firstname;
    private String middlename;
    private String codemo;
    private String enp;
    private String snils;
    private String birthday;
}
