package br.com.math.todolist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.math.todolist.user.dto.UserRecordDto;
import br.com.math.todolist.user.model.UserModel;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping("/create")
  public ResponseEntity<UserModel> create(@RequestBody @Valid UserRecordDto userModel) {
    return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(userModel));
  }
}
