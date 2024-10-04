package org.testingpy.demowiremock.dto;

public class Name {
    private String common;
    private String official;
    private NativeName nativeName;

    public String getCommon() { return common; }
    public void setCommon(String value) { this.common = value; }

    public String getOfficial() { return official; }
    public void setOfficial(String value) { this.official = value; }

    public NativeName getNativeName() { return nativeName; }
    public void setNativeName(NativeName value) { this.nativeName = value; }
}