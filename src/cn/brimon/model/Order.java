package cn.brimon.model;

public class Order {
	private Integer orderId;
	private String orderName;
	private double cost;
	private String comments;
	private User createUser;
	private String destination;
	private String outset;

	public int getOrderId() {
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

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
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
