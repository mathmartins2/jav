package br.com.math.todolist.user.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.math.todolist.user.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, UUID> {
  UserModel findByUsername(String username);
}
