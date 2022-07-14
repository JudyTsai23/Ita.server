package com.web.server.rest;

public interface IRestBase {

	/**
	 * 產生統一的格式物件回傳至前端
	 * @param appCode 後端的訊息代碼
	 * @param restData 回傳至前端的資料
	 */
	default RestResult buildResult(String appCode, Object restData) {
		return new RestResult(appCode, restData);
	}
}
