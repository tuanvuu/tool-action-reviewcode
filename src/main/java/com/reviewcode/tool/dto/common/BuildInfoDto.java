package com.reviewcode.tool.dto.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BuildInfoDto {
    private String owner;
    private String repo;
    private String sha;
    private int pullRequestNum;
    private String branch;
    private String gerritChangeID;
    private String gerritRevisionID;
}
