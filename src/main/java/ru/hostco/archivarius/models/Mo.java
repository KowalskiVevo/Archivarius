package ru.hostco.archivarius.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@Data
@Entity
@Table(name = "ref_mo", schema = "archivist")
@EqualsAndHashCode(of = "guid")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
public class Mo {
    @Column(name = "oid")
    private String oid;
    @Column(name = "version")
    private String version;
    @Column(name = "namefull")
    private String namefull;
    @Column(name = "nameshort")
    private String nameshort;
    @Id
    @NonNull
    @Column(name = "guid",nullable = false)
    private BigDecimal guid;
    @Column(name = "is_shown")
    private Boolean is_shown;
}
