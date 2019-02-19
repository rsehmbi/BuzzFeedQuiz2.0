package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class QuestionTest
{
    @Test
    public void test_question_class()
    {
        Question Q1= new Question();
        assertEquals(-1,Q1.get_Index_of_questions());
        assertEquals(-1,Q1.get_Index_of_answers());
    }
    @Test
    public void testPush_questions()
    {
        Question Q1 = new Question();
        assertEquals(true,Q1.push_questions("Hello World"));
    }
    @Test
    public void testSet_Total_Score()
    {
        Question Ques = new Question();
        Ques.setTotal_Score(10);
        assertEquals(10,Ques.get_total_score());
    }
    @Test
    public void testGet_Total_Score()
    {
        Question Ques = new Question();
        Ques.setTotal_Score(100);
        assertEquals(100,Ques.get_total_score());
    }
    @Test
    public void testPush_answers()
    {
        Question Q1 = new Question();
        assertEquals(true,Q1.push_questions("HELLO TEST CLASS"));
    }
    @Test
    public void test_GetIndex_of_questions()
    {
        Question Q1= new Question();
        Q1.push_questions("HELLO TEST CLASS");
        assertEquals(0,Q1.get_Index_of_questions());
    }
    @Test
    public void test_Get_Index_of_answers()
    {
        Question Q1= new Question();
        Q1.push_answers("a");
        assertEquals(0,Q1.get_Index_of_answers());
    }
    @Test
    public void test_Get_Answers()
    {
        Question Q1= new Question();
        Q1.push_answers("d");
        assertEquals("d",Q1.getAnswers());
    }
    @Test
    public void test_Get_Question()
    {
        Question Ques = new Question();
        Ques.push_questions("How many days are there in a leap year ?");
        Ques.push_questions("How many months make a year ?");
        assertEquals("How many months make a year ?",Ques.getQuestion());
    }
    @Test
    public void test_End_Result()
    {
        Question Ques = new Question();
        Question Ques2 = new Question();
        Question Ques3 = new Question();
        Question Ques4 = new Question();
        for (int itr =0 ; itr <= 4 ; itr++)
        {
            Ques.push_questions("Q1. Which superpower you love the most ?");
            Ques2.push_questions("Q2. Physical Appearance ?");
            Ques3.push_questions("Q3. What is your favourite costume color?");
            Ques4.push_questions("Q4. Whom you want to live with ?");
            Ques.push_answers("a");
            Ques3.push_answers("b");
            Ques4.push_answers("d");
        }
        Ques.EndResult();
        //TESTING QUESTION 2 WITH DIFFERENT TO GET DIFFERENT SCORE
        Ques2.push_answers("b");
        Ques2.push_answers("a");
        Ques2.push_answers("a");
        Ques2.push_answers("a");
        Ques2.push_answers("c");
        Ques2.EndResult();
        Ques3.EndResult();
        Ques4.EndResult();
        assertEquals(5, Ques.get_total_score());
        assertEquals(8, Ques2.get_total_score());
        assertEquals(10, Ques3.get_total_score());
        assertEquals(20, Ques4.get_total_score());

    }
    @Test
    public void test_Valid_Input()
    {
        Question Q1 = new Question();
        assertEquals(true,Q1.ValidInput("a"));
        assertEquals(true,Q1.ValidInput("b"));
        assertEquals(true,Q1.ValidInput("c"));
        assertEquals(true,Q1.ValidInput("d"));
        assertEquals(false,Q1.ValidInput("e"));
        assertEquals(false,Q1.ValidInput("f"));

    }
    @Test
    public void test_Overflow_Case_of_push_question()
    {
        Question Ques = new Question();
        for(int itr =0 ; itr<= 5 ; itr++)
        {
            Ques.push_questions("Q1. Which superpower you love the most ?");
        }
        assertEquals(false,Ques.push_questions("This will cause overflow"));

    }
    @Test
    public void test_Overflow_Case_of_push_answers()
    {
        Question Ques = new Question();
        for (int itr = 0; itr <= 5 ; itr++)
        {
            Ques.push_answers("a");
        }
        assertEquals(false,Ques.push_answers("a"));

    }
}