package com.emproto.pojo.pojo.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ScreenResponse{

	@SerializedName("data")
	private List<DataItem> data;

	public List<DataItem> getData(){
		return data;
	}
}