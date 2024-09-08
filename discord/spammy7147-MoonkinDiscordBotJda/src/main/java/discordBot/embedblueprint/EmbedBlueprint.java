package discordBot.embedblueprint;

import java.awt.Color;

public class EmbedBlueprint {

	private String title;
	private String description;
	private String user;
	private Color color;
	
	 
	public EmbedBlueprint() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Color getColor() {
		return color;
	}


	public void setColor(Color color) {
		this.color = color;
	}


	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	
	
}
