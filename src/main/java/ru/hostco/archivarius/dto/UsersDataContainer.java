package ru.hostco.archivarius.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersDataContainer{
    private List<UsersDataDTO> usersContainer = new ArrayList<>();
}