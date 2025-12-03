package com.filestorage.api;

import java.io.InputStream;

/**
 * 파일을 저장/조회/삭제/이동하는 추상화.
 * 구현체(Local, S3, NFS 등)는 이 인터페이스를 구현한다.
 */
public interface FileStorage {

	StoredFile store(InputStream input, FileMetadata metadata);

	InputStream load(String fileId);

	void delete(String fileId);

	StoredFile move(String fileId, String targetDirectory);
}
