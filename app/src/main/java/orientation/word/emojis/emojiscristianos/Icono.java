package orientation.word.emojis.emojiscristianos;

/**
 * Created by julio on 23/02/18.
 */

public class Icono {


    private int imageId;
    private String emocion;
    public Icono(String emocion,int imageId)
    {
        this.emocion=emocion;
        this.imageId=imageId;
    }

    public int getImageId() {
        return imageId;
    }

    public String getEmocion() {
        return emocion;
    }
}
