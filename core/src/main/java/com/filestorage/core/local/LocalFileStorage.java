package com.filestorage.core.local;

import com.filestorage.api.FileMetadata;
import com.filestorage.api.FileStorage;
import com.filestorage.api.StoredFile;
import com.filestorage.config.FileStorageConfig;
import com.filestorage.core.exception.FileStorageException;
import com.filestorage.core.util.PathUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * 로컬 디스크 기반 FileStorage 구현체.
 */
public final class LocalFileStorage implements FileStorage {

	private final FileStorageConfig config;

	public LocalFileStorage(FileStorageConfig config) {
		this.config = config;
		initRootDirectory();
	}

	private void initRootDirectory() {
		Path root = config.getRootDirectory();
		try {
			if (config.isCreateDirectoriesIfNotExist() && !Files.exists(root)) {
				Files.createDirectories(root);
			}
			if (!Files.isDirectory(root)) {
				throw new FileStorageException("Root directory is not a directory: " + root);
			}
		} catch (IOException e) {
			throw new FileStorageException("Failed to initialize root directory: " + root, e);
		}
	}

	@Override
	public StoredFile store(InputStream input, FileMetadata metadata) {
		if (input == null) {
			throw new IllegalArgumentException("InputStream must not be null");
		}
		String fileId = PathUtils.randomFileName();
		Path target = PathUtils.resolveSafe(config.getRootDirectory(), fileId);

		try {
			Files.copy(input, target);
			long size = Files.size(target);
			return new StoredFile(
				fileId,
				metadata != null ? metadata.getOriginalName() : null,
				metadata != null ? metadata.getContentType() : null,
				size,
				target
			);
		} catch (IOException e) {
			throw new FileStorageException("Failed to store file: " + target, e);
		}
	}

	@Override
	public InputStream load(String fileId) {
		Path path = getFilePath(fileId);
		try {
			return Files.newInputStream(path);
		} catch (IOException e) {
			throw new FileStorageException("Failed to load file: " + path, e);
		}
	}

	@Override
	public void delete(String fileId) {
		Path path = getFilePath(fileId);
		try {
			Files.deleteIfExists(path);
		} catch (IOException e) {
			throw new FileStorageException("Failed to delete file: " + path, e);
		}
	}

	@Override
	public StoredFile move(String fileId, String targetDirectory) {
		Path source = getFilePath(fileId);
		Path targetDir = PathUtils.resolveSafe(config.getRootDirectory(), targetDirectory);
		try {
			if (!Files.exists(targetDir)) {
				Files.createDirectories(targetDir);
			}
			Path target = targetDir.resolve(source.getFileName());
			Files.move(source, target);
			long size = Files.size(target);
			return new StoredFile(
				fileId,
				null,
				null,
				size,
				target
			);
		} catch (IOException e) {
			throw new FileStorageException("Failed to move file: " + source, e);
		}
	}

	private Path getFilePath(String fileId) {
		if (fileId == null || fileId.isBlank()) {
			throw new IllegalArgumentException("fileId must not be blank");
		}
		Path path = PathUtils.resolveSafe(config.getRootDirectory(), fileId);
		if (!Files.exists(path)) {
			throw new FileStorageException("File not found: " + path);
		}
		return path;
	}
}
