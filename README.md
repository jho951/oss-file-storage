# file-storage

[![Build](https://github.com/jho951/file-storage/actions/workflows/build.yml/badge.svg)](https://github.com/jho951/file-storage/actions/workflows/build.yml)
[![Maven Central](https://img.shields.io/maven-central/v/io.github.jho951/file-storage-core?label=maven%20central)](https://central.sonatype.com/search?q=jho951)
[![License](https://img.shields.io/badge/license-MIT-blue)](./LICENSE)
[![Tag](https://img.shields.io/github/v/tag/jho951/file-storage)](https://github.com/jho951/file-storage/tags)

## 공개 좌표

- `io.github.jho951:file-storage-api`
- `io.github.jho951:file-storage-core`

## 무엇을 제공하나

- `file-storage-api`: 파일 저장 계약과 공통 결과 모델
- `file-storage-core`: 로컬 디스크 기반 참조 구현, 설정 객체, 경로 유틸, 예외

## 1계층 책임

이 저장소는 1계층 파일 저장 기능만 제공합니다.

### 포함

- 파일 저장/조회/삭제/이동 계약
- 저장 파일 메타데이터와 결과 모델
- 로컬 디스크 기반 참조 구현
- 저장소 구현체가 따라야 할 예외와 경로 처리 유틸

### 제외

- 파일 분류 정책
- 파일 소유자/권한 판단
- 저장 메타데이터 영속화
- 이미지 리사이징, 바이러스 스캔 같은 후처리
- 다운로드 URL 생성
- framework integration

## 빠른 시작

```gradle
repositories {
    mavenCentral()
}

dependencies {
    implementation("io.github.jho951:file-storage-core:<version>")
}
```

## 문서

- [docs/README.md](docs/README.md)
- [구현 가이드](docs/implementation-guide.md)
- [기여 가이드](CONTRIBUTING.md)
