package org.liufeng.course.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.liufeng.course.message.resp.Article;
import org.liufeng.course.message.resp.NewsMessage;
import org.liufeng.course.message.resp.TextMessage;
import org.liufeng.course.util.MessageUtil;

/**
 * 核心服务类
 * 
 * @author liufeng
 * @date 2013-05-20
 */
public class CoreService {

	/**
	 * xiaoqrobot的主菜单
	 * 
	 * @return
	 */
	public static String getMainMenu() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("您好，我是小q，请回复数字选择服务：").append("\n\n");
		buffer.append("<a href=\"http://2.zhaomj.sinaapp.com/\">1  天气预报</a>").append("\n");
		buffer.append("2  公交查询").append("\n");
		buffer.append("3  周边搜索").append("\n");
		buffer.append("4  歌曲点播").append("\n");
		buffer.append("5  经典游戏").append("\n");
		buffer.append("6  美女电台").append("\n");
		buffer.append("7  人脸识别").append("\n");
		buffer.append("8  聊天唠嗑").append("\n\n");
		buffer.append("回复“?”显示此帮助菜单");
		return buffer.toString();
	}

	/**
	 * 处理微信发来的请求
	 * 
	 * @param request
	 * @return
	 */
	public static String processRequest(HttpServletRequest request) {
		String respMessage = null;
		try {
			// 默认返回的文本消息内容
			String respContent = "请求处理异常，请稍候尝试！";

			// xml请求解析
			Map<String, String> requestMap = MessageUtil.parseXml(request);

			// 发送方帐号（open_id）
			String fromUserName = requestMap.get("FromUserName");
			// 公众帐号
			String toUserName = requestMap.get("ToUserName");
			// 消息类型
			String msgType = requestMap.get("MsgType");

			// 回复文本消息
			TextMessage textMessage = new TextMessage();
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName);
			textMessage.setCreateTime(new Date().getTime());
			textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
			textMessage.setFuncFlag(0);

			// 文本消息
			if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
				 respContent = "您发送的是文本消息！我们还在加班加点不断努力完善。";
				//respContent = CoreService.getMainMenu();
//				System.out.println(respContent);
				if (requestMap.get("Content").equals("136786874")) {
					// 创建图文消息
					NewsMessage newsMessage = new NewsMessage();
					newsMessage.setToUserName(fromUserName);
					newsMessage.setFromUserName(toUserName);
					newsMessage.setCreateTime(new Date().getTime());
					newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
					newsMessage.setFuncFlag(0);
					List<Article> articleList = new ArrayList<Article>();
					Article article = new Article();
					article.setTitle("微信公众帐号开发教程Java版");
					article.setDescription("柳峰，80后，微信公众帐号开发经验4个月。为帮助初学者入门，特推出此系列教程，也希望借此机会认识更多同行！");
					article.setPicUrl("http://0.xiaoqrobot.duapp.com/images/avatar_liufeng.jpg");
					article.setUrl("http://blog.csdn.net/lyq8479");
					articleList.add(article);
					// 设置图文消息个数
					newsMessage.setArticleCount(articleList.size());
					// 设置图文消息包含的图文集合
					newsMessage.setArticles(articleList);
					// 将图文消息对象转换成xml字符串
					respMessage = MessageUtil.newsMessageToXml(newsMessage);
					return respMessage;
				}
			}
			// 图片消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
				respContent = "您发送的是图片消息！我们还在加班加点不断努力完善。";
			}
			// 地理位置消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
				respContent = "您发送的是地理位置消息！我们还在加班加点不断努力完善。";
			}
			// 链接消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
				respContent = "您发送的是链接消息！我们还在加班加点不断努力完善。";
			}
			// 音频消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
				respContent = "您发送的是音频消息！我们还在加班加点不断努力完善。";
			}
			// 事件推送
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
				// 事件类型
				String eventType = requestMap.get("Event");
				// 订阅
				if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
					respContent = "谢谢您的关注！我们还在加班加点不断努力完善。";
				}
				// 取消订阅
				else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
					// TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
				}
				// 自定义菜单点击事件
				else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
					// TODO 自定义菜单权没有开放，暂不处理该类消息
					// 事件KEY值，与创建自定义菜单时指定的KEY值对应
					String eventKey = requestMap.get("EventKey");

					if (eventKey.equals("11")) {
						respContent = "天气预报菜单项被点击！我们还在加班加点不断努力完善。";
					} else if (eventKey.equals("12")) {
						respContent = "公交查询菜单项被点击！我们还在加班加点不断努力完善。";
					} else if (eventKey.equals("13")) {
						respContent = "周边搜索菜单项被点击！我们还在加班加点不断努力完善。";
					} else if (eventKey.equals("14")) {
						respContent = "历史上的今天菜单项被点击！我们还在加班加点不断努力完善。";
					} else if (eventKey.equals("21")) {
						respContent = "歌曲点播菜单项被点击！我们还在加班加点不断努力完善。";
					} else if (eventKey.equals("22")) {
						respContent = "经典游戏菜单项被点击！我们还在加班加点不断努力完善。";
					} else if (eventKey.equals("23")) {
						respContent = "美女电台菜单项被点击！我们还在加班加点不断努力完善。";
					} else if (eventKey.equals("24")) {
						respContent = "人脸识别菜单项被点击！我们还在加班加点不断努力完善。";
					} else if (eventKey.equals("25")) {
						respContent = "聊天唠嗑菜单项被点击！我们还在加班加点不断努力完善。";
					} else if (eventKey.equals("31")) {
						respContent = "Q友圈菜单项被点击！我们还在加班加点不断努力完善。";
					} else if (eventKey.equals("32")) {
						respContent = "电影排行榜菜单项被点击！我们还在加班加点不断努力完善。";
					} else if (eventKey.equals("33")) {
						respContent = "幽默笑话菜单项被点击！我们还在加班加点不断努力完善。";
					}
				}
			}

			textMessage.setContent(respContent);
			respMessage = MessageUtil.textMessageToXml(textMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return respMessage;
	}
}
