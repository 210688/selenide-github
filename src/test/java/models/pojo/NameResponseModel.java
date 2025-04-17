package models.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NameResponseModel {
    String name;
    String job;

    String id;
    String createAt;

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }
    public String getId() {
        return id;
    }

    public String getCreatedAt() {
        return createAt;
    }
}

