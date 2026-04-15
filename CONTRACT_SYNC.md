# CONTRACT_SYNC - file-storage

## 기준

- 기준 SOT: `oss-contract`
- 소비 계층 계약 기준: 2계층 adapter contract
- 대상 레포: `file-storage`

## 확인된 역할

- 파일 저장 기능을 인터페이스로 추상화한 모듈
- file-storage-api / file-storage-core 분리
- 로컬 디스크 기반 저장 구현

## 버전 규칙

- 기본 버전 SOT는 `gradle.properties`의 `release_version`이다.
- 릴리스 시에만 `release_version`으로 임시 override한다.
- `publish.yml`은 태그 push에서만 동작한다.
- `build.yml`은 PR / main push 검증에만 사용한다.

## 반영 문서

- `README.md`
- `docs/README.md`
- `docs/architecture.md`
- `docs/modules.md`
- `docs/extension-guide.md`
- `docs/implementation-guide.md`
- `docs/testing-and-ci.md`
- `docs/troubleshooting.md`
- `build.gradle`
- `settings.gradle`
- `.github/workflows/build.yml`
- `.github/workflows/publish.yml`
