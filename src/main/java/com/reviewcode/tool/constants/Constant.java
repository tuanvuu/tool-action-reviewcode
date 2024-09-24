package com.reviewcode.tool.constants;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Constant {

    @UtilityClass
    public static class DateTimeFormat {
        public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
        public static final String YYYY_MM_DD = "yyyy-MM-dd";
        public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmssSSS";
        public static final String YYYYMMDD = "yyyyMMdd";
    }


    @UtilityClass
    public static class CICommon {
        public static final String CI_PROJECT_ID = "CI_PROJECT_ID";
        public static final String CI_PROJECT_NAME = "CI_PROJECT_NAME";
        public static final String CI_PROJECT_NAMESPACE = "CI_PROJECT_NAMESPACE";
        public static final String CI_PROJECT_URL = "CI_PROJECT_URL";
        public static final String CI_PROJECT_PATH = "CI_PROJECT_PATH";
        public static final String CI_PROJECT_PATH_SLUG = "CI_PROJECT_PATH_SLUG";
        public static final String CI_PROJECT_REF = "CI_PROJECT_REF";
        public static final String CI_PROJECT_VISIBILITY = "CI_PROJECT_VISIBILITY";
        public static final String CI_PROJECT_ID_PATH = "CI_PROJECT_ID_PATH";
        public static final String GITLAB_API_TOKEN = "GITLAB_API_TOKEN";
        public static final String CI_REPO_OWNER = "CI_REPO_OWNER";
        public static final String CI_REPO_NAME = "CI_REPO_NAME";
        public static final String CI_COMMIT = "CI_COMMIT";
        public static final String CI_PULL_REQUEST = "CI_PULL_REQUEST";
        public static final String CI_BRANCH = "CI_BRANCH"; //common
        public static final String CI_MERGE_REQUEST_IID = "CI_MERGE_REQUEST_IID"; //common
        public static final String CI_COMMIT_SHA = "CI_COMMIT_SHA"; //gitlab ci

    }


    public static class GitLab {
        public static final String GITLAB_DEFINE_NAME_TOKEN = "GITLAB_TOKEN";
        public static final String GITLAB_DEFINE_API = "GITLAB_API";
        public static final String GITLAB_DEFINE_CI_API_V4_URL = "CI_API_V4_URL";

    }
}
