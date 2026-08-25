package com.hangyeol.documentmanagement.project.entity;

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
                () -> assertSame(title, project.getTitle()),
                () -> assertSame(description, project.getDescription()),
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
                        () -> Project.from(owner, null, "")
                ),
                () -> assertThrows(
                        IllegalArgumentException.class,
                        () -> Project.from(owner, null, " ")
                )
        );
    }
}
