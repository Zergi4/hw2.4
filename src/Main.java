
public class Main {


    public static void main(String[] args) {
        //   method("ksyssauksyssauksyssau", "k", "y");
        try {
            checkLogin("bb*");
        } catch (WrongLoginException e) {
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
                    if (loginToChar[i] == allowedChars[j]) {
                        trueCheck = true;
                        break;
                    } else trueCheck = false;
                    System.out.println(trueCheck);
                }
            }
            if (!trueCheck) {
                throw new WrongLoginException("Символы не корректны");
            }
        }
    }

    public static char[] allowedChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_".toCharArray();
}
