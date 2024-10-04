package org.testingpy.demowiremock.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Country implements Serializable {
    private Name name;
    private String[] tld;
    private String cca2;
    private String ccn3;
    private String cca3;
    private String cioc;
    private boolean independent;
    private String status;
    private boolean unMember;
    private Currencies currencies;
    private Idd idd;
    private String[] capital;
    private String[] altSpellings;
    private String region;
    private String subregion;
    private Languages languages;
    private Map<String, Translation> translations;
    private long[] latlng;
    private boolean landlocked;
    private String[] borders;
    private long area;
    private Demonyms demonyms;
    private String flag;
    private Maps maps;
    private long population;
    private Gini gini;
    private String fifa;
    private Car car;
    private String[] timezones;
    private String[] continents;
    private Flags flags;
    private CoatOfArms coatOfArms;
    private String startOfWeek;
    private CapitalInfo capitalInfo;
    private PostalCode postalCode;

}