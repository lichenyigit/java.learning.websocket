package cn.lichenyi.websocket;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint(("/ws/{uid}"))
public class WebsocketConfig {
    @OnOpen
    public void onOpen(Session session, @PathParam("uid") String uid) throws IOException {
        //连接成功
        session.getBasicRemote().sendText("你好，欢迎【" + uid + "】链接websocket");
    }

    @OnClose
    public void onClose() {
        System.out.println(this + "链接关闭");
    }

    @OnMessage
    public void onMessage(String message, Session session, @PathParam("uid") String uid) throws IOException {
        session.getBasicRemote().sendText(uid + " 发送的消息：" + message);
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        System.out.println("发生错误");
        throwable.printStackTrace();
    }
}
