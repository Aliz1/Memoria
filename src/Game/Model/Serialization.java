package Game.Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serialization 
{

    public final boolean userExists(String username)
    {
        File f = new File("users/" + username + ".txt");

        if(f.exists() && !f.isDirectory()) 
        {
            return true;
        } 
        else
        {
            return false;
        }
    }

    public final void writeObject(User user)
    {

            try {
                FileOutputStream fileOut =
                new FileOutputStream("users/" + user.getUserName() + ".txt");
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(user);
                out.close();
                fileOut.close();
                System.out.printf("Serialized data is saved in users/" + user.getUserName() + ".txt");
             } catch (IOException i) {
                i.printStackTrace();
             } 
        
    }

    public final User readObject(String Username)
    {
        User user = null;
        try {
            FileInputStream fileIn = new FileInputStream("users/" + Username + ".txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            user = (User) in.readObject();
            in.close();
            fileIn.close();
         } catch (IOException i) {
            i.printStackTrace();
         } catch (ClassNotFoundException c) {
            System.out.println("User class not found");
            c.printStackTrace();
         }
         
         System.out.println("Deserialized Player...");
         System.out.println("Name: " + user.getUserName());
         System.out.println("Password: " + user.getPassword());

         return user;
    }
   
}
