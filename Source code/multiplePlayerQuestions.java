/**
 * Write a description of class multiplePlayerQuestions here.
 * 
 * @author Gaurang
 * @version 1.0
 */

import java.util.*;
public class multiplePlayerQuestions implements GameLevel 
{
    
    ArrayList<Question> questions;

    /**
     * Constructor for objects of class multiplePlayerQuestions
     */
    public multiplePlayerQuestions()
    {
        questions = new ArrayList<Question>();
        loadQuestions();
    }

    public void loadQuestions()
     {
               
        
       String questionText2 = "In cryptography, what is cipher? ";
        
        ArrayList<Answer> answers2 = new ArrayList<Answer>();
        answers2.add(new Answer("algorithm for performing encryption", true));
        answers2.add(new Answer("encrypted message", false));
        answers2.add(new Answer("both (a) and (b)", false));
        answers2.add(new Answer("none of the mentioned", false));
        Collections.shuffle(answers2);
        Question question2 = new Question(questionText2, answers2);
        String explanation2 = "Some ciphers work by simply realigning the alphabet ";
        explanation2 += "(for example, A is represented by F, B is represented by G,";
        explanation2 += " and so forth) or otherwise manipulating the text in some ";
        explanation2 += "consistent pattern. However, almost all serious  ciphers use  ";
        explanation2 += "both a key (a variable that is combined in some way with ";
        explanation2 += "unencrypted text) and an algorithm  ";
        explanation2 += "(a formula for combining the key with the text). ";
        question2.setExplanation(explanation2);
        
        questions.add(question2);
        
        String questionText3 = "In asymmetric key cryptography, the private key is kept by";
        ArrayList<Answer> answers3 = new ArrayList<Answer>();
        answers3.add(new Answer("sender", false));
        answers3.add(new Answer("receiver", true));
        answers3.add(new Answer("sender and receiver", false));
        answers3.add(new Answer("all the connected devices to the network", false));
        Collections.shuffle(answers3);
        Question question3 = new Question(questionText3, answers3);
        String explanation3 = "private key is always kept by the receiver ";
       
        question3.setExplanation(explanation3);
        questions.add(question3);
        
        String questionText4 = "who all can have access to public key";
        ArrayList<Answer> answers4 = new ArrayList<Answer>();
        answers4.add(new Answer("sender", false));
        answers4.add(new Answer("receiver", false));
        answers4.add(new Answer("sender and receiver", false));
        answers4.add(new Answer("anyone who wants to communicate", true));
        Collections.shuffle(answers4);
        Question question4 = new Question(questionText4, answers4);
        String explanation4 = "TPublic key is open lock. Everyone in the network ";
        explanation4 += "can have this public key  If you want sent a message to ";

                explanation4 += "the client you will get one from client.";
        question4.setExplanation(explanation4);
        questions.add(question4);
        
        
        
        String questionText6 = " In symmetric key cryptography, key used by sender and receiver is";
        ArrayList<Answer> answers6 = new ArrayList<Answer>();
        answers6.add(new Answer("shared", true));
        answers6.add(new Answer("different", false));
        answers6.add(new Answer("two keys are used", false));
        answers6.add(new Answer("None", false));
        Collections.shuffle(answers6);
        Question question6 = new Question(questionText6, answers6);
        String explanation6 = "Both keys are same. So it is shared";
        explanation6 += "This makes the network vulnerable cause someone can easily eavesdrop";
        question6.setExplanation(explanation6);
        questions.add(question6);
        
        String questionText7 = "In asymmetric-key cryptography, key locks and unlocks box is";
        ArrayList<Answer> answers7 = new ArrayList<Answer>();
        answers7.add(new Answer("same", false));
        answers7.add(new Answer("shared", false));
        answers7.add(new Answer("private", true));
        Collections.shuffle(answers7);
        Question question7 = new Question(questionText7, answers7);
        String explanation7 = "I allowed two answers for this one - again you used to be ";
        explanation7 += "able to eons ago, but it was considered  such bad practice it was removed. ";
         explanation7 += "It's still a reserved word however - it just doesn't do anything!";
        question7.setExplanation(explanation7);
        questions.add(question7);
     }
     public ArrayList<Question> getQuestion()
     {
         return questions;
     }
}
