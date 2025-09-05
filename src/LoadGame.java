import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class LoadGame {
    public GameLogic loadGame(){
       File f = new File("src/save.txt");
       if(f.exists()){
           try{
               FileInputStream file = new FileInputStream(f);
               ObjectInputStream objectFile = new ObjectInputStream(file);

               GameLogic gameLogic = (GameLogic) objectFile.readObject();

               file.close();
               objectFile.close();
               return gameLogic;
           }catch (Exception e){
               System.out.println("Error loading game: " + e.getMessage());
           }
       }
       return null;
    }
}
