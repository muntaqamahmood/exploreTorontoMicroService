package com.example.ec.exploretoronto.domain;

public enum Region {
    Peel_Region("Peel"), Durham_Region("Durham"), Scarborough("Scarborough"), York_Region("York"), Varies("Varies");
    private String label;
    private Region(String label) { this.label = label; }
    public static Region findByLabel(String byLabel) {
        for(Region r: Region.values()){
            if (r.label.equalsIgnoreCase(byLabel)) {
                return r;
            }
        }
        return null;
    }

}
