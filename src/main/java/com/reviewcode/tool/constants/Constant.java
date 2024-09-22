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



    public static class GitLab {
        public static final String GITLAB_DEFINE_NAME_TOKEN = "GITLAB_TOKEN";
        public static final String GITLAB_DEFINE_API = "GITLAB_API";
        public static final String GITLAB_DEFINE_CI_API_V4_URL = "CI_API_V4_URL";

    }
}
