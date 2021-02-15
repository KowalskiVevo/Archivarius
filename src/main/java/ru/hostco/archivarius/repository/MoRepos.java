package ru.hostco.archivarius.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.hostco.archivarius.models.Mo;

@Repository
public interface MoRepos extends JpaRepository<Mo, BigDecimal> {
}
