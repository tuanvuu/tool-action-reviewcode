package com.reviewcode.tool.dto;

import lombok.Data;

@Data
public class CIGetBuildInfo {
    private String owner;
    private String repo;
    private String branch;
    private String commitId;
    private String pullRequest;
    private String sha;
}
