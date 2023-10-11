package br.com.math.todolist.hasher;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import at.favre.lib.crypto.bcrypt.BCrypt;

@Component
public class BcryptPasswordHasher implements PasswordHasher {

  @Value("${spring.bcrypt.cost}")
  private int bcryptCost;

  @Override
  public String encode(String password) {
    return BCrypt.withDefaults().hashToString(bcryptCost, password.toCharArray());
  }

  @Override
  public Boolean matches(String password, String hash) {
    return BCrypt.verifyer().verify(password.toCharArray(), hash).verified;
  }

}
