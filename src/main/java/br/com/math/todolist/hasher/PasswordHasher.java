package br.com.math.todolist.hasher;

public interface PasswordHasher {
  String encode(String password);

  Boolean matches(String password, String hash);
}
