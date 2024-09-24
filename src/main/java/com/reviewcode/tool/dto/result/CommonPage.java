package com.reviewcode.tool.dto.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Accessors(chain = true)
@Data
public class CommonPage<T> {

    @JsonProperty("list_job")
    private List<T> jobs;
    @JsonProperty("total_page")
    private int totalPage;

    @JsonProperty(value = "row_per_page")
    private int rowPerPage;

    @JsonProperty(value = "total_record")
    private int totalRecord;

    @JsonProperty(value = "current_page")
    private int currentPage;


    public CommonPage() {
        jobs = new ArrayList<>();
    }


}
