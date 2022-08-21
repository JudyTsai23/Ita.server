package com.web.server.enumcnst;

public enum NewsType {

	ACTIVITY("活動", 0),
	ANNOUNCEMENT("公告", 1);
	
	private String typeName;
	private int typeCd;
	
	private NewsType(String name, int cd) {
		this.typeName = name;
		this.typeCd = cd;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public int getTypeCd() {
		return typeCd;
	}

	public void setTypeCd(int typeCd) {
		this.typeCd = typeCd;
	}
	
	public static NewsType getTypeByCd(int cd) {
		for(NewsType type : NewsType.values()) {
			if(type.getTypeCd() == cd) {
				return type;
			}
		}
		return null;
	}
}
