package com.youvegotnigel.automation.utils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Stanza {

    private final List<SongNote> NOTES = new ArrayList<>();
    private int loopCount = 1;

    public Stanza note(String keyName) {
        return note(keyName, 0);
    }

    public Stanza note(String keyName, Integer sleepTime) {
        this.NOTES.add(new SongNote(keyName, sleepTime, 1));
        return this;
    }

    public Stanza note(String keyName, Integer sleepTime, Integer loopCount) {
        this.NOTES.add(new SongNote(keyName, sleepTime, loopCount));
        return this;
    }


    public Stanza notes(List<SongNote> notes) {
        return notes(notes, 1);
    }

    public Stanza notes(List<SongNote> notes, Integer loopCount) {
        for(int c=0; c< loopCount;c++) {
            Collections.addAll(this.NOTES, notes.toArray(new SongNote[]{}));
        }
        return this;
    }

    public Stanza loop(Integer loopCount) {
        this.loopCount = loopCount;
        return this;
    }

    public Integer getLoopCount() {
        return this.loopCount;
    }

    public List<SongNote> getSongNotes() {
        return NOTES;
    }
}



