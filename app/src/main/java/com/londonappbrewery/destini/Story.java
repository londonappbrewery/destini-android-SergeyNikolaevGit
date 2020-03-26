package com.londonappbrewery.destini;

public class Story {

    int storyQuestion;
    int answer1;
    int answer2;
    int answer1ID;
    int answer2ID;


    public Story (int stQuestion, int ans1, int ans2, int ans1ID, int ans2ID) {

        storyQuestion = stQuestion;
        answer1 = ans1;
        answer2 = ans2;
        answer1ID = ans1ID;
        answer2ID = ans2ID;
    }


    public int getStoryQuestion() {
        return storyQuestion;
    }

    public void setStoryQuestion(int storyQuestion) {
        this.storyQuestion = storyQuestion;
    }

    public int getAnswer1() {
        return answer1;
    }

    public void setAnswer1(int answer1) {
        this.answer1 = answer1;
    }

    public int getAnswer2() {
        return answer2;
    }

    public void setAnswer2(int answer2) {
        this.answer2 = answer2;
    }

    public int getAnswer1ID() {
        return answer1ID;
    }

    public void setAnswer1ID(int answer1ID) {
        this.answer1ID = answer1ID;
    }

    public int getAnswer2ID() {
        return answer2ID;
    }

    public void setAnswer2ID(int answer2ID) {
        this.answer2ID = answer2ID;
    }
}
