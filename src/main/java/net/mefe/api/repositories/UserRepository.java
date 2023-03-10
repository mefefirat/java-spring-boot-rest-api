package net.mefe.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.mefe.api.model.User;
import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}