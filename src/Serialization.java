import java.io.*;
import java.util.Scanner;

public class Serialization {
    public static void main(String[] args) throws IOException {
        FileOutputStream fout = null;
        ObjectOutputStream oos = null;
        try {
            Scanner sc = new Scanner(System.in);
            File f = new File("teams.txt");
            f.createNewFile();
            fout = new FileOutputStream(f);
            oos = new ObjectOutputStream(fout);
            System.out.println("Введите количество команд");
            int count = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < count; i++) {
                Team team = new Team();
                System.out.println("имя");
                team.name = sc.nextLine();
                System.out.println("город");
                team.city = sc.nextLine();
                System.out.println("место");
                team.placeInLeague = sc.nextInt();
                System.out.println("победы");
                team.placeInLeague = sc.nextInt();
                sc.nextLine();
                oos.writeObject(team);
            }
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream oin = new ObjectInputStream(fis);
            Team teamWrite = null;
            for (int i = 0; i < count; i++) {
                teamWrite = (Team)oin.readObject();
                System.out.println(teamWrite);
            }
        }
        catch (IOException io) {
            io.printStackTrace();
        }
        catch (ClassNotFoundException ce){
            ce.printStackTrace();
        }
        finally {
            oos.close();
            fout.flush();
            fout.close();
            oos.close();
        }
    }
}
