package com.goalsr.homequarantineTracker.resposemodel;


import com.google.gson.annotations.SerializedName;

public class ResStaticMasterDistric{

	@SerializedName("new_town_code")
	private String newTownCode;

	@SerializedName("ksrsac_town_code")
	private String ksrsacTownCode;

	@SerializedName("town_name")
	private String townName;

	@SerializedName("dist_name")
	private String distName;

	@SerializedName("ksrac_word_code")
	private String ksracWordCode;

	@SerializedName("ksrsac_dist_code")
	private String ksrsacDistCode;

	@SerializedName("new_word_code")
	private String newWordCode;

	@SerializedName("rdrp_dist_code")
	private String rdrpDistCode;

	@SerializedName("word_name")
	private String wordName;

	public void setNewTownCode(String newTownCode){
		this.newTownCode = newTownCode;
	}

	public String getNewTownCode(){
		return newTownCode;
	}

	public void setKsrsacTownCode(String ksrsacTownCode){
		this.ksrsacTownCode = ksrsacTownCode;
	}

	public String getKsrsacTownCode(){
		return ksrsacTownCode;
	}

	public void setTownName(String townName){
		this.townName = townName;
	}

	public String getTownName(){
		return townName;
	}

	public void setDistName(String distName){
		this.distName = distName;
	}

	public String getDistName(){
		return distName;
	}

	public void setKsracWordCode(String ksracWordCode){
		this.ksracWordCode = ksracWordCode;
	}

	public String getKsracWordCode(){
		return ksracWordCode;
	}

	public void setKsrsacDistCode(String ksrsacDistCode){
		this.ksrsacDistCode = ksrsacDistCode;
	}

	public String getKsrsacDistCode(){
		return ksrsacDistCode;
	}

	public void setNewWordCode(String newWordCode){
		this.newWordCode = newWordCode;
	}

	public String getNewWordCode(){
		return newWordCode;
	}

	public void setRdrpDistCode(String rdrpDistCode){
		this.rdrpDistCode = rdrpDistCode;
	}

	public String getRdrpDistCode(){
		return rdrpDistCode;
	}

	public void setWordName(String wordName){
		this.wordName = wordName;
	}

	public String getWordName(){
		return wordName;
	}

	@Override
 	public String toString(){
		return 
			"ResStaticMasterDistric{" + 
			"new_town_code = '" + newTownCode + '\'' + 
			",ksrsac_town_code = '" + ksrsacTownCode + '\'' + 
			",town_name = '" + townName + '\'' + 
			",dist_name = '" + distName + '\'' + 
			",ksrac_word_code = '" + ksracWordCode + '\'' + 
			",ksrsac_dist_code = '" + ksrsacDistCode + '\'' + 
			",new_word_code = '" + newWordCode + '\'' + 
			",rdrp_dist_code = '" + rdrpDistCode + '\'' + 
			",word_name = '" + wordName + '\'' + 
			"}";
		}
}