package com.isrc.dao;


import com.isrc.models.Response;
import com.isrc.models.UserVO;
import com.isrc.repositories.UserRepo;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDao {

  private UserRepo userrepo;
  private Map<String, UserVO> usermap;

  @Autowired
  public UserDao(UserRepo userrepo, Map<String, UserVO> usermap) {
    this.userrepo = userrepo;
    this.usermap = usermap;
  }

  public Response insertUser(UserVO user)
  {
	Response res = new Response();
    UserVO uservo;
    try {
    	  if (userrepo.findByUsername(user.getUsername())==null)
    	  { 
    		  uservo = userrepo.save(user);
    		  if (uservo!=null)
            	  res = Response.builder().code(201).message("işlem başarılı.").build();
              else
            	  res = Response.builder().code(-1).message("işlem başarısız.").build();
    	  }
    	  else res = Response.builder().code(-2).message("Kullanıcı Adı Sistemde Kayıtlı.").build();
        
    }catch (Exception e)
    {
    	res = Response.builder().code(-3).message("işlem başarısız.").build();
    }
    return res;
  }
  
  public Response LoginCheck(String username, String password)
  {
	Response res = new Response();
    try {
    	  if (userrepo.checklogin(username,password) == 0)   
            	  res = Response.builder().code(-1).message("Kullanıcı adi veya şifre hatalı.").build();
    	  else res = Response.builder().code(201).message("İşlem Başarılı.").build();
        
    }catch (Exception e)
    {
    	res = Response.builder().code(-3).message("işlem başarısız.").build();
    }
    return res;
  }


  public UserVO SelectUser(String username)
  {
    UserVO user = new UserVO();
    try {
          if(usermap.get(username) == null) {
            user = userrepo.findByUsername(username);
            usermap.put(user.getUsername(),user);
          }
          else user = usermap.get(username);


    }catch (Exception ex)
    {
      System.out.println("User select error."+ex.toString());
    }
    return user;
  }

}
