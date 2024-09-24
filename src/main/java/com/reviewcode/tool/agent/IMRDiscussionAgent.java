package com.reviewcode.tool.agent;

import com.reviewcode.tool.dto.GitlabDiscussionResDto;
import com.reviewcode.tool.dto.GitlabMergeRequestDto;

public interface IMRDiscussionAgent {
    GitlabDiscussionResDto createMergeRequestDiscussion(GitlabMergeRequestDto mergeRequestDto);
}
