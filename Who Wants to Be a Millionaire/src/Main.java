import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Question[] questions = {
                new Question("Who is the current President of the United States of America?", 1, "John F. Kennedy", "George Bush", "Barrack Obama", "Donald Trump" ),
                new Question("How many provinces are there in Canada", 1, "10", "12", "13", "8")
        };


        while(true) {
            flush();
            System.out.println("Welcome to Who Wants to Be a Millionaire!");
            System.out.println("You will have to answer a series of multiple choice questions. If you get a question wrong, you lose. If you get all of them right, you win and walk away with a million dollars.");
            pause();


            boolean answerWrong = false;
            for (int q = 0; q < questions.length && !answerWrong; q++) {
                boolean incorrectResponse = true;
                while (incorrectResponse) {
                    flush();
                    System.out.println(Integer.toString(q + 1) + ". " + questions[q].question);
                    System.out.println();
                    for (int a = 0; a < questions[q].answers.length; a++) {
                        System.out.println(Integer.toString(a + 1) + ". " + questions[q].answers[a]);
                    }
                    Scanner s = new Scanner(System.in);
                    int answer = -1;
                    try {
                        answer = Integer.parseInt(s.nextLine());
                        incorrectResponse = answer < 1 || answer > questions[q].answers.length;
                    } catch (Exception ignored) {
                        incorrectResponse = true;
                    }

                    answerWrong = (!incorrectResponse && answer == questions[q].correctAnswer);
                }
            }

            if (answerWrong) {
                System.out.println("You have lost... Better luck next time.");
                pause();
                flush();
            } else {
                System.out.println("Congratulations... You have won!");
                pause();
                flush();
            }
        }
    }

    private static void flush() {
        for (int i = 0; i < 15; i++) {
            System.out.println();
        }
    }

    private static void pause() {
        System.out.println();
        System.out.println("Please press enter to continue...");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }


    static class Question {
        String question;
        String[] answers;
        int correctAnswer;

        Question(String question, int correctAnswer, String... answers) {
            this.question = question;
            this.answers = answers;
            this.correctAnswer = correctAnswer;
        }
    }
}
