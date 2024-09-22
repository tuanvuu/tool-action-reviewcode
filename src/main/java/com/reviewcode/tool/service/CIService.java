package com.reviewcode.tool.service;

import com.reviewcode.tool.dto.CIGetBuildInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CIService {

    public CIGetBuildInfo getBuildInfo(boolean isPr){

    }

    public String[] getOwnerAndRepoFromSlug(List<String> slugEnvs) {
        String repoSlug = getOneEnvValue(slugEnvs);
        if (repoSlug == null || !repoSlug.contains("/")) {
            return new String[]{"", ""};
        }
        String[] ownerAndRepo = repoSlug.split("/", 2);
        return ownerAndRepo.length < 2 ? new String[]{"", ""} : ownerAndRepo;
    }

    private String getOneEnvValue(List<String> envs) {
        for (String env : envs) {
            String value = System.getenv(env);
            if (value != null && !value.isEmpty()) {
                return value;
            }
        }
        return null;
    }



}
