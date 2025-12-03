package com.filestorage.config;

/**
 * 환경 변수 / 프로퍼티 키 상수.
 */
public final class FileStorageConfigKeys {

	private FileStorageConfigKeys() {}

	public static final String ENV_ROOT_DIR = "FILESTORAGE_ROOT_DIR";
	public static final String ENV_AUTO_CREATE_DIR = "FILESTORAGE_AUTO_CREATE_DIR";

	public static final String PROP_ROOT_DIR = "filestorage.rootDir";
	public static final String PROP_AUTO_CREATE_DIR = "filestorage.autoCreateDir";
}
