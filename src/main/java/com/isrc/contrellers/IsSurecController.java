package com.isrc.contrellers;


import com.isrc.models.Response;
import com.isrc.models.UserCeck;
import com.isrc.models.UserVO;
import com.isrc.services.IsSurecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class IsSurecController {


	IsSurecService isSurecService;

	@Autowired
	public IsSurecController(IsSurecService isSurecService) {
		this.isSurecService = isSurecService;
	}

	@PostMapping(value="/InsertUser", produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> InsertUser(@RequestBody UserVO user){
		return new ResponseEntity<Response>(isSurecService.insertUser(user), HttpStatus.OK);
	}
	
	@PostMapping(value="/LoginCheck", produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> LoginCheck(@RequestBody UserCeck loginuser){
		return new ResponseEntity<Response>(isSurecService.LoginCheck(loginuser), HttpStatus.OK);
	}

	@PostMapping(value="/SelectUser", produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserVO> SelectUser(@RequestParam String UserName){
		return new ResponseEntity<UserVO>(isSurecService.SelectUser(UserName), HttpStatus.OK);
	}


}
