package com.isrc.contrellers;


import com.isrc.exceptions.Exceptions;
import com.isrc.models.Response;
import com.isrc.models.UserCeck;
import com.isrc.models.UserVO;
import com.isrc.services.IsSurecService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Api(value = "Demo Processes Api documentation")
public class IsSurecController {


	IsSurecService isSurecService;

	@Autowired
	public IsSurecController(IsSurecService isSurecService) {
		this.isSurecService = isSurecService;
	}

	@ApiOperation(value = "Insert new user method")
	@PostMapping(value="/InsertUser", produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> InsertUser(@RequestBody UserVO user){
		return new ResponseEntity<>(isSurecService.insertUser(user), HttpStatus.OK);
	}

	@ApiOperation(value = "Login authentication control")
	@PostMapping(value="/LoginCheck", produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> LoginCheck(@RequestBody UserCeck loginuser){
		return new ResponseEntity<>(isSurecService.LoginCheck(loginuser), HttpStatus.OK);
	}


	@ApiOperation(value = "it use that search a user")
	@PostMapping(value="/SelectUser", produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserVO> SelectUser(@RequestParam String UserName){
		return new ResponseEntity<>(isSurecService.SelectUser(UserName), HttpStatus.OK);
	}

	/*@ExceptionHandler(Exceptions.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<String> handleUserNotFoundException(Exceptions exception)
	{
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(exception.getMessage());
	}*/


}
