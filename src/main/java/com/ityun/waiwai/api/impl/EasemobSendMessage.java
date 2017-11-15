package com.ityun.waiwai.api.impl;

import com.ityun.waiwai.api.SendMessageAPI;
import com.ityun.waiwai.comm.EasemobAPI;
import com.ityun.waiwai.comm.OrgInfo;
import com.ityun.waiwai.comm.ResponseHandler;
import com.ityun.waiwai.comm.TokenUtil;
import io.swagger.client.ApiException;
import io.swagger.client.api.MessagesApi;
import io.swagger.client.model.Msg;

public class EasemobSendMessage implements SendMessageAPI {
    private ResponseHandler responseHandler = new ResponseHandler();
    private MessagesApi api = new MessagesApi();
    @Override
    public Object sendMessage(final Object payload) {
        return responseHandler.handle(new EasemobAPI() {
            @Override
            public Object invokeEasemobAPI() throws ApiException {
                return api.orgNameAppNameMessagesPost(OrgInfo.ORG_NAME,OrgInfo.APP_NAME, TokenUtil.getAccessToken(), (Msg) payload);
            }
        });
    }
}
