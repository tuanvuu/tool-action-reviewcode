package com.reviewcode.tool.agent;

import com.reviewcode.tool.config.properties.GitlabInfoProperties;
import com.reviewcode.tool.dto.GitlabDiscussionResDto;
import com.reviewcode.tool.dto.GitlabMergeRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.gitlab.api.GitlabAPI;
import org.gitlab.api.models.GitlabDiscussion;
import org.gitlab.api.models.GitlabMergeRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class GitlabMRDiscussionAgent implements IMRDiscussionAgent {
    private final GitlabInfoProperties gitlabInfoProperties;


    @Override
    public GitlabDiscussionResDto createMergeRequestDiscussion(GitlabMergeRequestDto mergeRequestDto) {
        GitlabMergeRequest mergeRequest = mergeRequestDto.getMergeRequest();
        try {
            log.info("Create merge request discussion for project: {}, merge request: {}", mergeRequest.getProjectId(), mergeRequest.getId());
            GitlabAPI gitlabAPI = GitlabAPI.connect(gitlabInfoProperties.getBaseUrl(), gitlabInfoProperties.getApiToken());
            GitlabDiscussion discussionRes = gitlabAPI.createDiscussion(mergeRequest, mergeRequestDto.getBody(), mergeRequestDto.getPositionBaseSha(), mergeRequestDto.getPositionStartSha(), mergeRequestDto.getPositionHeadSha());
            return GitlabDiscussionResDto.builder()
                    .discussion(discussionRes)
                    .build();
        } catch (Exception e) {
            log.error("createMergeRequestDiscussion -- Exception: {}", e.getMessage(), e);
            throw new RuntimeException("createMergeRequestDiscussion -- Exception: " + e.getMessage());
        }
    }
}
