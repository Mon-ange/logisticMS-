package cn.brimon.model;

public class Law {
	private Integer lawId;
	private String content;
	private User createUser;
	private String title;
	public Integer getLawId() {
		return lawId;
	}
	public void setLawId(Integer lawId) {
		this.lawId = lawId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public User getCreateUser() {
		return createUser;
	}
	public void setCreateUser(User createUser) {
		this.createUser = createUser;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
