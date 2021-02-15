package ru.hostco.archivarius.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ru.hostco.archivarius.models.User;

@Repository
public interface UsersRepos extends CrudRepository<User, Long> {
}
