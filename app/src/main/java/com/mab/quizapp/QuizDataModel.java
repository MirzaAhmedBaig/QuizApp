package com.mab.quizapp;

public class QuizDataModel {
    private String question;
    private int answer;
    private String[] choices;

    String getQuestion() {
        return question;
    }

    void setQuestion(String question) {
        this.question = question;
    }

    int getAnswer() {
        return answer;
    }

    void setAnswer(int answer) {
        this.answer = answer;
    }

    String[] getChoices() {
        return choices;
    }

    void setChoices(String[] choices) {
        this.choices = choices;
    }

    @Override
    public String toString() {
        return "ClassPojo [question = " + question + ", answer = " + answer + ", choices = " + choices + "]";
    }
}
