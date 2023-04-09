import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Pila {

    private Nodo Testa;

    public Pila() {
        Testa = null;
    }

    public Nodo getTesta() {
        return Testa;
    }

    public void setTesta(Nodo testa) {
        Testa = testa;
    }

    public void svuotaPila() {
        Testa = null;

        System.out.println("\nLa pila è stata svuotata");
    }

    public void pop() {

        if (Testa == null) {
            System.out.println("\nLa pila è vuota");
        } else {
            Testa = Testa.successivo;
        }

    }

    public void push(int elemento) {

        Nodo nuovo = new Nodo();
        nuovo.elemento = elemento;
        nuovo.successivo = Testa;

        Testa = nuovo;
    }

    public void scriviPila() {

        System.out.println("\nTesta Pila");
        Nodo appoggio = Testa;

        while (appoggio != null) {
            System.out.println(appoggio.elemento);
            appoggio = appoggio.successivo;
        }

        System.out.println("Base Pila");

    }

    public void distruggiPila() {

        while (Testa != null) {
            pop();
        }

        System.out.println("\nLa pila è stata distrutta");

        try {
            File file = new File("src/audio.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            Thread.sleep(clip.getMicrosecondLength()/1000);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}
