# Selenide Piano Player

A project that automates playing songs on the **Online Pianist Virtual Piano** using **Java + Selenide**. It simulates piano key presses via Selenide actions to play melodies in the browser.

---

## 📁 Project Structure

```
selenide-piano-player/
│
├── src/
│ ├── main/
│ │ └── java/com/youvegotnigel/automation/
│ │ ├── songs/
│ │ │ ├── CoffinDance.java
│ │ │ ├── GameOfThrone.java
│ │ │ └── HappyBirthday.java
│ │ └── utils/
│ │ ├── KeyInfo.java
│ │ ├── PianoPlayer.java
│ │ ├── SongNote.java
│ │ └── Stanza.java
│ └── test/
│ └── java/com/youvegotnigel/automation/
│ └── PlaySongTest.java
├── pom.xml
├── .gitignore
└── README.md

```

---

## 🚀 How It Works

1. **Test Methods** in `PlaySongTest` call the `PianoPlayer` to open the virtual piano URL and play the song.
2. **`PianoPlayer.initialize()`** launches the browser and navigates to the virtual piano page.
3. **Song Classes** (`HappyBirthday`, `GameOfThrone`, `CoffinDance`) define sequences of `SongNote` with durations.
4. `PianoPlayer.playSong(...)` navigates the canvas keys and triggers click-and-hold / release actions with appropriate delays.

---

## 🧪 Example Test Code

```java
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
```

## Run All Tests
```bash
mvn clean test
```

## Run a Single Test
```bash
mvn -Dtest=PlaySongTest#playCoffinDance test
```

## Headless Mode (no GUI)

```bash
mvn test -Dselenide.headless=true
```
