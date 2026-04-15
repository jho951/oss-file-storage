# 구현 가이드

## 로컬 저장소 생성

```java
FileStorageConfig config = FileStorageConfig
    .builder(Path.of("/tmp/files"))
    .createDirectoriesIfNotExist(true)
    .build();

FileStorage storage = new LocalFileStorage(config);
```

## 파일 저장

```java
FileMetadata metadata = new FileMetadata("image.png", "image/png");
StoredFile stored = storage.store(inputStream, metadata);
```

## 파일 읽기

```java
try (InputStream input = storage.load(stored.getId())) {
    // stream 처리
}
```

## 파일 삭제

```java
storage.delete(stored.getId());
```

## 파일 이동

```java
StoredFile moved = storage.move(stored.getId(), "archive");
```

## 조립 위치

`file-storage`는 저장 계층 본체만 제공합니다. 환경 변수, 프로퍼티, bean 등록 같은 조립 코드는 이 모듈을 소비하는 adapter에서 작성합니다.
