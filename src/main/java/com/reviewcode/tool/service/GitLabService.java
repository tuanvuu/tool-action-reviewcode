package com.reviewcode.tool.service;

import com.reviewcode.tool.constants.Constant;
import com.reviewcode.tool.utils.EnvUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class GitLabService implements ICIService {
    private final String defaultGitlabApi = "https://gitlab.com/api/v4";

    @Override
    public void getBaseUrl() {
        String baseUrl = defaultGitlabApi;
        String token = EnvUtils.getEnv(Constant.GitLab.GITLAB_DEFINE_NAME_TOKEN);
        String gitlabApi = EnvUtils.getEnv(Constant.GitLab.GITLAB_DEFINE_API);
        String gitlabV4URL = EnvUtils.getEnv(Constant.GitLab.GITLAB_DEFINE_CI_API_V4_URL);
        if(StringUtils.isNotEmpty(gitlabApi)){
            baseUrl = gitlabApi;
        } else if (StringUtils.isNotEmpty(gitlabV4URL)){
            baseUrl = gitlabV4URL;
        }


    }

}
