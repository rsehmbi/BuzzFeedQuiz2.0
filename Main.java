package com.company;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import static com.sun.tools.doclint.Entity.or;

public class Main {

    public static void main(String[] args)
    {
        startQuiz();
    }
    public static boolean startQuiz()
    {
        Question Ques = new Question();
        Scanner input = new Scanner(System.in);
        {
            try (BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    if(line.contains("?")|| line.contains(":"))
                    {
                        Ques.push_questions(line);
                    }
                    System.out.println(line);
                    if  (line.contains("d)"))
                    {
                        String answer = input.nextLine();
                        while (!Ques.ValidInput(answer))
                        {
                            answer = input.nextLine();
                            System.out.println("Please Enter a or b or c or d only!");
                        }
                        Ques.push_answers(answer);
                    }
                }
            } catch (IOException exp) {
                exp.printStackTrace();
            }
        }
        Ques.EndResult();
        return true;
    }
}
