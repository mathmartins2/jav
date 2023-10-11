package br.com.math.todolist.user;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.math.todolist.hasher.BcryptPasswordHasher;
import br.com.math.todolist.user.dto.UserRecordDto;
import br.com.math.todolist.user.exception.UserAlreadyExistsException;
import br.com.math.todolist.user.model.UserModel;
import br.com.math.todolist.user.repository.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UserService {

  private static final Logger logger = LoggerFactory.getLogger(UserService.class);

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private BcryptPasswordHasher bcryptPasswordHasher;

  public UserModel create(UserRecordDto userModel) {
    var prevUser = userRepository.findByUsername(userModel.username());
    logger.info("prevUser: {}", prevUser);
    if (prevUser != null)
      throw new UserAlreadyExistsException();
    var user = new UserModel();
    BeanUtils.copyProperties(userModel, user);
    logger.info("user: {}", user);
    var hashedPassword = bcryptPasswordHasher.encode(userModel.password());
    user.setPassword(hashedPassword);
    return userRepository.save(user);
  }
}
