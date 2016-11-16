package zmj.wx.qy.bean;

public class ReqMessage {
	public ReqMessage(String touser, String toparty, String msgtype, int agentid, Text text) {
		super();
		this.touser = touser;
		this.toparty = toparty;
		this.msgtype = msgtype;
		this.agentid = agentid;
		this.text = text;
	}
	private String touser;
	private String toparty;
	private String msgtype;
	private int agentid;
	private Text text;
	
	
	public String getTouser() {
		return touser;
	}
	public void setTouser(String touser) {
		this.touser = touser;
	}
	public String getToparty() {
		return toparty;
	}
	public void setToparty(String toparty) {
		this.toparty = toparty;
	}
	public String getMsgtype() {
		return msgtype;
	}
	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}
	public int getAgentid() {
		return agentid;
	}
	public void setAgentid(int agentid) {
		this.agentid = agentid;
	}
	public Text getText() {
		return text;
	}
	public void setText(Text text) {
		this.text = text;
	}

}
