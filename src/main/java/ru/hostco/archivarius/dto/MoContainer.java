package ru.hostco.archivarius.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class MoContainer {
    private List<MoDTO> moCont = new ArrayList<>();
    public void add(MoDTO moDTO){
        moCont.add(moDTO);
    }
}
