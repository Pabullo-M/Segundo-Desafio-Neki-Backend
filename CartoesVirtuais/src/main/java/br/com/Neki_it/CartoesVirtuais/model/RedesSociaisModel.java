package br.com.Neki_it.CartoesVirtuais.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class RedesSociaisModel {
	
	private String linkedin;
	private String github;
	private String instagram;
	private String facebook;
	
	
	
	public RedesSociaisModel() {
		super();
	}
	public RedesSociaisModel(String linkedin, String github, String instagram, String facebook) {
		super();
		this.linkedin = linkedin;
		this.github = github;
		this.instagram = instagram;
		this.facebook = facebook;
	}
	public String getLinkedin() {
		return linkedin;
	}
	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}
	public String getGithub() {
		return github;
	}
	public void setGithub(String github) {
		this.github = github;
	}
	public String getInstagram() {
		return instagram;
	}
	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}
	public String getFacebook() {
		return facebook;
	}
	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}
	
	
}
