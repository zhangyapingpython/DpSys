package hnu.mn.service;

import javax.servlet.http.HttpSession;

public interface QueryService {
	Object selSQL(String sql,HttpSession session);
}
