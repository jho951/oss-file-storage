package com.filestorage.core.exception;

public enum FileStorageErrorCode {

	// -----------------------------
	// 설정/환경 관련
	// -----------------------------
	REQUIRED_ENV_MISSING("FILE001", "ENV 값이 없습니다."),
	INVALID_ENV_VALUE("FILE002", "ENV 값이 일치하지 않습니다.");

	// -----------------------------
	// fields
	// -----------------------------
	private final String code;
	private final String defaultMessage;

	FileStorageErrorCode(String code, String defaultMessage) {
		this.code = code;
		this.defaultMessage = defaultMessage;
	}

	/** "E001", "E010" 처럼 심볼릭 코드.*/
	public String code() {
		return code;
	}

	/** 기본 메시지. 로그용/디폴트 응답용으로 사용.*/
	public String defaultMessage() {
		return defaultMessage;
	}

	@Override
	public String toString() {
		return code + " - " + defaultMessage;
	}
}
