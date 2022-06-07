package com.isrc.services;

import com.isrc.dao.UserDao;
import com.isrc.models.Response;
import com.isrc.models.UserCeck;
import com.isrc.models.UserVO;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IsSurecService {


  
private UserDao userdao;



@Autowired  
public IsSurecService(UserDao userdao) {
    this.userdao = userdao;
}


  public Response insertUser(UserVO uservo)
  { 
      return userdao.insertUser(uservo); 
  }
  
  public Response LoginCheck(UserCeck loginuser)
  { 
      return userdao.LoginCheck(loginuser.getUsername(), loginuser.getPassword()); 
  }

  public UserVO SelectUser(String UserName)
  {
      return userdao.SelectUser(UserName);
  }





}
