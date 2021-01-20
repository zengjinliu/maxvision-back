package com.maxvision.zfba.conf.loaders;

import com.maxvision.core.server.conf.loaders.FileWatchdog;
import com.maxvision.zfba.conf.SysConfig;

public class SysConfigWatchdog extends FileWatchdog {
	public SysConfigWatchdog(String confPath) {
		super(confPath);
	}

	@Override
	protected String getFilename() {
		return "sys.json";
	}

	@Override
	protected boolean load() {
		SysConfig.config.load(super.file);
		return true;
	}
}
