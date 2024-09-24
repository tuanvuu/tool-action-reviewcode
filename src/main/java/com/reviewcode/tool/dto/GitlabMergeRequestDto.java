package com.reviewcode.tool.dto;

import lombok.Data;
import org.gitlab.api.models.GitlabMergeRequest;

@Data
public class GitlabMergeRequestDto {
    private GitlabMergeRequest mergeRequest;
    private String body;
    private String positionBaseSha;
    private String positionStartSha;
    private String positionHeadSha;
}

