package InventoryManager.model;

public final class Session {

	private User user;
	private String role;
	
	public Session() {
		role = "Admin";
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String getUsername() {
		return user.getUsername();
	}
	
	public String getRole() {
		return role;
	}
}
