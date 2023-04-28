package jp.co.seattle.library.controller;

import java.util.Locale;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.seattle.library.dto.UserInfo;
import jp.co.seattle.library.service.UsersService;

@Controller 
public class PasswordResetController {
	@Autowired
	private UsersService usersService;
	
	@RequestMapping(value = "/resetAccount", method = RequestMethod.GET) // value＝actionで指定したパラメータ
	public String reaetAccount(Model model) {
		return "passwordReset";
	}
	
	

	//password
	public static boolean validatePassword(String ch, String password) {
		boolean check = false;
		if (password.length() >= 8) {
			Pattern p1 = Pattern.compile(ch); // 正規表現パターンの読み込み
			java.util.regex.Matcher m1 = p1.matcher(password); // パターンと検査対象文字列の照合
			check = m1.matches(); // 照合結果をtrueかfalseで取得
			if (check) {
				return check;
			} else {
				return check;
			}
		} else {
			return check;
		}
	}
	
	@Transactional
	@RequestMapping(value = "/reset", method = RequestMethod.POST)
	public String createAccount(Locale locale, @RequestParam("email") String email,
			@RequestParam("password") String password, @RequestParam("passwordForCheck") String passwordForCheck,
			Model model) {
		// デバッグ用ログ
		
		//start
		
		String regex_AlphaNum = "^[A-Za-z0-9]+$";
		boolean validateResult = validatePassword(regex_AlphaNum, password);
		if (!validateResult) {
			model.addAttribute("errorMessage", "パスワードが８文字以上かつ半角英数字ではありません");
			return "passwordReset";
		}
		if (password.equals(passwordForCheck)) {
			UserInfo userInfo = new UserInfo();
			userInfo.setEmail(email);
			userInfo.setPassword(password);
			usersService.resetUser(userInfo);
			return "redirect:/";
		} else {
			model.addAttribute("errorMessage", "パスワードが一致しません");
			return "passwordReset";
		}
	}

}
