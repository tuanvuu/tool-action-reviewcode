package com.reviewcode.tool.service;

import com.reviewcode.tool.constants.Constant;
import com.reviewcode.tool.constants.error.GeneralResultCode;
import com.reviewcode.tool.dto.common.BuildInfoDto;
import com.reviewcode.tool.exception.BadRequestException;
import com.reviewcode.tool.utils.EnvUtils;
import org.apache.commons.lang3.StringUtils;

import java.text.MessageFormat;
import java.util.Map;

public class BaseCICommonService {
    private static final String[] ciBranchDefault = { Constant.CICommon.CI_BRANCH };
    private static final String[] ciPRNum = { Constant.CICommon.CI_MERGE_REQUEST_IID };
    private static final String[] ciRepoOwner = { Constant.CICommon.CI_REPO_OWNER , Constant.CICommon.CI_PROJECT_NAMESPACE };
    private static final String[] ciReName = { Constant.CICommon.CI_REPO_NAME , Constant.CICommon.CI_PROJECT_NAME };
    private static final String[] ciSHA = { Constant.CICommon.CI_COMMIT , Constant.CICommon.CI_COMMIT_SHA };

    protected String getCIProjectId() {
        String projectId = EnvUtils.getEnv(Constant.CICommon.CI_PROJECT_ID);
        if (StringUtils.isBlank(projectId)) {
            throw BadRequestException.from(GeneralResultCode.MISSING_PARAM, MessageFormat.format("{0} is empty", Constant.CICommon.CI_PROJECT_ID));
        }
        return projectId;
    }


    protected String getCIProjectName() {
        String projectName = EnvUtils.getEnv(Constant.CICommon.CI_PROJECT_NAME);
        if (StringUtils.isBlank(projectName)) {
            BadRequestException.from(GeneralResultCode.MISSING_PARAM, MessageFormat.format("{0} is empty", Constant.CICommon.CI_PROJECT_NAME));
        }
        return projectName;
    }


    protected String getCIProjectNamespace() {
        String projectNamespace = EnvUtils.getEnv(Constant.CICommon.CI_PROJECT_NAMESPACE);
        if (StringUtils.isBlank(projectNamespace)) {
            BadRequestException.from(GeneralResultCode.MISSING_PARAM, MessageFormat.format("{0} is empty", Constant.CICommon.CI_PROJECT_NAMESPACE));
        }
        return projectNamespace;
    }

    protected String getCIRepoOwner() {
        String projectRef = EnvUtils.getEnv(Constant.CICommon.CI_REPO_OWNER);
        if (StringUtils.isBlank(projectRef)) {
            BadRequestException.from(GeneralResultCode.MISSING_PARAM, MessageFormat.format("{0} is empty", Constant.CICommon.CI_REPO_OWNER));
        }
        return projectRef;
    }


    protected String getCIProjectUrl() {
        String projectUrl = EnvUtils.getEnv(Constant.CICommon.CI_PROJECT_URL);
        if (StringUtils.isBlank(projectUrl)) {
            BadRequestException.from(GeneralResultCode.MISSING_PARAM, MessageFormat.format("{0} is empty", Constant.CICommon.CI_PROJECT_URL));
        }
        return projectUrl;
    }


    protected String getCIProjectPath() {
        String projectPath = EnvUtils.getEnv(Constant.CICommon.CI_PROJECT_PATH);
        if (StringUtils.isBlank(projectPath)) {
            BadRequestException.from(GeneralResultCode.MISSING_PARAM, MessageFormat.format("{0} is empty", Constant.CICommon.CI_PROJECT_PATH));
        }
        return projectPath;
    }


    protected String getCIProjectPathSlug() {
        String projectPathSlug = EnvUtils.getEnv(Constant.CICommon.CI_PROJECT_PATH_SLUG);
        if (StringUtils.isBlank(projectPathSlug)) {
            BadRequestException.from(GeneralResultCode.MISSING_PARAM, MessageFormat.format("{0} is empty", Constant.CICommon.CI_PROJECT_PATH_SLUG));
        }
        return projectPathSlug;
    }


    protected String getCIProjectVisibility() {
        String projectVisibility = EnvUtils.getEnv(Constant.CICommon.CI_PROJECT_VISIBILITY);
        if (StringUtils.isBlank(projectVisibility)) {
            BadRequestException.from(GeneralResultCode.MISSING_PARAM, MessageFormat.format("{0} is empty", Constant.CICommon.CI_PROJECT_VISIBILITY));
        }
        return projectVisibility;
    }


    protected String getCIProjectIdPath() {
        String projectIdPath = EnvUtils.getEnv(Constant.CICommon.CI_PROJECT_ID_PATH);
        if (StringUtils.isBlank(projectIdPath)) {
            BadRequestException.from(GeneralResultCode.MISSING_PARAM, MessageFormat.format("{0} is empty", Constant.CICommon.CI_PROJECT_ID_PATH));
        }
        return projectIdPath;
    }

    protected String getCIRepoName() {
        String ciRepoName = EnvUtils.getEnv(Constant.CICommon.CI_REPO_NAME);
        if (StringUtils.isBlank(ciRepoName)) {
            BadRequestException.from(GeneralResultCode.MISSING_PARAM, MessageFormat.format("{0} is empty", Constant.CICommon.CI_REPO_NAME));
        }
        return ciRepoName;
    }

    protected BuildInfoDto getBuildInfoDto() {
        return BuildInfoDto.builder()
                .owner(this.getOneEnvValue(ciRepoOwner))
                .repo(this.getOneEnvValue(ciReName))
                .branch(this.getOneEnvValue(ciBranchDefault))
                .sha(this.getOneEnvValue(ciSHA))
                .pullRequestNum(Integer.parseInt(this.getOneEnvValue(ciPRNum)))
                .build();
    }

    protected String getOneEnvValue(String[] envs) {
        Map<String, String> env = System.getenv();
        for (String envVar : envs) {
            String value = env.get(envVar);
            if (value != null && !value.isEmpty()) {
                return value;
            }
        }
        return StringUtils.EMPTY;
    }

}
