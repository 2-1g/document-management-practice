# Document Management Practice

Spring Boot 기반 문서 관리 백엔드 개발 연습 프로젝트입니다.

ERD를 바탕으로 사용자, 프로젝트, 문서 도메인을 구현하고 GitHub의 Issue, Branch, Commit, Pull Request 흐름을 연습하는 것을 목표로 합니다.

## 기술 스택

- Java 25
- Spring Boot 4.1
- Gradle Groovy
- Spring Web MVC
- Spring Data JPA
- Validation
- PostgreSQL

## 개발 흐름

모든 작업은 다음 순서로 진행합니다.

```text
Issue 생성
→ main에서 작업 브랜치 생성
→ 개발 및 커밋
→ 브랜치 Push
→ Pull Request 생성
→ 테스트 및 변경 내용 확인
→ main으로 Merge
→ 작업 브랜치 삭제
```

별도의 `develop` 브랜치는 사용하지 않습니다.

초기 설정 이후에는 `main` 브랜치에 직접 커밋하지 않고 작업 브랜치와 Pull Request를 사용합니다.

## Issue Convention

### Issue 제목

```text
[Type] 작업 내용
```

예시:

```text
[Feat] 프로젝트 엔티티 구현
[Fix] 프로젝트 조회 오류 수정
[Refactor] 문서 서비스 구조 개선
[Docs] README 개발 규칙 추가
```

### Issue 종류

| Type | 설명 |
|---|---|
| `Feat` | 새로운 기능 |
| `Fix` | 오류 수정 |
| `Refactor` | 기능 변화 없는 코드 개선 |
| `Test` | 테스트 추가 및 수정 |
| `Docs` | 문서 추가 및 수정 |
| `Chore` | 설정, 의존성, 빌드 관련 작업 |

### Issue 내용

```markdown
## 작업 내용

- 구현할 내용을 작성합니다.

## 완료 조건

- [ ] 완료 조건 1
- [ ] 완료 조건 2
```

예시:

```markdown
## 작업 내용

- Project 엔티티를 구현합니다.
- User와 Project의 연관관계를 설정합니다.

## 완료 조건

- [ ] Project 엔티티가 ERD와 일치한다.
- [ ] User와 Project가 다대일 관계로 연결된다.
- [ ] 관련 테스트가 통과한다.
```

## Branch Convention

### 브랜치 이름

```text
type/이슈번호-작업내용
```

브랜치의 작업 내용은 영문 소문자와 하이픈을 사용합니다.

예시:

```text
feat/1-project-entity
fix/2-project-not-found
refactor/3-document-service
docs/4-update-readme
chore/5-database-config
```

### 브랜치 종류

| Type | 설명 |
|---|---|
| `feat` | 새로운 기능 |
| `fix` | 오류 수정 |
| `refactor` | 리팩터링 |
| `test` | 테스트 코드 |
| `docs` | 문서 작업 |
| `chore` | 설정 및 빌드 작업 |

### 브랜치 생성 규칙

1. 작업할 Issue를 먼저 생성합니다.
2. 최신 `main` 브랜치에서 작업 브랜치를 생성합니다.
3. 하나의 브랜치에서는 하나의 Issue만 처리합니다.
4. Merge가 끝난 브랜치는 삭제합니다.

## Commit Convention

### 커밋 메시지

```text
type: 작업 내용
```

예시:

```text
feat: 프로젝트 엔티티 추가
fix: 존재하지 않는 프로젝트 조회 오류 수정
refactor: 문서 생성 로직 분리
test: 프로젝트 생성 테스트 추가
docs: README 개발 규칙 추가
chore: PostgreSQL 의존성 추가
```

### 커밋 종류

| Type | 설명 |
|---|---|
| `feat` | 새로운 기능 추가 |
| `fix` | 오류 수정 |
| `refactor` | 기능 변화 없는 코드 개선 |
| `test` | 테스트 코드 추가 및 수정 |
| `docs` | 문서 추가 및 수정 |
| `chore` | 환경 설정, 의존성, 빌드 작업 |
| `style` | 공백, 들여쓰기 등 코드 스타일 수정 |

### 커밋 규칙

- 하나의 커밋에는 하나의 목적만 담습니다.
- 작업 내용을 이해할 수 있도록 구체적으로 작성합니다.
- 의미 없는 메시지를 사용하지 않습니다.

좋은 예시:

```text
feat: 프로젝트 생성 API 추가
```

피해야 할 예시:

```text
수정
작업함
테스트
최종
진짜최종
```

## Pull Request Convention

### PR 제목

```text
[Type] 작업 내용
```

예시:

```text
[Feat] 프로젝트 엔티티 구현
[Fix] 프로젝트 조회 오류 수정
[Chore] PostgreSQL 연결 설정
```

### PR 내용

```markdown
## 관련 Issue

Closes #이슈번호

## 변경 내용

- 변경 내용 1
- 변경 내용 2

## 확인 사항

- [ ] 애플리케이션이 정상적으로 실행된다.
- [ ] 관련 테스트가 통과한다.
- [ ] 불필요한 파일이 포함되지 않았다.
- [ ] Issue의 완료 조건을 만족한다.
```

예시:

```markdown
## 관련 Issue

Closes #1

## 변경 내용

- Project 엔티티를 추가했습니다.
- User와 Project의 다대일 관계를 설정했습니다.
- 프로젝트 생성 테스트를 추가했습니다.

## 확인 사항

- [x] 애플리케이션이 정상적으로 실행된다.
- [x] 관련 테스트가 통과한다.
- [x] 불필요한 파일이 포함되지 않았다.
- [x] Issue의 완료 조건을 만족한다.
```

`Closes #1`처럼 작성하면 PR이 Merge될 때 연결된 Issue가 자동으로 닫힙니다.

### PR 규칙

- 하나의 PR에서는 하나의 Issue만 처리합니다.
- Merge 전에 변경된 파일을 직접 확인합니다.
- 실행 또는 테스트가 실패하는 상태에서는 Merge하지 않습니다.
- 관련 Issue 번호를 반드시 작성합니다.
- Merge 방식은 `Squash and merge`를 사용합니다.
- Merge가 끝나면 작업 브랜치를 삭제합니다.

## Merge 이후 작업

PR을 Merge한 뒤 GitHub Desktop에서 다음 순서로 정리합니다.

1. 현재 브랜치를 `main`으로 변경합니다.
2. `Fetch origin` 또는 `Pull origin`을 실행합니다.
3. Merge된 작업 브랜치를 삭제합니다.
4. 다음 Issue를 생성합니다.
5. 최신 `main`에서 새로운 브랜치를 생성합니다.

## 작업 예시

```text
1. [Feat] 프로젝트 엔티티 구현 Issue 생성 (#1)

2. main에서 브랜치 생성
   feat/1-project-entity

3. 개발 후 커밋
   feat: 프로젝트 엔티티 추가
   feat: 사용자와 프로젝트 연관관계 설정
   test: 프로젝트 엔티티 테스트 추가

4. 브랜치 Push

5. PR 생성
   [Feat] 프로젝트 엔티티 구현

6. PR 본문에 Issue 연결
   Closes #1

7. 테스트 및 변경 내용 확인

8. Squash and merge

9. 작업 브랜치 삭제

10. GitHub Desktop에서 main 브랜치 Pull
```
