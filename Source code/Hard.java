import java.util.*;
/**
 * Write a description of class Easy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hard implements GameLevel 
{
     ArrayList<Question> questions;
     
        public Hard()
     {
        questions = new ArrayList<Question>();
        loadQuestions();
     }
     
     public void loadQuestions()
     {
         
       
               String questionText = "1) What is the complexity of selection sort?";
        ArrayList<Answer> answers = new ArrayList<Answer>();
        answers.add(new Answer("O(n^2) ", true));
        answers.add(new Answer("O(n)", false));
        answers.add(new Answer("O(log n)",false));
        
        Collections.shuffle(answers);
        Question question = new Question(questionText, answers);
        String explanation = "Complexity of selection sort is O(n^2). ";
       
        question.setExplanation(explanation);
        questions.add(question);
        
        String questionText2 = "Why sorting is done?";
      
        ArrayList<Answer> answers2 = new ArrayList<Answer>();
        answers2.add(new Answer("To arrange elements", false));
        answers2.add(new Answer("To search elementsl", true));
        answers2.add(new Answer("Both of these", false));
 
        Collections.shuffle(answers2);
        Question question2 = new Question(questionText2, answers2);
        String explanation2 = "So what's going on here? Well, you can have as many \"empty\" blocks as you like in your code, ";
        explanation2 += "and these are called instantiation blocks. They're rarely used, but if present they're executed ";
        explanation2 += "in the order they appear in your code before each constructor. Having multiple ones is generally ";
        explanation2 += "silly, but if you've got a block of code that you only want to execute before each constructor, ";
        explanation2 += "this is where they can be used. Of course, you could just use a private method that's called ";
        explanation2 += "before each constructor instead.";
        question2.setExplanation(explanation2);
        questions.add(question2);
        
        String questionText3 = "What is the easiest way to sort?";
        ArrayList<Answer> answers3 = new ArrayList<Answer>();
        answers3.add(new Answer("Selection sort", true));
        answers3.add(new Answer("Dumb sort", false));
        answers3.add(new Answer("No sort", false));

        Collections.shuffle(answers3);
        Question question3 = new Question(questionText3, answers3);
        String explanation3 = "Only selection sort of the 3 options is a standard sorting method.";
       
        question3.setExplanation(explanation3);
        questions.add(question3);
        
        String questionText4 = "Which element is compared first in selection sort?";
        ArrayList<Answer> answers4 = new ArrayList<Answer>();
        answers4.add(new Answer("First", true));
        answers4.add(new Answer("Last", false));
        answers4.add(new Answer("Middle", false));
        Collections.shuffle(answers4);
        Question question4 = new Question(questionText4, answers4);
        String explanation4 = "First element is compared first in selection sort and then one by one other elements are compared. ";
       
        question4.setExplanation(explanation4);
        questions.add(question4);
        
        String questionText5 = "How many passes/scans will go through a list of 10 elements?";
        ArrayList<Answer> answers5 = new ArrayList<Answer>();
        answers5.add(new Answer("10", false));
        answers5.add(new Answer("20", false));
                answers5.add(new Answer("9", true));        answers5.add(new Answer("34", false));
        Collections.shuffle(answers5);
        Question question5 = new Question(questionText5, answers5);
        String explanation5 = "Selection sort happens (n-1) times and in this case n=10, hence the scan will happen 9 times.";
      
        question5.setExplanation(explanation5);
        questions.add(question5);

        
     }
     public ArrayList<Question> getQuestion()
     {
         return questions;
     }
}
