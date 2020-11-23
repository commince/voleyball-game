package volley;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInput {
    static final UserInput userInput = new UserInput();

    public void makeTry() {
        userInput.getUserInput("нажмите Enter");
    }

    public String userTeamName(int numOfTeam) {
        return userInput.getUserInput("Введите название " + numOfTeam + "-й команды: ");
    }

    public String userTeamName() {
        return userInput.getUserInput("Введите название ранее загруженной в базу данных команды: ");
    }


    public String userPlayerName(int numOfPlayer) {
        return userInput.getUserInput("Введите имя " + numOfPlayer + "-го игрока");
    }

    public double userSkills(String skill, int numOfPlayer) {
        return Double.parseDouble(userInput.getUserInput("Введите скил " + skill + " " + numOfPlayer + "-го игрока в формате от 0 до 1 (х.хх): "));
    }

    public String creationMethod(String subject) {
        return userInput.getUserInput("Желаете автоматического создания" + subject + "? Введите 'y' или 'n' и нажмите Enter:");
    }

    public Boolean askForSave() {
        if (userInput.getUserInput("Желаете сохранить созданную команду? Введите 'y' или 'n' и нажмите Enter:").equals("y")) {
            return true;
        } else {
            return false;
        }
    }

    public String getUserInput(String prompt) {
        String inputLine = null;
        System.out.print(prompt + " ");
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine.length() == 0) return null;

        } catch (IOException e) {
            System.out.println("IOException " + e);
        }
        return inputLine;
    }
}

