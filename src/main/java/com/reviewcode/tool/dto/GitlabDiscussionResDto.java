package com.reviewcode.tool.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.gitlab.api.models.GitlabDiscussion;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GitlabDiscussionResDto {
    private GitlabDiscussion discussion;

    public void setDiscussion(GitlabDiscussion discussion) {
        this.discussion = discussion;
    }

    public GitlabDiscussion getDiscussion() {
        return discussion;
    }
}
