package hnu.mn.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import hnu.mn.pojo.User;
import hnu.mn.service.UserService;

@Controller
public class UserController {
	@Resource
	private UserService userServiceImpl;

	@RequestMapping("login")
	public String login(User users, HttpSession session) {
		System.out.println("login");
		User user = userServiceImpl.login(users);
		if (user != null) {
			session.setAttribute("user", user);
			return "redirect:/sus.jsp";
		}
		return "redirect:/index.jsp";
	}

}
