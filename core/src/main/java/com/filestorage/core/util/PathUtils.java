package com.filestorage.core.util;

import java.nio.file.Path;
import java.util.UUID;

/** 경로 및 파일명 관련 유틸리티. */
public final class PathUtils {

	private PathUtils() {}

	public static Path resolveSafe(Path root, String... segments) {
		Path result = root;
		for (String segment : segments) {
			if (segment == null || segment.isBlank()) { continue; }
			String clean = segment.replace("\\", "/").replace("..", "");
			result = result.resolve(clean);
		}
		return result.normalize();
	}

	public static String randomFileName() {
		return UUID.randomUUID().toString();
	}
}
