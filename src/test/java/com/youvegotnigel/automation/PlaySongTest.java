package com.youvegotnigel.automation;

import com.youvegotnigel.automation.songs.CoffinDance;
import com.youvegotnigel.automation.songs.GameOfThrone;
import com.youvegotnigel.automation.songs.Golden;
import com.youvegotnigel.automation.songs.HappyBirthday;
import com.youvegotnigel.automation.utils.PianoPlayer;
import org.testng.annotations.Test;

public class PlaySongTest {


    @Test
    public void playHappyBirthday() {
        PianoPlayer player = new PianoPlayer().initialize();
        player.playSong(HappyBirthday.songNotes);
    }

    @Test
    public void playGOT() {
        PianoPlayer player = new PianoPlayer().initialize();
        player.playSong(GameOfThrone.songNotes);
    }

    @Test
    public void playCoffinDance() {
        PianoPlayer player = new PianoPlayer().initialize();
        player.playSong(CoffinDance.songNotes);
    }

    @Test
    public void playGolden() {
        PianoPlayer player = new PianoPlayer().initialize();
        player.playSong(Golden.songNotes);
    }
}
