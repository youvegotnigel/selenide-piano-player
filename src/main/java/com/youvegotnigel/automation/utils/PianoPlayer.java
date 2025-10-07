package com.youvegotnigel.automation.utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import static com.codeborne.selenide.Selenide.*;

public class PianoPlayer {

    private static final String BASE_URL = "https://www.onlinepianist.com";
    private static final SelenideElement CANVAS = $("canvas");

    private static final Map<String, KeyInfo> KEYBOARD_KEY_INFO;

    static {
        KEYBOARD_KEY_INFO = new HashMap<String, KeyInfo>() {{
            put("a0", new KeyInfo(23, "c"));
            put("a0#", new KeyInfo(34, "f"));
            put("b0", new KeyInfo(25, "v"));

            put("c", new KeyInfo(26, "i"));
            put("c#", new KeyInfo(27, "9"));
            put("d", new KeyInfo(28, "o"));
            put("d#", new KeyInfo(29, "0"));
            put("e", new KeyInfo(30, "p"));
            put("f", new KeyInfo(31, "z"));
            put("f#", new KeyInfo(32, "s"));
            put("g", new KeyInfo(33, "x"));
            put("g#", new KeyInfo(34, "d"));
            put("a", new KeyInfo(35, "y"));
            put("a#", new KeyInfo(36, "7"));
            put("b", new KeyInfo(37, "u"));

            put("c1", new KeyInfo(38, "b"));
            put("c1#", new KeyInfo(39, "h"));
            put("d1", new KeyInfo(40, "n"));
            put("d1#", new KeyInfo(41, "j"));
            put("e1", new KeyInfo(42, "m"));
            put("f1", new KeyInfo(43, ","));
            put("f1#", new KeyInfo(44, "l"));
            put("g1", new KeyInfo(45, "."));
            put("g1#", new KeyInfo(46, ";"));
            put("a1", new KeyInfo(47, "c"));
            put("a1#", new KeyInfo(48, "f"));
            put("b1", new KeyInfo(49, "v"));
        }};
    }


    public PianoPlayer initialize() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-ads");
        options.addArguments("--blink-settings=imagesEnabled=false"); // if ads are images

        //Configuration.browserCapabilities = options;
        Configuration.browser = "chrome";
        Configuration.pageLoadTimeout = 60 * 1000L;
        Configuration.timeout = 30 * 1000L;
        Configuration.browserSize = "1350x900";
        Configuration.baseUrl = BASE_URL;

        open("/virtual-piano");

        java.util.logging.Logger.getLogger("org.openqa").setLevel(Level.OFF);
        return this;
    }


    public void playSong(List<Stanza> songStanzaList) {
        for (Stanza stanza : songStanzaList) {
            for (int i = 0; i < stanza.getLoopCount(); i++) {
                for (SongNote note : stanza.getSongNotes()) {
                    for (int j = 0; j < note.getLoopCount(); j++) {
                        System.out.println("Current note is " + note.getKeyName());
                        keyPress(KEYBOARD_KEY_INFO.get(note.getKeyName()), note.getReleaseTime());
                    }
                }
            }
        }
    }

    private void keyPress(KeyInfo keyInfo, Integer keyReleaseDelay) {
        int y = 20;
        int canvasStartPoint = -678;
        int keyWidth = 22;
        int x = canvasStartPoint + (keyInfo.getPosition() * keyWidth);

        // Move to element with offset and press
        actions().moveToElement(CANVAS, x, y).clickAndHold().perform();

        if (keyReleaseDelay > 0) {
            sleep(keyReleaseDelay);
        }

        // Release click
        actions().moveToElement(CANVAS, x, y).release().perform();
    }

}
