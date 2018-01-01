package cn.brimon.model;

public class Order {
	private Integer orderId;
	private String orderName;
	private Double cost;
	private String comments;
	private User createUser;
	private String destination;
	private String outset;
	private String contact;
	private String receiver;
	private String stat;
	public Order(){
		orderName = new String();
		cost = new Double(0);
		comments = new String();
		createUser = new Admin();
		destination = new String();
		outset = new String();
		contact = new String();
		receiver = new String();
	}
	
	public String getStat() {
		return stat;
	}

	public void setStat(String stat) {
		this.stat = stat;
	}

	public String getContact() {
		return contact;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public User getCreateUser() {
		return createUser;
	}

	public void setCreateUser(User createUser) {
		this.createUser = createUser;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getOutset() {
		return outset;
	}

	public void setOutset(String outset) {
		this.outset = outset;
	}

	@Override
	public String toString() {
		return "orderId : " + orderId.toString() + "\norderName : " + orderName + "\ndestination : " + destination;
	}

}
