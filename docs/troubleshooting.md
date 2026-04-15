# 문제 해결

## 루트 디렉토리 오류

`LocalFileStorage`는 생성 시 루트 디렉토리가 없으면 설정에 따라 생성합니다. 자동 생성이 꺼져 있거나 경로가 디렉토리가 아니면 `FileStorageException`이 발생합니다.

## 파일을 찾을 수 없음

`load`, `delete`, `move`는 `fileId`로 계산한 경로가 존재하지 않으면 `FILE_NOT_FOUND` 예외를 던집니다. 저장 시 반환된 `StoredFile.getId()`를 그대로 사용해야 합니다.

## 경로 입력

`targetDirectory`는 루트 디렉토리 기준 하위 경로입니다. 파일 분류 정책과 권한 검증은 소비 계층에서 먼저 처리합니다.

## publish 실패

Maven Central 배포에는 다음 값이 필요합니다.

- `MAVEN_CENTRAL_USERNAME`
- `MAVEN_CENTRAL_PASSWORD`
- `MAVEN_CENTRAL_GPG_PRIVATE_KEY`
- `MAVEN_CENTRAL_GPG_PASSPHRASE`
