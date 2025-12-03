package com.filestorage.api;

/**
 * @file FileMetadata.java
 * 저장 요청 시 제공하는 파일 메타데이터
 */
public final class FileMetadata {

	// 업로드 전 사용자가 가지고 있던 파일 이름
	private final String originalName;
	// http 헤더 타입
	private final String contentType;

	public String getOriginalName() {
		return originalName;
	}
	public String getContentType() {
		return contentType;
	}

	public FileMetadata(String originalName, String contentType) {
		this.originalName = originalName;
		this.contentType = contentType;
	}
}
