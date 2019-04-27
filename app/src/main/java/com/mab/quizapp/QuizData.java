package com.mab.quizapp;

import android.util.Log;

import java.util.ArrayList;

class QuizData {
    private String[] questions = new String[]{
            "What is the range of short data type in Java?",
            "Which of the following are legal lines of Java code?\n" +
                    "int w = (int)888.8;\n" +
                    "byte x = (byte)100L;\n" +
                    "long y = (byte)100;\n" +
                    "byte z = (byte)100L;",
            "An expression involving byte, int, and literal numbers is promoted to which of these?",
            "What is the output of this program?\n" +
                    "class increment {\n" +
                    "    public static void main(String args[]) {\n" +
                    "        int g = 3;\n" +
                    "        System.out.print(++g * 8);\n" +
                    "    }\n" +
                    "}",
            "What is the type of variable ‘b’ and ‘d’ in the below snippet?\n" +
                    "int a[], b;\n" +
                    "int []c, d;",
            "What will this code print?\n" +
                    "int arr[] = new int [5];\n" +
                    "System.out.print(arr);",
            "How to copy contents of array?",
            "Which of these is an incorrect Statement?",
            "Which of these is necessary to specify at time of array initialization?",
            "Which of these selection statements test only for equality?"
    };

    //from 1 t0 4
    private int[] answerIndex = new int[]{2, 4, 1, 3, 3, 4, 1, 1, 1, 2};

    private String[] choices = new String[]{"-128 to 127",
            "-32768 to 32767",
            "-2147483648 to 2147483647",
            "None of the mentioned",
            "1 and 2",
            "2 and 3",
            "3 and 4",
            "All statements are correct",
            "int",
            "long",
            "byte",
            "float",
            "25",
            "24",
            "32",
            "33",
            "‘b’ and ‘d’ are int",
            "‘b’ and ‘d’ are arrays of type int",
            "‘b’ is int variable; ‘d’ is int array",
            "‘d’ is int variable; ‘b’ is int array",
            "0",
            "value stored in arr[0].",
            "00000",
            "Garbage value",
            "System.arrayCopy()",
            "Array.copy()",
            "Arrays.copy()",
            "Collection.copy()",
            "It is necessary to use new operator to initialize an array",
            "Array can be initialized using comma separated expressions surrounded by curly braces",
            "Array can be initialized when they are declared",
            "None of the mentioned",
            "Row",
            "Column",
            "Both Row and Column",
            "None of the mentioned",
            "if",
            "switch",
            "if & switch",
            "none of the mentioned"};
    private ArrayList<QuizDataModel> quizData = new ArrayList<>();


    QuizData() {
        setAlData();
    }

    private void setAlData() {
        int choiceIndex = 0;
        for (int i = 0; i < questions.length; i++) {
            QuizDataModel entry = new QuizDataModel();
            entry.setQuestion(questions[i]);
            String[] questionChoices = new String[4];
            for (int j = choiceIndex; j < choiceIndex + 4; j++) {
                questionChoices[j % 4] = choices[j];
            }
            entry.setChoices(questionChoices);
            entry.setAnswer(answerIndex[i]);
            quizData.add(entry);
            choiceIndex = choiceIndex + 4;
        }
    }

    ArrayList<QuizDataModel> getAllData() {
        Log.d("TAG", "getAllData");
        return quizData;
    }

}

