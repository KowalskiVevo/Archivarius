package ru.hostco.archivarius.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@Data
@Entity
@Table(name = "usersdata", schema = "archivist")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
public class User {
    @Id
    @Setter(AccessLevel.PROTECTED)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    @Column(name = "id",nullable = false)
    private int id;
    @Column(name = "userid",nullable = false)
    private BigDecimal userId;
    @Column(name = "cardnumber")
    private String cardnumber;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "middlename")
    private String middlename;
    @Column(name = "codemo")
    private String codemo;
    @Column(name = "enp")
    private String enp;
    @Column(name = "snils")
    private String snils;
    @Column(name = "birthday")
    private LocalDate birthday;
    @Column(name = "description")
    private String description;
    @Column(name = "date_insert")
    private OffsetDateTime date_insert;
    @Column(name = "date_update")
    private OffsetDateTime date_update;
}
