package io.tradeledger.challenge;

import java.util.List;

public class Configuration {
    private String id;
    private List<String> urls;

    public Configuration(String id, List<String> urls) {
        this.id = id;
        this.urls = urls;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }
}
