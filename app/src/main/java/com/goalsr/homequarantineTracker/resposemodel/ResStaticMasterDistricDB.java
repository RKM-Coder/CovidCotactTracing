package com.goalsr.homequarantineTracker.resposemodel;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;
@Entity(tableName = "table_mater_address_urban")
public class ResStaticMasterDistricDB {

	@PrimaryKey(autoGenerate = true)
	private int keyId;

	@SerializedName("new_town_code")
	private String new_town_code;

	@SerializedName("ksrsac_town_code")
	private String ksrsac_town_code;

	@SerializedName("town_name")
	private String town_name;

	@SerializedName("dist_name")
	private String dist_name;

	@SerializedName("ksrac_word_code")
	private String ksrac_word_code;

	@SerializedName("ksrsac_dist_code")
	private String ksrsac_dist_code;

	@SerializedName("new_word_code")
	private String new_word_code;

	@SerializedName("rdrp_dist_code")
	private String rdrp_dist_code;

	@SerializedName("word_name")
	private String word_name;

	public int getKeyId() {
		return keyId;
	}

	public void setKeyId(int keyId) {
		this.keyId = keyId;
	}

	public String getNew_town_code() {
		return new_town_code;
	}

	public void setNew_town_code(String new_town_code) {
		this.new_town_code = new_town_code;
	}

	public String getKsrsac_town_code() {
		return ksrsac_town_code;
	}

	public void setKsrsac_town_code(String ksrsac_town_code) {
		this.ksrsac_town_code = ksrsac_town_code;
	}

	public String getTown_name() {
		return town_name;
	}

	public void setTown_name(String town_name) {
		this.town_name = town_name;
	}

	public String getDist_name() {
		return dist_name;
	}

	public void setDist_name(String dist_name) {
		this.dist_name = dist_name;
	}

	public String getKsrac_word_code() {
		return ksrac_word_code;
	}

	public void setKsrac_word_code(String ksrac_word_code) {
		this.ksrac_word_code = ksrac_word_code;
	}

	public String getKsrsac_dist_code() {
		return ksrsac_dist_code;
	}

	public void setKsrsac_dist_code(String ksrsac_dist_code) {
		this.ksrsac_dist_code = ksrsac_dist_code;
	}

	public String getNew_word_code() {
		return new_word_code;
	}

	public void setNew_word_code(String new_word_code) {
		this.new_word_code = new_word_code;
	}

	public String getRdrp_dist_code() {
		return rdrp_dist_code;
	}

	public void setRdrp_dist_code(String rdrp_dist_code) {
		this.rdrp_dist_code = rdrp_dist_code;
	}

	public String getWord_name() {
		return word_name;
	}

	public void setWord_name(String word_name) {
		this.word_name = word_name;
	}
}