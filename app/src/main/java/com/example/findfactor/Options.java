package com.example.findfactor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import java.util.Random;

public class Options<answerPosition> {
    private int num;
    private int rand;
    public static int factorNumber = 1;



    public int [] options;

    private int answerPosition;

    private int upperLimit;

    private String questionPhrase;
    Random randomNumberMaker = new Random();

    public Options(int upperLimit){
        this.upperLimit=upperLimit;
        Random randomNumberMaker = new Random();

        this.num = randomNumberMaker.nextInt(upperLimit);
        this.questionPhrase = "The Factor of" + num +"is";


            List<Integer> factors = new ArrayList<>();
            while(factorNumber <= num){
                if(num % factorNumber == 0){
                    factors.add(factorNumber);
                }
                factorNumber++;
            }

        }



        this.answerPosition = randomNumberMaker.nextInt(3);

        this.options = new int[] {0,1,2};
        this.rand = randomNumberMaker.nextInt(factorNumber);
        this.options[0]= generateRandom(0,factorNumber,factors)




    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }



    public int[] getOptions() {
        return options;
    }

    public void setOptions(int[] options) {
        this.options = options;
    }

    public int getAnswerPosition() {
        return answerPosition;
    }

    public void setAnswerPosition(int answerPosition) {
        this.answerPosition = answerPosition;
    }

    public int getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(int upperLimit) {
        this.upperLimit = upperLimit;
    }

    public String getQuestionPhrase() {
        return questionPhrase;
    }

    public void setQuestionPhrase(String questionPhrase) {
        this.questionPhrase = questionPhrase;
    }
    public int generateRandom(int start, int end, ArrayList<Integer> excludeRows) {
        Random rand = new Random();
        int range = end - start + 1;
        int random=0;

        boolean success = false;
        while(!success) {
            random = rand.nextInt(range) + 1;
            for(Integer i: excludeRows) {
                if(i == random) {
                    break;
                } else if (i > random) {
                    success = true;
                    break;
                }
            }
        }
        return random;
    }
}
