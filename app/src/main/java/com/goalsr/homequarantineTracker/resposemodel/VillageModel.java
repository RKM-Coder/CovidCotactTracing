package com.goalsr.homequarantineTracker.resposemodel;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

@Entity(tableName = "table_village")
public class VillageModel{


	@PrimaryKey
	@NotNull
	@SerializedName("village_code")
	private String villageCode;

	@SerializedName("panchayat_code")
	private String panchayatCode;

	@SerializedName("village_name")
	private String villageName;

	public void setVillageCode(String villageCode){
		this.villageCode = villageCode;
	}

	public String getVillageCode(){
		return villageCode;
	}

	public void setPanchayatCode(String panchayatCode){
		this.panchayatCode = panchayatCode;
	}

	public String getPanchayatCode(){
		return panchayatCode;
	}

	public void setVillageName(String villageName){
		this.villageName = villageName;
	}

	public String getVillageName(){
		return villageName;
	}

	@Override
 	public String toString(){
		return 
			"VillageModel{" + 
			"village_code = '" + villageCode + '\'' + 
			",panchayat_code = '" + panchayatCode + '\'' + 
			",village_name = '" + villageName + '\'' + 
			"}";
		}
}