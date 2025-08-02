package com.example.julyandroid;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    private List<Search> Search = new ArrayList<Search>();
    private String totalResults;
    private String response;

    public Movie(List<Search> search, String totalResults, String response) {
        Search = search;
        this.totalResults = totalResults;
        this.response = response;
    }

    public List<Search> getSearch() {
        return Search;
    }

    public void setSearch(List<Search> search) {
        Search = search;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
