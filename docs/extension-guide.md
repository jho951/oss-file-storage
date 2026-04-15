# 확장 가이드

## 새 저장소 추가

새 저장소는 `FileStorage` 인터페이스를 구현합니다.

```java
public final class CustomFileStorage implements FileStorage {
    // store, load, delete, move 구현
}
```

## 지켜야 할 계약

- `store`는 저장된 파일을 다시 찾을 수 있는 stable id를 반환합니다.
- `load`는 호출자가 닫아야 하는 `InputStream`을 반환합니다.
- `delete`는 저장소에서 파일을 제거합니다.
- `move`는 같은 저장소 안에서 파일 위치를 옮기고 동일한 id 기준으로 결과를 반환합니다.

## 분리 기준

- 구현체가 특정 인프라에 묶여도 `FileStorage` 계약은 바뀌지 않아야 합니다.
- 파일 분류, 소유권, 권한 정책은 구현체에 넣지 않습니다.
- bean 등록, 환경 변수 바인딩, 프로퍼티 바인딩은 별도 adapter에서 처리합니다.
