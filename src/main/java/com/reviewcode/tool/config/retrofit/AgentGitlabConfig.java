package com.reviewcode.tool.config.retrofit;

import com.reviewcode.tool.agent.GitLabAgent;
import com.reviewcode.tool.converter.Jksonizer;
import lombok.RequiredArgsConstructor;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;

import java.util.concurrent.TimeUnit;

@Configuration
@RequiredArgsConstructor
public class AgentGitlabConfig {

    @Value("${spring.client.gitlab.url}")
    private String baseUrl;

    @Bean(name = "httpClientGitlab")
    OkHttpClient providerGitlabOkHttpClient() {
        return new OkHttpClient.Builder()
                .readTimeout(5, TimeUnit.MINUTES).build();
    }


    @Bean(name = "gitlabRetrofit")
    Retrofit providerGitlabRetrofit(@Qualifier("httpClientGitlab") OkHttpClient httpClient) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(Jksonizer.getConverterFactory())
                .client(httpClient)
                .build();
    }

    @Bean(name = "gitlabAgent")
    GitLabAgent gitlabAgent(@Qualifier("gitlabRetrofit") Retrofit retrofit) {
        return retrofit.create(GitLabAgent.class);
    }
}
