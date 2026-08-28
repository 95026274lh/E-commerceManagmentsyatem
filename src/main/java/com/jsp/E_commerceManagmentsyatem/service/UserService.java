package com.jsp.E_commerceManagmentsyatem.service;

import com.jsp.E_commerceManagmentsyatem.dto.UserRequestDto;
import com.jsp.E_commerceManagmentsyatem.dto.UserResponseDto;
import com.jsp.E_commerceManagmentsyatem.entity.OrderEntity;
import com.jsp.E_commerceManagmentsyatem.entity.UserEntity;
import com.jsp.E_commerceManagmentsyatem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class UserService {
private  final UserRepository userRepository;

public UserResponseDto Saveuser(UserRequestDto userRequestDto){

    UserEntity userEntity=new UserEntity();
    userEntity.setName(userRequestDto.getName());
    userEntity.setEmail(userRequestDto.getEmail());
    userEntity.setMobile(userRequestDto.getMobile());

    UserEntity userEntity1=userRepository.save(userEntity);

    UserResponseDto userResponseDto=new UserResponseDto();
    userResponseDto.setId(userEntity1.getId());
    userResponseDto.setName(userEntity1.getName());
    userResponseDto.setEmail(userEntity1.getEmail());
    userResponseDto.setMobile(userEntity1.getMobile());

    return userResponseDto;

}
public List<UserEntity> Fetchallusers(){
    return userRepository.findAll();
}
public UserResponseDto Updateuser(Long id,UserRequestDto userRequestDto){
    log.info(" from userservice");
    UserEntity user=userRepository.findById(id).orElseThrow(()-> new RuntimeException("user not found"));
    user.setName(userRequestDto.getName());
    user.setEmail(userRequestDto.getEmail());
    user.setMobile(userRequestDto.getMobile());

    UserEntity updateduser=userRepository.save(user);

    UserResponseDto userResponseDto=new UserResponseDto();
    userResponseDto.setId(updateduser.getId());
    userResponseDto.setName(updateduser.getName());
    userResponseDto.setEmail(updateduser.getEmail());
    userResponseDto.setMobile(updateduser.getMobile());
    return userResponseDto;
}
public UserResponseDto partialUpdate(String email,UserRequestDto userRequestDto){
    UserEntity user=userRepository.findByemail(email).orElseThrow(()-> new RuntimeException("user not found"));
    if(userRequestDto.getName()!=null)
        user.setName(userRequestDto.getName());

    if(userRequestDto.getMobile()!=null)
        user.setMobile(userRequestDto.getMobile());
    UserEntity updatepartial=userRepository.save(user);

    UserResponseDto userResponseDto=new UserResponseDto();
    userResponseDto.setId(updatepartial.getId());
    userResponseDto.setName(updatepartial.getName());
    userResponseDto.setEmail(updatepartial.getEmail());
    userResponseDto.setMobile(updatepartial.getMobile());
    return  userResponseDto;
}
public void Delete(Long id){
    UserEntity user=userRepository.findById(id).orElseThrow(()-> new RuntimeException("user not found"));
    userRepository.delete(user);
}
public  String Deleteall(){
    userRepository.deleteAll();
    return "delete all users sucessfully";
}

}
