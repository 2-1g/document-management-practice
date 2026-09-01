package com.hangyeol.documentmanagement.project.dto.response;

import com.hangyeol.documentmanagement.project.Project;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class ProjectResponse {
    private final Long projectId;
    private final String title;
    private final String description;
    private final Integer documentCount;
    private final String ownerName;
    private final LocalDateTime createdAt;

    public static ProjectResponse from(
            Project project,
            Integer documentCount
    ) {
        return new ProjectResponse(
                project.getId(),
                project.getTitle(),
                project.getDescription(),
                documentCount,
                project.getOwner().getName(),
                project.getCreatedAt()
        );
    }
}
