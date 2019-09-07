package no.kristiania.yatzy;
        import org.junit.jupiter.api.Test;
        import static org.junit.jupiter.api.Assertions.assertEquals;


public class yatzyGame {

    @Test
    void getScore(){
        assertEquals(5, scoreYatzy(YatziCategory.SMALLSTRAIGHT, new int[] {1,1,3,4,5,2}));
    }



    public int scoreYatzy(YatziCategory cat, int[] dice) {
        int [] frequencies = new int[7];
        int score= 0;
        for(int die : dice){
            frequencies[die]++;
        }

        if(cat == YatziCategory.ONES){score = calcScore(1, frequencies);}
        else if(cat == YatziCategory.TWOS){score = calcScore(2, frequencies);}
        else if(cat == YatziCategory.THREES){score = calcScore(3, frequencies);}
        else if(cat == YatziCategory.FOURS){score = calcScore(4, frequencies);}
        else if(cat == YatziCategory.FIVES){score = calcScore(5, frequencies);}
        else if(cat == YatziCategory.SIXES){score = calcScore(6, frequencies);}
        else if(cat == YatziCategory.PAIR){score = calcPair(frequencies);}
        else if(cat == YatziCategory.TWOPAIRS){score = calcTwoPairs(frequencies);}
        else if(cat == YatziCategory.FULLHOUSE){score = calcFullHouse(frequencies);}
        else if(cat == YatziCategory.SMALLSTRAIGHT){score = calcSmallStraight(frequencies);}
        else if(cat == YatziCategory.LARGESTRAIGHT){score = calcLargeStraight(frequencies);}

        return score;
    }


    public int calcScore(int diceValue, int[] dice){

        for(int i=0;i<dice.length;i++){
            return (dice[diceValue]*diceValue);
        }
        return 0;
    }

    public int calcPair(int[] dice) {
        int pair = 0;
        for(int i = dice.length-1; i>0;i--){
            if(dice[i]>=2){
                pair =  i * 2;
                break; //break doesn't work with return statements;
            }
        }
        return pair;

    }

    public int calcTwoPairs(int[] dice){
        int pair1 = calcPair(dice);
        int pair1Index = calcPair(dice)/2;
        int pair2 = 0;

        for(int i= pair1Index-1; i>0; i--){
            if(dice[i]>=2){
                pair2 = i * 2;
                break;
            }
        }

        return (pair1 + pair2);

    }

    public int calcFullHouse(int[] dice){
        int firstHouse =calcPair(dice);
        int secHouse =0;

        for(int i=0; i<dice.length;i++){
            if(dice[i] ==3){
                secHouse = dice[i];
            }
        }

        if(firstHouse >0 && secHouse>0){
            return 25;
        }
        return 0;

    }

    public int calcSmallStraight(int[] dice){
        int smallStraight = 0;

        for(int i = 1; i<dice.length-1; i++){
            if(dice[i]<= 2 && dice[i]>0){
                smallStraight++;
            }
        }

        if(smallStraight== 5){
            return 5;
        }
        return smallStraight;
    }

    public int calcLargeStraight(int[] dice){
        int largeStraight = 0;

        for(int i = 2; i<dice.length; i++){
            if(dice[i]<= 2 && dice[i]>0){
                largeStraight++;
            }
        }

        if(largeStraight== 5){
            return 5;
        }
        return largeStraight;
    }






}
