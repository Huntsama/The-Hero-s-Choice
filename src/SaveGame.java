import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SaveGame {
    public void saveGame(GameLogic game) throws Exception{
        try{
            File f = new File("src/save.txt");
            f.createNewFile();

            FileOutputStream file = new FileOutputStream(f);
            ObjectOutputStream objectFile = new ObjectOutputStream(file);

            objectFile.writeObject(game);

            file.close();
            objectFile.close();
        }catch (Exception e){
            throw new Exception("SaveGame class error: " + e.getMessage());
        }
    }
}
