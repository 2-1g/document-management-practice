package com.hangyeol.documentmanagement.project.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@RequiredArgsConstructor
public class ProjectCreateRequest {
    @NotBlank(message = "프로젝트 제목은 필수입니다.")
    private final String title;

    private final String description;

    public static ProjectCreateRequest from(
            String title,
            String description
    ) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException();
        }

        return new ProjectCreateRequest(title, description);
    }
}
