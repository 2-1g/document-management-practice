package com.hangyeol.documentmanagement.project;

import com.hangyeol.documentmanagement.project.dto.request.ProjectCreateRequest;
import com.hangyeol.documentmanagement.project.dto.response.ProjectResponse;
import com.hangyeol.documentmanagement.user.entity.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProjectTest {
    @Test
    void 프로젝트를_생성한다() {
        //given
        User owner = new User();
        String title = "졸프";
        String description = "RAG 챗봇 백엔드 서비스";

        //when
        Project project = Project.from(owner, title, description);

        //then
        assertAll(
                () -> assertSame(owner, project.getOwner()),
                () -> assertEquals(title, project.getTitle()),
                () -> assertEquals(description, project.getDescription()),
                () -> assertNull(project.getId())
                // ID가 NULL인지 확인하는 이유는 새 엔티티의 ID는 생성자가 아니라 DB가 만들어야 하기 때문
        );
    }

    @Test
    void 소유자_없이_프로젝트_생성_불가() {
        assertThrows(
                IllegalArgumentException.class,
                () -> Project.from(null, "제목", "설명")
        );
    }

    @Test
    void 제목_없이_프로젝트_생성_불가() {
        User owner = new User();

        assertAll(
                () -> assertThrows(
                        IllegalArgumentException.class,
                        () -> Project.from(owner, null, "설명")
                ),
                () -> assertThrows(
                        IllegalArgumentException.class,
                        () -> Project.from(owner, "", "설명")
                ),
                () -> assertThrows(
                        IllegalArgumentException.class,
                        () -> Project.from(owner, "     ", "설명")
                )
        );
    }

    @Test
    void 응답_DTO_생성() {
        // given
        User owner = User.from("홍길동");
        String title = "제목";
        String description = "설명";

        Project project = Project.from(owner, title, description);

        // when
        ProjectResponse response = ProjectResponse.from(project, 5);

        // then
        assertAll(
                () -> assertEquals("홍길동", response.getOwnerName()),
                () -> assertEquals(5, response.getDocumentCount()),
                () -> assertEquals(title, response.getTitle()),
                () -> assertEquals(description, response.getDescription())
        );
    }

    @Test
    void 프로젝트_생성_요청_DTO() {
        //given
        String title = "제목";
        String description = "설명";

        //when
        ProjectCreateRequest request = new ProjectCreateRequest(title, description);

        //then
        assertAll(
                () -> assertEquals("제목", request.getTitle()),
                () -> assertEquals("설명", request.getDescription())
        );

    }

    @Test
    void 프로젝트_생성_요청_DTO_제목_비어있으면_실패() {

        assertAll(
                () -> assertThrows(
                        IllegalArgumentException.class,
                        () -> ProjectCreateRequest.from("", "설명")
                ),
                () -> assertThrows(
                        IllegalArgumentException.class,
                        () -> ProjectCreateRequest.from(" ", "설명")
                ),
                () -> assertThrows(
                        IllegalArgumentException.class,
                        () -> ProjectCreateRequest.from(null, "설명")
                )
        );
    }

}
