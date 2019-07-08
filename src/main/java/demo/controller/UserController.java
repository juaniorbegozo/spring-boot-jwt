package demo.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.dto.UserDataDTO;
import demo.dto.UserResponseDTO;
import demo.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserService userService;

  @Autowired
  private ModelMapper modelMapper;

  @PostMapping("/signin")
  public String login(@RequestBody UserDataDTO user) {
    return userService.signin(user.getUsername(), user.getPassword());
  }

  @GetMapping("/list")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public List<UserResponseDTO> search() {
    return modelMapper.map(userService.search(), List.class);
  }
  
  @GetMapping("/greeting")
  public String info() {
    return "Hello!";
  }

    

}
