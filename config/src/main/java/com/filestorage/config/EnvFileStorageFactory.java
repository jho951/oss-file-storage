package com.filestorage.config;


import com.filestorage.api.FileStorage;
import com.filestorage.core.exception.FileStorageException;
import com.filestorage.core.local.LocalFileStorage;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 환경 변수 기반 FileStorage 생성기.
 * 필수: FILESTORAGE_ROOT_DIR
 * 선택: FILESTORAGE_AUTO_CREATE_DIR (default: true)
 */
public final class EnvFileStorageFactory {

	private EnvFileStorageFactory() {
	}

	public static FileStorage createLocalFromEnv() {
		String rootDir = System.getenv(FileStorageConfigKeys.ENV_ROOT_DIR);
		if (rootDir == null || rootDir.isBlank()) {
			throw new FileStorageException("Env " + FileStorageConfigKeys.ENV_ROOT_DIR + " is required");
		}
		String autoCreate = System.getenv(FileStorageConfigKeys.ENV_AUTO_CREATE_DIR);

		Path rootPath = Paths.get(rootDir);
		boolean autoCreateDir = autoCreate == null || Boolean.parseBoolean(autoCreate);

		FileStorageConfig config = FileStorageConfig
			.builder(rootPath)
			.createDirectoriesIfNotExist(autoCreateDir)
			.build();

		return new LocalFileStorage(config);
	}
}
