package com.web.server.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.server.cnst.AppCode;
import com.web.server.dto.LoginResultDto;
import com.web.server.rest.IRestBase;
import com.web.server.rest.RestResult;
import com.web.server.vo.LoginVo;

@RestController
@RequestMapping("/auth")
public class AuthController implements IRestBase {

	/**
	 * 驗證身分
	 */
	@PostMapping
	public RestResult verifyIdentity(@RequestBody LoginVo loginVo) {
		String mail = "juyu@gmail.com";
		String pxd = "yu60441";
		
		LoginResultDto result = new LoginResultDto();
		if(mail.equals(loginVo.getAcct()) && pxd.equals(loginVo.getPxd())) {
			result.setLogin(true);
			return buildResult(AppCode.VALID.AUTH.LOGIN_SUCCESS.getCode(), result);
		}else {
			result.setLogin(false);
			return buildResult(AppCode.VALID.AUTH.LOGIN_FAIL.getCode(), result);
		}
	}
}
