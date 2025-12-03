package com.filestorage.config;

import java.nio.file.Path;

/**
 * FileStorage 설정 값.
 */
public final class FileStorageConfig {

	private final Path rootDirectory;
	private final boolean createDirectoriesIfNotExist;

	private FileStorageConfig(Builder builder) {
		this.rootDirectory = builder.rootDirectory;
		this.createDirectoriesIfNotExist = builder.createDirectoriesIfNotExist;
	}

	public Path getRootDirectory() {
		return rootDirectory;
	}

	public boolean isCreateDirectoriesIfNotExist() {
		return createDirectoriesIfNotExist;
	}

	public static Builder builder(Path rootDirectory) {
		return new Builder(rootDirectory);
	}

	public static final class Builder {
		private final Path rootDirectory;
		private boolean createDirectoriesIfNotExist = true;

		public Builder(Path rootDirectory) {
			this.rootDirectory = rootDirectory;
		}

		public Builder createDirectoriesIfNotExist(boolean value) {
			this.createDirectoriesIfNotExist = value;
			return this;
		}

		public FileStorageConfig build() {
			return new FileStorageConfig(this);
		}
	}
}
