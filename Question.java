package com.company;

public class Question
{
    static final int Max_no_questions = 6;
    private int Index_of_questions;
    private int Index_of_answers;
    private int Total_Score;
    private String[] questions = new String [Max_no_questions];
    private String[] answers = new String [Max_no_questions];

    Question()
    {
        Index_of_answers = -1;
        Index_of_questions = -1;
    }

    boolean push_questions(String ques_to_push)
    {
        if(Index_of_questions >= (Max_no_questions -1))
        {
            System.out.println("Stack Overflow");
            return false;
        }
        else
        {
            questions[++Index_of_questions] = ques_to_push;
            return true;
        }
    }

    void setTotal_Score(int score_to_set)
    {
        this.Total_Score= score_to_set ;
    }
    public int get_total_score()
    {
        return this.Total_Score;
    }

    boolean push_answers(String answer_to_push)
    {
        if(Index_of_answers >= (Max_no_questions -1))
        {
            System.out.println("Stack Overflow");
            return false;
        }
        else
        {
            answers[++Index_of_answers] = answer_to_push;
            return true;
        }
    }

    public int get_Index_of_questions()
    {
        return this.Index_of_questions;
    }

    public int get_Index_of_answers()
    {
        return Index_of_answers;
    }

    public String getAnswers()
    {
        return answers[Index_of_answers];
    }

    public String getQuestion()
    {
        return questions[Index_of_questions];
    }

    public void EndResult()
    {
        int points = 0;
        int total_points =0;
        for (int i=0;i<=Index_of_answers;i++)
        {

            if (answers[i].equals("a"))
            {
                points = 1;
            }
            else if (answers[i].equals("b"))
            {
                points = 2;
            }
            else if (answers[i].equals("c"))
            {
                points = 3;
            }
            else
            {
                points = 4;
            }
            total_points = total_points+points;
        }
        if (total_points > 0 && total_points <= (1*get_Index_of_questions())+1)
        {
            System.out.println("You are Superman");
            System.out.println("You are strong and smart.You are one of the most powerful superheroes.You brave with a heart of gold and love to save people lives.");
        }
        else if (total_points > (1*get_Index_of_questions())+1 && total_points <= (2*get_Index_of_questions())+1)
        {
            System.out.println("You are Hulk");
            System.out.println("You are big and bulky. You can smash anyone with your powers and size. You become normal human being when you see the person you love.");
        }
        else if (total_points > (2*get_Index_of_questions())+1 && total_points <= (3*get_Index_of_questions())+1)
        {
            System.out.println("You are Spiderman");
            System.out.println("You are the favourite of kids and you're a kid. You never listen to Tony Stark but you follow what's fair for everyone. Your spider-sense and spiderwebs helps you in fighting.");
        }
        else
        {
            System.out.println("You are Aquaman");
            System.out.println("You are god of Water and you can control it. You're eyes are devil and you save all the living-beings in water because you consider them your family.");

        }
        setTotal_Score(total_points);
    }

    public boolean ValidInput(String input)
    {
        if (input.equals("a")) {
            return true;
        }
        else if (input.equals("b")) {
            return true;
        }
        else if (input.equals("c")) {
            return true;
        }
        else if (input.equals("d")) {
            return true;
        }
        else {
            return false;
        }
    }
}

