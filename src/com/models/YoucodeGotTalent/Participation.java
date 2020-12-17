package com.models.YoucodeGotTalent;
import java.sql.Timestamp;

public class Participation {
	private long idUser;
	private long idCategory;
	private String description;
	private Timestamp ShowStartTime;
	private Timestamp ShowEndTime;
	private String attached_file;
	private Boolean is_accepted;

	

	

	
	public Participation(long idUser, long idCategory, String description, Timestamp showStartTime,
			Timestamp showEndTime, String attached_file, Boolean is_accepted) {
		super();
		this.idUser = idUser;
		this.idCategory = idCategory;
		this.description = description;
		ShowStartTime = showStartTime;
		ShowEndTime = showEndTime;
		this.attached_file = attached_file;
		this.is_accepted = is_accepted;
	}




	//getters and setters 
	public long getIdUser() {
		return idUser;
	}

	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}

	public long getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(long idCategory) {
		this.idCategory = idCategory;
	}

	public Timestamp getShowStartTime() {
		return ShowStartTime;
	}

	public void setShowStartTime(Timestamp showStartTime) {
		ShowStartTime = showStartTime;
	}

	public Timestamp getShowEndTime() {
		return ShowEndTime;
	}
	public void setShowEndTime(Timestamp showEndTime) {
		ShowEndTime = showEndTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAttached_file() {
		return attached_file;
	}

	public void setAttached_file(String attached_file) {
		this.attached_file = attached_file;
	}

	public Boolean getIs_accepted() {
		return is_accepted;
	}

	public void setIs_accepted(Boolean is_accepted) {
		this.is_accepted = is_accepted;
	}

	@Override
	public String toString() {
		return "Participation [idUser=" + idUser + ", idCategory=" + idCategory + ", description=" + description
				+ ", ShowStartTime=" + ShowStartTime + ", ShowEndTime=" + ShowEndTime + ", attached_file="
				+ attached_file + ", is_accepted=" + is_accepted + "]";
	}

	
	
}
