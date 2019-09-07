package no.kristiania.yatzy;
        import org.junit.jupiter.api.Test;
        import static org.junit.jupiter.api.Assertions.assertEquals;


public class yatzyGame {

    @Test
    void getScore(){
        assertEquals(12, scoreYatzy(YatziCategory.PAIR, new int[] {1,1,6,5,5,6}));
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






}
