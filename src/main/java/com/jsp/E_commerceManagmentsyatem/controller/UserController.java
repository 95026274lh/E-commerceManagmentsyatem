package com.jsp.E_commerceManagmentsyatem.controller;

import com.jsp.E_commerceManagmentsyatem.dto.UserRequestDto;
import com.jsp.E_commerceManagmentsyatem.dto.UserResponseDto;
import com.jsp.E_commerceManagmentsyatem.entity.UserEntity;
import com.jsp.E_commerceManagmentsyatem.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserResponseDto Saveuser(@Valid @RequestBody UserRequestDto userRequestDto){
        return userService.Saveuser(userRequestDto);
    }
    @GetMapping
    public List<UserEntity> Fetchallusers(){
        return userService.Fetchallusers();
    }
    @PutMapping("/{id}")
    public UserResponseDto Updateuser(@PathVariable Long id,@Valid @RequestBody UserRequestDto userRequestDto){
        log.info(" from user controller");
        return userService.Updateuser(id,userRequestDto);
    }
    @PatchMapping("/{email}")
    public UserResponseDto partialUpdate(@PathVariable String email,@Valid @RequestBody UserRequestDto userRequestDto){
        return userService.partialUpdate(email, userRequestDto);
    }
    @DeleteMapping("/{id}")
    public String Delete(@PathVariable Long id){
       userService.Delete(id);
       return " deleted user sucessfully";

    }
    @DeleteMapping
    public  String Deleteall(){
        return userService.Deleteall();
    }

}
