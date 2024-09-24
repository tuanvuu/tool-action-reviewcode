package com.reviewcode.tool.service;

import com.reviewcode.tool.config.properties.GitlabInfoProperties;
import com.reviewcode.tool.constants.Constant;
import com.reviewcode.tool.constants.error.GeneralResultCode;
import com.reviewcode.tool.dto.common.BuildInfoDto;
import com.reviewcode.tool.exception.BadRequestException;
import com.reviewcode.tool.utils.EnvUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class GitLabService extends BaseCICommonService implements ICIService {
    private static final String defaultDomain = "https://gitlab.com/api/v4";
    private final GitlabInfoProperties gitlabInfoProperties;

    @Override
    public String getBaseDomainCI() {
        String gitlabUrl = EnvUtils.getEnv(Constant.GitLab.GITLAB_DEFINE_API);
        String gitlabApiv4 = EnvUtils.getEnv(Constant.GitLab.GITLAB_DEFINE_CI_API_V4_URL);
        String baseUrl = defaultDomain;
        if(ObjectUtils.isNotEmpty(gitlabUrl)){
            baseUrl = gitlabUrl;
        }
        if (ObjectUtils.isNotEmpty(gitlabApiv4)) {
            baseUrl = gitlabApiv4;
        }
        return baseUrl;
    }

    @Override
    public void buildWithClient() {
        String apiToken = gitlabInfoProperties.getApiToken();
        if (StringUtils.isEmpty(apiToken)) {
            log.error("GitLab API token is empty");
            throw BadRequestException.from(GeneralResultCode.MISSING_PARAM, Constant.CICommon.GITLAB_API_TOKEN);
        }
        BuildInfoDto buildInfoDto = this.getBuildInfoDto();
    }


}
