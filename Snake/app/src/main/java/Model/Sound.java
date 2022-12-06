package Model;

import java.net.URISyntaxException;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Sound {
    private Media bkMusic;
    private MediaPlayer bkAudio;
    private AudioClip biteSoundFX;
    private AudioClip endGameFX;

    public Sound() throws URISyntaxException {
        bkMusic = new Media(getClass().getResource("/audio/BackgroundMusic.mp3").toURI().toString());
        bkAudio = new MediaPlayer(bkMusic);

        biteSoundFX = new AudioClip(getClass().getResource("/audio/Bite.mp3").toURI().toString());
        biteSoundFX.setRate(3);

        endGameFX = new AudioClip(getClass().getResource("/audio/EndGame.mp3").toURI().toString());
        endGameFX.setVolume(0.8);
    }

    public MediaPlayer getBkMusic() {
        return this.bkAudio;
    }

    public AudioClip getBiteSound() {
        return this.biteSoundFX;
    }

    public AudioClip getEndSound() {
        return this.endGameFX;
    }
}
