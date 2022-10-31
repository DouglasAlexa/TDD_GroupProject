package org.example;

import java.util.Arrays;

public class Questions {

    private int id;
    private String question;
    private String[] answer;
    private String correctAnswer;

    public Questions(int id, String question, String[] answer, String correctAnswer) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.correctAnswer = correctAnswer;
    }

    @Override
    public String toString() {
        return "Questions{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", answer=" + Arrays.toString(answer) +
                ", correctAnswer='" + correctAnswer + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getAnswer() {
        return answer;
    }

    public void setAnswer(String[] answer) {
        this.answer = answer;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
