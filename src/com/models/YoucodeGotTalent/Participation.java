package com.models.YoucodeGotTalent;
import java.security.Timestamp;

public class Participation {
	private long idUser;
	private long idCategory;
	private Timestamp ShowStartTime;
	private Timestamp ShowEndTime;

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

	@Override
	public String toString() {
		return "Participation [idUser=" + idUser + ", idCategory=" + idCategory + ", ShowStartTime=" + ShowStartTime
				+ ", ShowEndTime=" + ShowEndTime + "]";
	}
	
}
