package com.example.tickets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class IncidentTicket {
    private final String id;
    private final String reporterEmail;
    private final String title;
    private final String description;
    private final String priority;
    private final List<String> tags;
    private final String assigneeEmail;
    private final boolean customerVisible;
    private final Integer slaMinutes;
    private final String source;

    // Private constructor: only accessible by the Builder
    private IncidentTicket(Builder builder) {
        this.id = builder.id;
        this.reporterEmail = builder.reporterEmail;
        this.title = builder.title;
        this.description = builder.description;
        this.priority = builder.priority;
        // Defensive copy to ensure immutability
        this.tags = Collections.unmodifiableList(new ArrayList<>(builder.tags));
        this.assigneeEmail = builder.assigneeEmail;
        this.customerVisible = builder.customerVisible;
        this.slaMinutes = builder.slaMinutes;
        this.source = builder.source;
    }

    // Getters only (no setters)
    public String getId() { return id; }
    public String getReporterEmail() { return reporterEmail; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getPriority() { return priority; }
    public List<String> getTags() { return tags; }
    public String getAssigneeEmail() { return assigneeEmail; }
    public boolean isCustomerVisible() { return customerVisible; }
    public Integer getSlaMinutes() { return slaMinutes; }
    public String getSource() { return source; }

    public static Builder builder() { return new Builder(); }

    // Allows "modifying" by creating a new instance based on this one
    public Builder toBuilder() {
        return new Builder()
                .id(this.id)
                .reporterEmail(this.reporterEmail)
                .title(this.title)
                .description(this.description)
                .priority(this.priority)
                .tags(new ArrayList<>(this.tags))
                .assigneeEmail(this.assigneeEmail)
                .customerVisible(this.customerVisible)
                .slaMinutes(this.slaMinutes)
                .source(this.source);
    }

    public static class Builder {
        private String id;
        private String reporterEmail;
        private String title;
        private String description;
        private String priority = "LOW";
        private List<String> tags = new ArrayList<>();
        private String assigneeEmail;
        private boolean customerVisible = false;
        private Integer slaMinutes;
        private String source = "WEB";

        public Builder id(String id) { this.id = id; return this; }
        public Builder reporterEmail(String email) { this.reporterEmail = email; return this; }
        public Builder title(String title) { this.title = title; return this; }
        public Builder description(String desc) { this.description = desc; return this; }
        public Builder priority(String p) { this.priority = p; return this; }
        public Builder tags(List<String> tags) { this.tags = tags; return this; }
        public Builder addTag(String tag) { this.tags.add(tag); return this; }
        public Builder assigneeEmail(String email) { this.assigneeEmail = email; return this; }
        public Builder customerVisible(boolean visible) { this.customerVisible = visible; return this; }
        public Builder slaMinutes(Integer sla) { this.slaMinutes = sla; return this; }
        public Builder source(String src) { this.source = src; return this; }

        public IncidentTicket build() {
            // Centralized Validation
            Validation.requireTicketId(id);
            Validation.requireEmail(reporterEmail, "reporterEmail");
            Validation.requireNonBlank(title, "title");
            Validation.requireMaxLen(title, 80, "title");
            Validation.requireOneOf(priority, "priority", "LOW", "MEDIUM", "HIGH", "CRITICAL");
            Validation.requireRange(slaMinutes, 5, 7200, "slaMinutes");
            if (assigneeEmail != null) {
                Validation.requireEmail(assigneeEmail, "assigneeEmail");
            }

            return new IncidentTicket(this);
        }
    }

    @Override
    public String toString() {
        return "IncidentTicket[ID=" + id + ", Priority=" + priority + ", Tags=" + tags + ", Assignee=" + assigneeEmail + "]";
    }
}