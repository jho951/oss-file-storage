# 테스트와 CI

## 로컬 검증

```bash
./gradlew clean test
```

전체 jar, javadoc, sources jar 생성까지 확인하려면 다음을 실행합니다.

```bash
./gradlew clean build
```

## GitHub Actions

- `build.yml`: PR과 main push에서 `./gradlew clean test`를 실행합니다.
- `publish.yml`: `v*` 태그 push에서 테스트 후 Maven Central publish를 실행합니다.

## 배포 검증

배포 대상은 `file-storage-api`, `file-storage-core`입니다. publish workflow는 태그 이름에서 `v`를 제거한 값을 `release_version`으로 전달합니다.
