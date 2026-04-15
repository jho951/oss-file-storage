# 모듈 가이드

## 종류

- `file-storage-api`: 파일 저장 계약과 공통 모델
- `file-storage-core`: 로컬 디스크 참조 구현, 설정 객체, 경로 유틸, 예외

## 읽는 법

- 저장소를 소비하는 2계층 코드는 `file-storage-api`의 `FileStorage`부터 보면 됩니다.
- 로컬 디스크 저장 구현이 필요하면 `file-storage-core`의 `LocalFileStorage`를 사용합니다.
- 새 저장소를 추가하려면 `FileStorage`를 구현하고 `StoredFile` 반환 계약을 지키면 됩니다.
- 실제 조립 예시는 [구현 가이드](./implementation-guide.md)를 보면 됩니다.

## 책임 경계

- `file-storage-api`
  - `FileStorage`, `FileMetadata`, `StoredFile`을 제공합니다.
  - 저장/조회/삭제/이동에 필요한 최소 계약만 표현합니다.
- `file-storage-core`
  - `LocalFileStorage`와 `FileStorageConfig`를 제공합니다.
  - `PathUtils`, `FileStorageException`, `FileStorageErrorCode`를 포함합니다.
  - 경로 계산과 로컬 파일 I/O 실패를 공통 예외로 변환합니다.

## 1계층으로 유지하는 기준

- 포함 가능: 파일 저장 계약, 저장 결과 모델, 저장소 구현체, 저장소 구현에 필요한 공통 예외와 유틸
- 포함 불가: 파일 분류 정책, 권한 모델, 영속화 entity, controller, framework integration
- framework integration은 generic이어도 1계층 본체가 아니라 adapter 계층으로 분리합니다.

## 배포 대상

- `file-storage-api`
- `file-storage-core`
