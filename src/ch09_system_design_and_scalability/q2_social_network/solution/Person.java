package ch09_system_design_and_scalability.q2_social_network.solution;

import java.util.ArrayList;

public class Person {
	private ArrayList<Integer> friends = new ArrayList<Integer>();
	private int personID;
	private String info;
	
	public Person(int id) {
		personID = id;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public ArrayList<Integer> getFriends() {
		return friends;
	}

	public int getID() {
		return personID;
	}
	
	public void addFriend(int id) {
		this.friends.add(id);
	}
	
}
