package com.maxvision.zfba.view;

import com.maxvision.core.client.conf.DefaultValueConf;
import com.maxvision.core.web.View;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

public class MessageView implements View{

	public String msg ;
	
	public MessageView(String msg) {
		this.msg = msg;
	}
	
	@Override
	public boolean hasFlashAttribute() {
		return false;
	}

	@Override
	public void render(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse)
			throws ServletException, IOException {
		paramHttpServletResponse.setCharacterEncoding(DefaultValueConf.charsetName);
		if (!paramHttpServletResponse.containsHeader("Content-Type")) {
			paramHttpServletResponse.setContentType("application/json; charset=" + DefaultValueConf.charsetName);
		}
		OutputStream ou = paramHttpServletResponse.getOutputStream();
		ou.write(msg.getBytes("UTF-8"));
		ou.flush();
		ou.close();
	}

		
}
