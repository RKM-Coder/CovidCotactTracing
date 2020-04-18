package com.goalsr.homequarantineTracker.resposemodel;


import com.google.gson.annotations.SerializedName;


public class PanchyateModel{

	@SerializedName("panchayat_code")
	private String panchayatCode;

	@SerializedName("district_code")
	private String districtCode;

	@SerializedName("block_code")
	private String blockCode;

	@SerializedName("panchayat_name_kannada")
	private String panchayatNameKannada;

	@SerializedName("panchayat_name")
	private String panchayatName;

	public void setPanchayatCode(String panchayatCode){
		this.panchayatCode = panchayatCode;
	}

	public String getPanchayatCode(){
		return panchayatCode;
	}

	public void setDistrictCode(String districtCode){
		this.districtCode = districtCode;
	}

	public String getDistrictCode(){
		return districtCode;
	}

	public void setBlockCode(String blockCode){
		this.blockCode = blockCode;
	}

	public String getBlockCode(){
		return blockCode;
	}

	public void setPanchayatNameKannada(String panchayatNameKannada){
		this.panchayatNameKannada = panchayatNameKannada;
	}

	public String getPanchayatNameKannada(){
		return panchayatNameKannada;
	}

	public void setPanchayatName(String panchayatName){
		this.panchayatName = panchayatName;
	}

	public String getPanchayatName(){
		return panchayatName;
	}

	@Override
 	public String toString(){
		return 
			"PanchyateModel{" + 
			"panchayat_code = '" + panchayatCode + '\'' + 
			",district_code = '" + districtCode + '\'' + 
			",block_code = '" + blockCode + '\'' + 
			",panchayat_name_kannada = '" + panchayatNameKannada + '\'' + 
			",panchayat_name = '" + panchayatName + '\'' + 
			"}";
		}
}