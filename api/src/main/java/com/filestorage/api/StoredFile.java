package com.filestorage.api;

import java.nio.file.Path;

/**
 * @file StoredFile.java
 * 저장 완료 후 반환되는 파일 정보.
 */
public final class StoredFile {
	// 스토리지 내부에서 이 파일을 구분하기 위한 파일 식별자
	private final String id;
	// 사용자가 업로드했던 원래 파일 이름
	private final String originalName;
	// MIME 타입 (HTTP Content-Type)
	private final String contentType;
	// 실제 저장된 파일 크기 (바이트 단위)
	private final long size;
	// 실제 파일이 저장된 절대 경로
	private final Path absolutePath;

	public StoredFile(String id, String originalName, String contentType, long size, Path absolutePath) {
		this.id = id;
		this.originalName = originalName;
		this.contentType = contentType;
		this.size = size;
		this.absolutePath = absolutePath;
	}

	public String getId() {
		return id;
	}

	public String getOriginalName() {
		return originalName;
	}

	public String getContentType() {
		return contentType;
	}

	public long getSize() {
		return size;
	}

	public Path getAbsolutePath() {
		return absolutePath;
	}
}
