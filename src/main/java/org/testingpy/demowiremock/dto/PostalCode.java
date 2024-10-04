package org.testingpy.demowiremock.dto;

public class PostalCode {
    private String format;
    private String regex;

    public String getFormat() { return format; }
    public void setFormat(String value) { this.format = value; }

    public String getRegex() { return regex; }
    public void setRegex(String value) { this.regex = value; }
}