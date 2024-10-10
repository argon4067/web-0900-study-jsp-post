package com.app.post.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.app.dao.PostDAO;
import com.app.post.Action;
import com.app.post.Result;
import com.app.vo.PostVO;

public class PostUpdateController implements Action {

	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		Result result = new Result();

		Long id = Long.parseLong(req.getParameter("id"));
		
		PostVO post = new PostDAO().select(id).orElseThrow(() -> {
			throw new RuntimeException();
		});
		// requestScope 안으로 넣음
		req.setAttribute("post", post);
		
		
		result.setPath("update.jsp");
		return result;
	}
}