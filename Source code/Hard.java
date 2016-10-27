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
        
        //-------
        String questionText = "What would \"System.out.println(01234);\" output?";
        ArrayList<Answer> answers = new ArrayList<Answer>();
        answers.add(new Answer("01234", false));
        answers.add(new Answer("Error", false));
        answers.add(new Answer("668", true));
        answers.add(new Answer("1234", false));
        Collections.shuffle(answers);
        Question question = new Question(questionText, answers);
        String explanation = "You may be rather baffled with this concept - the answer 668 seems completely illogical. ";
        explanation += "However - there is method to this madness. If you start an integer with 0 in Java, Java will ";
        explanation += "read that integer as an octal number. Since the decimal representation of the octal number 1234 ";
        explanation += "is 668, this is what will be printed out. In the same way, you can also write integers in ";
        explanation += "hexadecimal by prefixing the integer with \"0x\".";
        question.setExplanation(explanation);
        questions.add(question);
        
        String questionText2 = "Just before the end of a class (before the class closes but after all the methods) ";
        questionText2 += "there's the following line: \"{}{}{}{}{}{}{}{}{}{}{}{}{}{}\" (no speech marks.) What's the ";
        questionText2 += "effect of this line on the code?";
        ArrayList<Answer> answers2 = new ArrayList<Answer>();
        answers2.add(new Answer("It doesn't compile", false));
        answers2.add(new Answer("Nothing at all", true));
        answers2.add(new Answer("It slows the code down", false));
        answers2.add(new Answer("It allows you to debug more easily", false));
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
        
        String questionText3 = "If an element in Java code is given the \"protected\" visibility modifier, then what can access it?";
        ArrayList<Answer> answers3 = new ArrayList<Answer>();
        answers3.add(new Answer("Classes in the same package and in the same inheritence hierachy", true));
        answers3.add(new Answer("Nothing at all", false));
        answers3.add(new Answer("Only classes in the same package", false));
        answers3.add(new Answer("Only classes in the same inheritence hierachy", false));
        Collections.shuffle(answers3);
        Question question3 = new Question(questionText3, answers3);
        String explanation3 = "Lots of people forget about package access - it's the least used of all the access levels, ";
        explanation3 += "but still worth remembering about - your \"protected\" elements might not be quite as protected ";
        explanation3 += "as you think!";
        question3.setExplanation(explanation3);
        questions.add(question3);
        
        String questionText4 = "You can use the \"private protected\" modifier to restrict visibility to just the inheritence hierachy.";
        ArrayList<Answer> answers4 = new ArrayList<Answer>();
        answers4.add(new Answer("True", false));
        answers4.add(new Answer("False", false));
        answers4.add(new Answer("You could once upon a time...", true));
        Collections.shuffle(answers4);
        Question question4 = new Question(questionText4, answers4);
        String explanation4 = "This is a bit of history more than anything that's used today, but you did use to be able ";
        explanation4 += "to use this modifier to do exactly that. However, the functionality was removed in a very early ";
        explanation4 += "version of Java.";
        question4.setExplanation(explanation4);
        questions.add(question4);
        
        String questionText5 = "It's possible that \"a==a\" can return false.";
        ArrayList<Answer> answers5 = new ArrayList<Answer>();
        answers5.add(new Answer("True", true));
        answers5.add(new Answer("False", false));
        Collections.shuffle(answers5);
        Question question5 = new Question(questionText5, answers5);
        String explanation5 = "Have a look in the double class - there's a value there called NaN (not a number.) By definition,";
        explanation5 += "this isn't equal to itself, so the above code will return false.";
        question5.setExplanation(explanation5);
        questions.add(question5);
        
        String questionText6 = "The code \"String default = \"Default text...\";\" (ignore the outer speech marks) will:";
        ArrayList<Answer> answers6 = new ArrayList<Answer>();
        answers6.add(new Answer("Not compile", true));
        answers6.add(new Answer("Assign the given string to a variable called default", false));
        answers6.add(new Answer("Assign the given string to a variable called def_7", false));
        answers6.add(new Answer("Make you some toast", false));
        Collections.shuffle(answers6);
        Question question6 = new Question(questionText6, answers6);
        String explanation6 = "This is a classic trick question - default is a reserved word in Java (used for switch statements) ";
        explanation6 += "and so cannot be used for a variable name. int, double, new etc. would also cause the compiler to complain.";
        question6.setExplanation(explanation6);
        questions.add(question6);
        
        String questionText7 = "You can use goto in Java to jump to a particular place in code.";
        ArrayList<Answer> answers7 = new ArrayList<Answer>();
        answers7.add(new Answer("True", false));
        answers7.add(new Answer("False", true));
        answers7.add(new Answer("Once upon a time...", true));
        Collections.shuffle(answers7);
        Question question7 = new Question(questionText7, answers7);
        String explanation7 = "I allowed two answers for this one - again you used to be able to eons ago, but it was considered ";
        explanation7 += "such bad practice it was removed. It's still a reserved word however - it just doesn't do anything!";
        question7.setExplanation(explanation7);
        questions.add(question7);

        String questionText8 = "\"System.out.println((char)70);\" will print out:";
        ArrayList<Answer> answers8 = new ArrayList<Answer>();
        answers8.add(new Answer("F", true));
        answers8.add(new Answer("70", false));
        answers8.add(new Answer("Nothing - it'll complain at runtime", false));
        answers8.add(new Answer("Nothing - it'll complain at compile time", false));
        Collections.shuffle(answers8);
        Question question8 = new Question(questionText8, answers8);
        String explanation8 = "Characters in Java can be easily represented by their ASCII codes - and that's what's happening here. ";
        explanation8 += "70 is the ASCII code for a capital F, so when casting it to a character that's what it shows as! This may ";
        explanation8 += "seem pointless, but it can be incredibly useful when you want to create collections of characters that are next to ";
        explanation8 += "each other - just loop through the ASCII codes of the characters you need and cast them to chars.";
        question8.setExplanation(explanation8);
        questions.add(question8);
        
        String questionText9 = "Starting a graphical program when such an environment is not available will cause...";
        ArrayList<Answer> answers9 = new ArrayList<Answer>();
        answers9.add(new Answer("a HeadlessException", true));
        answers9.add(new Answer("an environment to be set up", false));
        answers9.add(new Answer("a reboot", false));
        answers9.add(new Answer("the program to be run with a \"-command\" parameter", false));
        Collections.shuffle(answers9);
        Question question9 = new Question(questionText9, answers9);
        String explanation9 = "Not much to explain here - a HeadlessException will be thrown and the program will usually terminate. ";
        explanation9 += "It's possible to catch this exception and then provide something that will work on a command line, but ";
        explanation9 += "in reality not many people do!";
        question9.setExplanation(explanation9);
        questions.add(question9);
        
        String questionText10 = "System.out.println(\"0x0\"); will print:";
        ArrayList<Answer> answers10 = new ArrayList<Answer>();
        answers10.add(new Answer("0x0", true));
        answers10.add(new Answer("0", false));
        answers10.add(new Answer("The current memory location", false));
        answers10.add(new Answer("An inheritence hierachy", false));
        Collections.shuffle(answers10);
        Question question10 = new Question(questionText10, answers10);
        String explanation10 = "Nothing unusual here, I just wondered how many people would pick the options that didn't make sense!";
        question10.setExplanation(explanation10);
        questions.add(question10);
        
        String questionText11 = "System.out.println(6l); will print:";
        ArrayList<Answer> answers11 = new ArrayList<Answer>();
        answers11.add(new Answer("6", true));
        answers11.add(new Answer("61", false));
        answers11.add(new Answer("60", false));
        answers11.add(new Answer("304", false));
        Collections.shuffle(answers11);
        Question question11 = new Question(questionText11, answers11);
        String explanation11 = "The last character in 6l is actually a L - and this tells Java that you're specifying a long number ";
        explanation11 += "and not an integer. In reality, you should always use a capital L and you'd only use it if the number was ";
        explanation11 += "bigger or smaller than an integer could handle.";
        question11.setExplanation(explanation11);
        questions.add(question11);

        String questionText12 = "System.out.println(6/8); will print:";
        ArrayList<Answer> answers12 = new ArrayList<Answer>();
        answers12.add(new Answer("Nothing - it'll give an error", false));
        answers12.add(new Answer("0", true));
        answers12.add(new Answer("1", false));
        answers12.add(new Answer("0.75", false));
        Collections.shuffle(answers12);
        Question question12 = new Question(questionText12, answers12);
        String explanation12 = "Remember that if you're manipulating two integers, the result will still be an integer - and that ";
        explanation12 += "means the answer can't be a decimal! Instead, the number isn't rounded but the decimal part is simply ";
        explanation12 += "dropped - meaning all that's printed is 0. If you want the decimal to be printed, either write the number ";
        explanation12 += "with a decimal on the end, or cast one of the numbers in the calculation to a double.";
        question12.setExplanation(explanation12);
        questions.add(question12);

        String questionText13 = "System.out.println((float)987654321); will print:";
        ArrayList<Answer> answers13 = new ArrayList<Answer>();
        answers13.add(new Answer("987654321", false));
        answers13.add(new Answer("9.8765434E8", true));
        answers13.add(new Answer("9.87654321E8", false));
        answers13.add(new Answer("9.87654321E16", false));
        Collections.shuffle(answers13);
        Question question13 = new Question(questionText13, answers13);
        String explanation13 = "Float can't store integer numbers as accurately as int can - and the result is that a large integer ";
        explanation13 += "number is actually rounded before being stored. That therefore gives you the rounded answer that is printed out!";
        question13.setExplanation(explanation13);
        questions.add(question13);
     }
     public ArrayList<Question> getQuestion()
     {
         return questions;
     }
}
