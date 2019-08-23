package hnu.mn.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import hnu.mn.pojo.User;

//控制器
@Controller
public class UserController {
	@RequestMapping("{page}")
	public String main(@PathVariable String page) {
		System.out.println("restful");
		return page;
	}

	@RequestMapping("login")
	public String login(String username, String password, HttpSession session) {
		// 直接访问 80：login
		if (username == null || password == null) {
			return "redirect:/login.jsp";
		}

		if (username.equals("admin") && password.equals("123")) {
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			session.setAttribute("user", user);
			return "main";
		} else {
			return "redirect:/login.jsp";
		}
	}
}