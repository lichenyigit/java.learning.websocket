package cn.lichenyi.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint(("/ws/{uid}"))
public class WebsocketConfig {
    public static final Logger log = LoggerFactory.getLogger(WebsocketConfig.class);
    @OnOpen
    public void onOpen(Session session, @PathParam("uid") String uid) throws IOException {
        log.info(uid + " 链接成功");
        log.error(uid + " 链接成功error");
        //连接成功
        session.getBasicRemote().sendText("你好，欢迎【" + uid + "】链接websocket");
    }

    @OnClose
    public void onClose() {
        log.info("链接关闭");
        System.out.println(this + "链接关闭");
    }

    @OnMessage
    public void onMessage(String message, Session session, @PathParam("uid") String uid) throws IOException {
        session.getBasicRemote().sendText(uid + " 发送的消息：" + message);
        log.info(uid + " 发送的消息：" + message);
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        System.out.println("发生错误");
        log.error("发生错误");
        throwable.printStackTrace();
    }
}
