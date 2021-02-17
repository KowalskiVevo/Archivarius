package ru.hostco.archivarius.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.hostco.archivarius.models.User;

@Repository
public interface UsersRepos extends JpaRepository<User, BigDecimal> {
}
