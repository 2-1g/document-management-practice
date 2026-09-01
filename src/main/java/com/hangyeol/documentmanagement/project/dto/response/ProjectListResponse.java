package com.hangyeol.documentmanagement.project.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class ProjectListResponse {
    private final List<ProjectResponse> projects;
}
