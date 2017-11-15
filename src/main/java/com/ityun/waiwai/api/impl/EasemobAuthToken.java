package com.ityun.waiwai.api.impl;


import com.ityun.waiwai.api.AuthTokenAPI;
import com.ityun.waiwai.comm.TokenUtil;

public class EasemobAuthToken implements AuthTokenAPI {

	@Override
	public Object getAuthToken(){
		return TokenUtil.getAccessToken();
	}
}
