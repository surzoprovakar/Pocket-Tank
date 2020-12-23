/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pocket;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author Raju
 */
public class Sound {

    public Sound() throws FileNotFoundException, IOException {
        String gongFile = "tank.wav";
        InputStream in = new FileInputStream(gongFile);

        AudioStream audioStream = new AudioStream(in);

        AudioPlayer.player.start(audioStream);
    }


}
