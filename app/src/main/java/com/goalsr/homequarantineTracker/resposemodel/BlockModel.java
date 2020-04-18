package com.goalsr.homequarantineTracker.resposemodel;


import com.google.gson.annotations.SerializedName;

public class BlockModel{

	@SerializedName("block_name")
	private String blockName;

	@SerializedName("block_name_kannada")
	private String blockNameKannada;

	@SerializedName("district_code")
	private String districtCode;

	@SerializedName("block_code")
	private String blockCode;

	public void setBlockName(String blockName){
		this.blockName = blockName;
	}

	public String getBlockName(){
		return blockName;
	}

	public void setBlockNameKannada(String blockNameKannada){
		this.blockNameKannada = blockNameKannada;
	}

	public String getBlockNameKannada(){
		return blockNameKannada;
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

	@Override
 	public String toString(){
		return 
			"BlockModel{" + 
			"block_name = '" + blockName + '\'' + 
			",block_name_kannada = '" + blockNameKannada + '\'' + 
			",district_code = '" + districtCode + '\'' + 
			",block_code = '" + blockCode + '\'' + 
			"}";
		}
}