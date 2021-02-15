package ru.hostco.archivarius.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MoDTO {
    private String oid;
    private String version;
    private String namefull;
    private String nameshort;
    private BigDecimal guid;
    private boolean is_shown;
}
