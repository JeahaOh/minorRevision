# JAVA

## v0.5

- 조건문 반복문 메소드 활용
- 강사, 학생 , 매니져를 구분하여 입출력.

## v0.4

- 여러 속성의 값을 다루기 쉽도록 클래스를 이용하여 사용자 정의 데이터 타입을 만든다. 또한 그 데이터를 다룰 연산자를 정의한다.

## v0.3

- 관련된 명령들을 재사용하기 쉽도록 메서드 블록으로 묶는다.

## v0.2

- 배열을 이용하여 여러 회원의 정보를 저장하기.

## v0.1

- 반복문을 이용하여 여러 회원의 정보를 입력받아 출력하기

## v0.0 (Initial Commit)

- 자바 프로젝트 디렉토리 구성하기

```
1) github - repository 생성
2 - 3) terminal - dir에서 git Clone [url]
        cd dir 들어가기
        mkdir 작업 폴더 만들기
        cd 작업 폴더 들어가기
        $ gradle init --type java-application
4) VisualStudioCode(이하 VS) 에서 gradle 설정파일 (build.gradle)에
        id 'eclipse' 플러그인 추가 + mavenCentral() 옵션
        .gitignore 파일 생성
            .gradle/ .setting/ bin/ build/ .classpath .project
5) terminal : 작업 폴더에서 이클립스 설정파일 생성
             $ gradle eclipse
6) 이클립스에서 프로젝트 임포트.

    이렇게 하는 이유.
    gradle : 프로젝트를 형상화 해주는 빌드 도구. IDE에 종속되지 않도록 하는 개발.
    VS : 이클립스에서 할 수 없는 설정을 할 수 있음.
        
```