package com.app.post.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.app.dao.PostDAO;
import com.app.post.Action;
import com.app.post.Result;

public class PostJstlController implements Action {

	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		Result result = new Result();
		
		String name = req.getParameter("name");
		PostDAO postDAO = new PostDAO();
		req.setAttribute("posts", postDAO.selectAll());
		
		
		// String을 JSON형식으로 변경
		JSONArray datas = new JSONArray();
		postDAO.selectAll().stream().map(JSONObject::new).forEach((json) -> datas.put(json));
		req.setAttribute("datas", datas);
		
//		req.setAttribute("name", name);
//		List<String> datas = new ArrayList<String>(Arrays.asList("<script>alert('이제 이 컴퓨터는 제껍니다😎😎')</script>","B" ,"C"));
//		req.setAttribute("datas", datas);
		
		result.setPath("jstl.jsp");
		return result;
	}

}
