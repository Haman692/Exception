import java.io.*;
import java.io.File;
import java.util.Scanner;

class FileNotFoundException extends Exception {
    public FileNotFoundException(String message) {
        super(message);
    }
}

public class FileManager {
    public static boolean FindFile(File file) throws FileNotFoundException {
        File folder = new File(file.getPath());
        File[] files = folder.listFiles();
        for (File file1 : files) {
            if (file1.getName().equals(file.getName())) {
                return true;
            }
        }
        throw new FileNotFoundException("Не найден файл");
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Введите путь до файла");
        String path = s.nextLine();
        System.out.println("Введите имя файла");
        String name = s.nextLine();
        File file = new File(name, path);
        try {
            FindFile(file);
            System.out.println("Файл найден");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println("1.Прочитать файл\n2.Записать новую информацию");
        int flag = s.nextInt();
        if (flag == 1) {
            ReadFile(file);
        }
        if (flag == 2){
            WriteFile(file);
        }
    }

    private static void WriteFile(File file) {
        try(FileWriter writer = new FileWriter(file.getName(), false))
        {
            Scanner s = new Scanner(System.in);
            String text = s.nextLine();
            writer.write(text);
            writer.flush();
        }
        catch(IOException ex){
            System.out.println("Ошибка запичи");
        }
    }

    private static void ReadFile(File file) {
        try (FileReader reader = new FileReader(file.getName())) {            
            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException ex) {
            System.out.println("Ошибка чтения");
        }
    }
}



