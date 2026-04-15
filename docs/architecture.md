# 아키텍처

## 목표

`file-storage`는 파일 저장 계약과 기본 저장 구현만 제공하는 1계층 파일 저장 OSS입니다.

## 계층

- `file-storage-api`: 외부에 공개되는 저장 계약과 데이터 모델
- `file-storage-core`: 기본 구현과 구현체 공통 유틸

## 의존 방향

- `file-storage-core`는 `file-storage-api`에 의존합니다.
- 소비 계층은 `FileStorage` 계약을 기준으로 저장 기능을 조립합니다.
- framework integration은 이 모듈 밖의 adapter 계층에서 구성합니다.

## 책임 경계

- 저장소 구현은 파일 데이터를 저장하고 다시 읽을 수 있게 만드는 책임만 가집니다.
- 파일 소유권, 접근 권한, 메타데이터 영속화, URL 정책은 소비 계층 책임입니다.
- 로컬 구현은 참조용 백엔드이며 다른 저장소 구현으로 교체할 수 있어야 합니다.
