package com.example.findfactor;
import java.util.ArrayList;
import java.util.List;

public class game {
    private List<Options> questions;
    private int correct;
    private int incorrect;
    private int totalQuestions;
    private int score;
    private Options currentQuestion;



    public game(){
        correct=0;
        incorrect=0;
        totalQuestions=0;
        score=0;
        currentQuestion = new Options(10);
        questions = new ArrayList<Options>();
    }

    public void makeNewQuestion(){
        currentQuestion = new Options(totalQuestions*10 + totalQuestions*5);
        totalQuestions++;
        questions.add(currentQuestion);
    }

    public boolean checkAnswer(int [] factors){
        boolean isCorrect;
        for(int i=0;i<Options.factorNumber;i++){
            if(currentQuestion.getAnswer() == factors[i]){
                correct++;
                isCorrect=true;
            }
            else{
                incorrect++;
                isCorrect=false;
            }
            score = correct*10;
        }

    }

   public List<Options> getQuestions() {
       return questions;


      /* public  void setQuestions (List < Options > questions) {
           this.questions = questions;
       }*/

       public int getCorrect () {
           return correct;
       }

       public void setCorrect ( int correct){
           this.correct = correct;
       }

       public int getIncorrect () {
           return incorrect;
       }

       public void setIncorrect ( int incorrect){
           this.incorrect = incorrect;
       }

       public int getTotalQuestions () {
           return totalQuestions;
       }

       public void setTotalQuestions ( int totalQuestions){
           this.totalQuestions = totalQuestions;
       }

       public int getScore () {
           return score;
       }

       public void setScore ( int score){
           this.score = score;
       }

       public Options getCurrentQuestion () {
           return currentQuestion;
       }

       public void setCurrentQuestion (Options currentQuestion){
           this.currentQuestion = currentQuestion;
       }
   }