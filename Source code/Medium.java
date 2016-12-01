import java.util.*;
/**
 * Write a description of class Easy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Medium implements GameLevel 
{
     ArrayList<Question> questions;
     public Medium()
     {
         questions = new ArrayList<Question>();
        
        //-------
        questions = new ArrayList<Question>();
         String questionText = "A Binary Search Tree (BST) is a type of which data structure?";
        ArrayList<Answer> answers = new ArrayList<Answer>();
        answers.add(new Answer("Graph", false));
        answers.add(new Answer("Tree", true));
        answers.add(new Answer("Circle", false));
        answers.add(new Answer("Square", false));
        Collections.shuffle(answers);
        Question question = new Question(questionText, answers);
        String explanation = "A Binary Search Tree (BST) is a tree in which all the nodes follow the below-mentioned properties − ";
        explanation += "The left sub-tree of a node has a key less than or equal to its parent node's key. ";
        explanation += "The right sub-tree of a node has a key greater than or equal to its parent node's key.";
        
        question.setExplanation(explanation);
        questions.add(question);
        //-------
        // String questionText = "?";
        // ArrayList<Answer> answers = new ArrayList<Answer>();
        // answers.add(new Answer("01234", false));
        // answers.add(new Answer("Error", false));
        // answers.add(new Answer("668", true));
        // answers.add(new Answer("1234", false));
        // Collections.shuffle(answers);
        // Question question = new Question(questionText, answers);
        // String explanation = "You may be rather baffled with this concept - the answer 668 seems completely illogical. ";
        // explanation += "However - there is method to this madness. If you start an integer with 0 in Java, Java will ";
        // explanation += "read that integer as an octal number. Since the decimal representation of the octal number 1234 ";
        // explanation += "is 668, this is what will be printed out. In the same way, you can also write integers in ";
        // explanation += "hexadecimal by prefixing the integer with \"0x\".";
        // question.setExplanation(explanation);
        // questions.add(question);
        
        String questionText2 = "Which is not a Basic operation of a tree? ";
        questionText2 += "there's the following line: \"{}{}{}{}{}{}{}{}{}{}{}{}{}{}\" (no speech marks.) What's the ";
        questionText2 += "effect of this line on the code?";
        ArrayList<Answer> answers2 = new ArrayList<Answer>();
        answers2.add(new Answer("Search", false));
        answers2.add(new Answer("Insert", false));
        answers2.add(new Answer(" Eat ", true));
        answers2.add(new Answer("Traversal", false));
        Collections.shuffle(answers2);
        Question question2 = new Question(questionText2, answers2);
        String explanation2 = "Following are the basic operations of a tree − ";
        explanation2 += "Search − Searches an element in a tree";
        explanation2 += "in the order they appear in your code before each constructor. Having multiple ones is generally ";
        explanation2 += "Insert − Inserts an element in a tree. ";
        explanation2 += "Pre-order Traversal − Traverses a tree in a pre-order manner. ";
        explanation2 += "In-order Traversal − Traverses a tree in an in-order manner.";
                explanation2 += "Post-order Traversal − Traverses a tree in a post-order manner.";
        question2.setExplanation(explanation2);
        questions.add(question2);
        
        String questionText3 = "Whenever an element is to be searched, start searching from the root node";
        ArrayList<Answer> answers3 = new ArrayList<Answer>();
        answers3.add(new Answer("true", true));
        answers3.add(new Answer("false", false));
       
        Collections.shuffle(answers3);
        Question question3 = new Question(questionText3, answers3);
        String explanation3 = "Whenever an element is to be searched, start searching from the root node ";
        explanation3 += "Then if the data is less than the key value, search for the element in the left subtree ";
        explanation3 += "Otherwise, search for the element in the right subtree. Follow the same algorithm for each node.";
        question3.setExplanation(explanation3);
        questions.add(question3);
        
        String questionText4 = "Whenever an element is to be inserted, first locate its proper location";
        ArrayList<Answer> answers4 = new ArrayList<Answer>();
        answers4.add(new Answer("True", true));
        answers4.add(new Answer("False", false));

        Collections.shuffle(answers4);
        Question question4 = new Question(questionText4, answers4);
        String explanation4 = "Whenever an element is to be inserted, first locate its proper location";
        explanation4 += "Start searching from the root node, then if the data is less than the key value,";
        explanation4 += "search for the empty location in the left subtree and insert the data";
                explanation4 += "Otherwise, search for the empty location in the right subtree and insert the data.";
        question4.setExplanation(explanation4);
        questions.add(question4);
        
        String questionText5 = " Which search technique is faster?";
        ArrayList<Answer> answers5 = new ArrayList<Answer>();
        answers5.add(new Answer(" Linear search", true));
        answers5.add(new Answer("Binary search", false));
        Collections.shuffle(answers5);
        Question question5 = new Question(questionText5, answers5);
        String explanation5 = "The Binary Search is much more efficient than the linear search, ";
        explanation5 += " but we must pay initially to sort the array. ";
        question5.setExplanation(explanation5);
        questions.add(question5);
        
       
     }
     public ArrayList<Question> getQuestion()
     {
         return questions;
     }
}
