package com.web.server.cnst;

public class AppCode {

	public static class SERVER {
		/**
		 * 增刪改查成功
		 */
		public enum SUCCESS implements IAppCode {
			/**
			 * 新增成功
			 */
			INSERT_SUCCESS("SUCCESS_001"),
			/**
			 * 查詢成功
			 */
			QUERY_SUCCESS("SUCCESS_002"),
			/**
			 * 刪除成功
			 */
			DELETE_SUCCESS("SUCCESS_003"),
			/**
			 * 更新成功
			 */
			UPDATE_SUCCESS("SUCCESS_004"),;

			private String code;

			SUCCESS(String code) {
				this.code = code;
			}

			@Override
			public String getCode() {
				return this.code;
			}
		}

		/**
		 * 失敗、錯誤等
		 */
		public enum ERROR implements IAppCode {
			/**
			 * 未知的錯誤
			 */
			UNKNOWN("ERROR_999"),
			/**
			 * 無資料
			 */
			NO_DATA("ERROR_001"),
			/**
			 * 資料錯誤
			 */
			DATA_ERROR("ERROR_002"),
			/**
			 * 資料錯誤
			 */
			INSERT_ERROR("ERROR_003"),
			/**
			 * 資料錯誤
			 */
			QUERY_ERROR("ERROR_004"),
			/**
			 * 資料錯誤
			 */
			DELETE_ERROR("ERROR_005"),
			/**
			 * 資料錯誤
			 */
			UPDATE_ERROR("ERROR_006"),
			;
			
			private String code;

			ERROR(String code) {
				this.code = code;
			}

			@Override
			public String getCode() {
				return this.code;
			}
		}
	}

	/**
	 * 驗證
	 */
	public static class VALID {
		/**
		 * 變數驗證
		 */
		public enum VAL implements IAppCode {
			/**
			 * 欄位為必填/不可為空
			 */
			FIELD_REQUIRED("VAL_001"),
			/**
			 * 格式錯誤
			 */
			WRONG_FORMAT("VAL_002"),;

			private String code;

			VAL(String code) {
				this.code = code;
			}

			@Override
			public String getCode() {
				return this.code;
			}
		}

		/**
		 * 權限驗證
		 */
		public enum AUTH implements IAppCode {
			/**
			 * 登入成功
			 */
			LOGIN_SUCCESS("AUTH_001"),
			/**
			 * 登入失敗
			 */
			LOGIN_FAIL("AUTH_002"),
			/**
			 * 驗證錯誤
			 */
			NO_LOGIN("AUTH_003"),
			/**
			 * 無此功能權限
			 */
			NO_AUTH("AUTH_004"),;

			private String code;

			AUTH(String code) {
				this.code = code;
			}

			@Override
			public String getCode() {
				return this.code;
			}
		}
	}
}
