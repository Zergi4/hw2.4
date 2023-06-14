
public class Main {


    public static void main(String[] args) {

        try {
            checkLogin("bb");
        } catch (WrongLoginException e) {
            System.out.println(e.getMessage());
        }
        try {
            checkPassword("bb33333333333", "bb33333333333");
        } catch (WrongPasswordException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void checkLogin(String login) throws WrongLoginException {
        // проверка на длину логина
        if (login.length() > 20) {
            throw new WrongLoginException("Ошибка! Превышена длина логина");
        }
        //проверка на корректность логина
        char[] loginToChar = login.toCharArray();
        boolean trueCheck = true;
        for (int i = 0; i < loginToChar.length; i++) {
            if (trueCheck) {
                for (int j = 0; j < allowedChars.length; j++) {
                    if ((loginToChar[i] == allowedChars[j])) {
                        trueCheck = true;
                        break;
                    } else trueCheck = false;
                }
            }
            if (!trueCheck) {
                throw new WrongLoginException("Символы логина не корректны");
            }
        }
    }

    //проверка пароля
    public static void checkPassword(String password, String confirmPassword) throws WrongPasswordException {
        // проверка на длину пароля
        if (password.length() > 20) {
            throw new WrongPasswordException("Ошибка! Превышена длина пароля");
        }
        //проверка на корректность пароля
        char[] passwordToChar = password.toCharArray();
        boolean trueCheck = true;
        for (int i = 0; i < passwordToChar.length; i++) {
            if (trueCheck) {
                for (int j = 0; j < allowedChars.length; j++) {
                    if (passwordToChar[i] == allowedChars[j]) {
                        trueCheck = true;
                        break;
                    } else trueCheck = false;
                }
            }
            if (!trueCheck) {
                throw new WrongPasswordException("Символы пароля не корректны");
            }
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают");
        }
    }

    public static char[] allowedChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_".toCharArray();
}
