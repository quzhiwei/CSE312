package cse312.demo.APIController;


import java.util.*;

import com.fasterxml.jackson.annotation.JsonProperty;
// import com.sun.istack.internal.NotNull;
import cse312.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import cse312.demo.Model.User;


@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/")
public class logRegController {
  public final UserService userService;

  @Autowired
  public logRegController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/registerform")
  //register
  public boolean userRegister(@RequestBody User user) {
    if(userService.checkUser(user.getUserName())) return false;
    userService.insertUser(user);
    return true;
  }

  @PostMapping("/loginform")
  //login
  public boolean userLogin(@RequestBody Map<String, String> loginInfo) {
    if (!userService.validateUser(loginInfo.get("userName"),loginInfo.get("password"))) {
      return false;
    }
    return true;
  }

  @GetMapping("/")
  public List<User> getAllUser() {
    return userService.getAllUser();
  }

}
