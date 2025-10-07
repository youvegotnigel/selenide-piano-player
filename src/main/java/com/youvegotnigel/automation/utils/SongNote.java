package com.youvegotnigel.automation.utils;

public class SongNote {
    private final String keyName;
    private final Integer releaseTime;
    private final Integer loopCount;

    public SongNote(String keyName, Integer releaseTime, Integer loopCount) {
        this.keyName = keyName;
        this.releaseTime = releaseTime;
        this.loopCount = loopCount;
    }

    public String getKeyName() {
        return keyName;
    }

    public Integer getReleaseTime() {
        return releaseTime;
    }

    public Integer getLoopCount() {
        return loopCount;
    }
}
