package com.maxvision.zfba.view;

import com.maxvision.core.cache.Cacher;
import com.maxvision.core.client.utils.FileUtils;
import com.maxvision.core.server.pub.AppEnvironment;
import com.maxvision.core.web.View;
import com.maxvision.core.web.view.ImageDataView;
import com.maxvision.core.web.view.ImageView;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.util.SafeEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RedisImageView implements View {
	private final byte[] key;

	public RedisImageView(String key) {
		this.key = SafeEncoder.encode(key);
	}

	@Override
	public boolean hasFlashAttribute() {
		return false;
	}

	@Override
	public void render(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		byte[] buffer;
		final Jedis jedis = Cacher.getJedis();
		try {
			buffer = jedis.get(this.key);
		} finally {
			jedis.close();
		}
		if (buffer == null || buffer.length < 1) {
			String path = FileUtils.combinePath(AppEnvironment.getAppPath(),"ui/img/NoPicture.png");
			new ImageView(path).render(request, response);
			return;
		}
		new ImageDataView(buffer, "image/jpeg").render(request, response); 
	}

}
