import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class lab7_2 {
    public static void main(String[] args) throws IOException {
        try {
            File f1 = new File("src.txt");
            if (f1.exists()) f1.delete();
            f1.createNewFile();
            Scanner sc = new Scanner(System.in);
            System.out.println("Подсчитать");
            int count = sc.nextInt();
            sc.nextLine();
            RandomAccessFile rf = new RandomAccessFile(f1, "rw");
            for (int i = 0; i < count; i++) {
                System.out.println("Введите имя:");
                String name = sc.next();
                rf.writeUTF(name);
                for (int j = 0; j < 20 - name.length(); j++) {
                    rf.writeByte(1);
                }
                System.out.println("Введите город:");
                String city = sc.next();
                rf.writeUTF(city);
                for (int j = 0; j < 20 - city.length(); j++) {
                    rf.writeByte(1);
                }
                System.out.println("Введите место:");
                int placeNum = sc.nextInt();
                rf.writeInt(placeNum);
                System.out.println("Введите победа:");
                int countWin = sc.nextInt();
                rf.writeInt(countWin);

            }
            System.out.println("Размер файла " + rf.length());
            rf.seek(0);
            for (int i = 0; i < count; i++) {
                rf.seek(i*52);
                String name = rf.readUTF();
                rf.seek(i*52 + 22);
                String city = rf.readUTF();
                rf.seek(i*52 + 44);
                int placeNum = rf.readInt();
                rf.seek(i*52 + 48);
                int countWin = rf.readInt();
                System.out.println("имя = " + name + " город " + city + " место " + placeNum + " победа " + countWin);
            }
        } catch(IOException io) {
            io.printStackTrace();
        }
    }
}