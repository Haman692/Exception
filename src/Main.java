import java.util.Scanner;


class PasswordVerifier extends Exception {
    public PasswordVerifier(String message) {
        super(message);
    }
}

public class Main {
    /**
     * Веритификация пароля
     *
     * @param password Пароль должен быть не менее 8 символов.
     *                 Пароль должен содержать хотя бы одну цифру.
     *                 Пароль должен содержать хотя бы одну заглавную букву.
     *                 Метод должен выбрасывать исключение, если пароль не соответствует какому-либо из этих правил.
     * @return true or false
     * @throws PasswordVerifier exception
     */
    public static boolean PassVer(String password) throws PasswordVerifier {
        if     (password.length() < 9 ||
                NumInPuss(password) ||
                password.equals(password.toLowerCase())) {
            throw new PasswordVerifier("Не подходящий пароль");
        }
        return true;
    }

    /**
     * Проверка числа в String
     * @param password пароль
     * @return true of false
     */
    public static boolean NumInPuss(String password) {
        boolean flag = false;
        for (int i = 0; i < 10; i++) {
            if (password.indexOf(i) != -1) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        System.out.println("Введите пароль");
        Scanner s = new Scanner(System.in);
        String password = s.nextLine();
        try {
            PassVer(password);
            System.out.println("Пароль принят");
        } catch (PasswordVerifier e) {
            throw new RuntimeException(e);
        }
    }
}