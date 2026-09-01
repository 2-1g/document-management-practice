package com.hangyeol.documentmanagement.project.entity;

import com.hangyeol.documentmanagement.common.entity.BaseTimeEntity;
import com.hangyeol.documentmanagement.user.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Project extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User owner;

    @Column(nullable = false)
    private String title;

    private String description;

    private Project(User owner, String title, String description) {
        validate(owner, title);

        this.owner = owner;
        this.title = title;
        this.description = description;
    }

    public static Project from(User owner, String title, String description) {
        return new Project(owner, title, description);
    }

    private void validate(User owner, String title) {
        if (owner == null
            || title == null
            || title.isBlank()) {
            throw new IllegalArgumentException(
                    "프로젝트 작성자와 제목은 필수입니다."
            );
        }
    }
}
