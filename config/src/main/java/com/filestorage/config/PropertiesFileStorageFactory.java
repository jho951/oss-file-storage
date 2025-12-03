package com.filestorage.config;

import com.filestorage.api.FileStorage;
import com.filestorage.core.exception.FileStorageException;
import com.filestorage.core.local.LocalFileStorage;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * java.util.Properties 기반 FileStorage 생성기.
 */
public final class PropertiesFileStorageFactory {

	private PropertiesFileStorageFactory() {
	}

	public static FileStorage createLocalFromProperties(Properties props) {
		if (props == null) {
			throw new IllegalArgumentException("props must not be null");
		}

		String rootDir = props.getProperty(FileStorageConfigKeys.PROP_ROOT_DIR);
		if (rootDir == null || rootDir.isBlank()) {
			throw new FileStorageException("Property " + FileStorageConfigKeys.PROP_ROOT_DIR + " is required");
		}

		String autoCreate = props.getProperty(FileStorageConfigKeys.PROP_AUTO_CREATE_DIR, "true");

		Path rootPath = Paths.get(rootDir);
		boolean autoCreateDir = Boolean.parseBoolean(autoCreate);

		FileStorageConfig config = FileStorageConfig
			.builder(rootPath)
			.createDirectoriesIfNotExist(autoCreateDir)
			.build();

		return new LocalFileStorage(config);
	}
}
