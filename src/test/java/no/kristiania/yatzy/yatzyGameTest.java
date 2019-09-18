package no.kristiania.yatzy;
        import org.junit.jupiter.api.Test;
        import static org.junit.jupiter.api.Assertions.assertEquals;


public class yatzyGameTest {

    @Test
    void checkOnes(){
        assertEquals(2, scoreYatzy(YatziCategory.ONES, new int[] {1,1,2,3,5,6}));
        assertEquals(0, scoreYatzy(YatziCategory.ONES, new int[] {6,5,5,6,6,6}));
    }

    @Test
    void checkTwos(){
        assertEquals(6, scoreYatzy(YatziCategory.TWOS, new int[] {2,3,2,1,1,2}));
        assertEquals(4, scoreYatzy(YatziCategory.TWOS, new int[] {2,2,1,3,3,5}));
    }

    @Test
    void checkThrees(){
        assertEquals(9, scoreYatzy(YatziCategory.THREES, new int[] {2,3,2,3,1,3}));
        assertEquals(6, scoreYatzy(YatziCategory.THREES, new int[] {2,2,1,3,3,5}));
    }

    @Test
    void checkFours(){
        assertEquals(8, scoreYatzy(YatziCategory.FOURS, new int[] {4,3,2,4,1,2}));
        assertEquals(0, scoreYatzy(YatziCategory.FOURS, new int[] {2,2,1,3,3,5}));
    }

    @Test
    void checkFives(){
        assertEquals(10, scoreYatzy(YatziCategory.FIVES, new int[] {1,2,3,5,4,5}));
        assertEquals(5, scoreYatzy(YatziCategory.FIVES, new int[] {2,2,1,3,3,5}));
    }

    @Test
    void checkSixes(){
        assertEquals(12, scoreYatzy(YatziCategory.SIXES, new int[] {2,3,6,5,4,6}));
        assertEquals(6, scoreYatzy(YatziCategory.SIXES, new int[] {2,2,6,3,3,5}));
    }

    @Test
    void checkPair(){
        assertEquals(12, scoreYatzy(YatziCategory.PAIR, new int[] {2,4,6,5,4,6}));
        assertEquals(4, scoreYatzy(YatziCategory.PAIR, new int[] {2,2,6,3,1,2}));
    }

    @Test
    void checkTwoPairs(){
        assertEquals(18, scoreYatzy(YatziCategory.TWOPAIRS, new int[] {2,3,6,3,4,6}));
        assertEquals(14, scoreYatzy(YatziCategory.TWOPAIRS, new int[] {2,2,6,5,3,5}));
    }

    @Test
    void checkFullHouse(){
        assertEquals(25, scoreYatzy(YatziCategory.FULLHOUSE, new int[] {2,3,6,3,3,6}));
        assertEquals(0, scoreYatzy(YatziCategory.FULLHOUSE, new int[] {2,2,6,3,3,5}));
    }

    @Test
    void checkSmallStraight(){
        assertEquals(15, scoreYatzy(YatziCategory.SMALLSTRAIGHT, new int[] {6,1,2,3,4,5}));
        assertEquals(0, scoreYatzy(YatziCategory.SMALLSTRAIGHT, new int[] {2,3,4,5,6,6}));
    }

    @Test
    void checkLargeStraight(){
        assertEquals(20, scoreYatzy(YatziCategory.LARGESTRAIGHT, new int[] {2,3,6,5,4,6}));
        assertEquals(0, scoreYatzy(YatziCategory.LARGESTRAIGHT, new int[] {1,2,3,4,5,5}));
    }

    @Test
    void checkFourOfAKinds(){
        assertEquals(12, scoreYatzy(YatziCategory.FOUROFAKIND, new int[] {2,3,3,3,3,6}));
        assertEquals(8, scoreYatzy(YatziCategory.FOUROFAKIND, new int[] {2,2,2,2,2,5}));
    }

    @Test
    void checkThreeOfAKind(){
        assertEquals(15, scoreYatzy(YatziCategory.THREEOFAKIND, new int[] {2,5,6,5,4,5}));
        assertEquals(9, scoreYatzy(YatziCategory.THREEOFAKIND, new int[] {3,3,6,3,3,5}));
    }

    @Test
    void checkChance(){
        assertEquals(26, scoreYatzy(YatziCategory.CHANCE, new int[] {2,3,6,5,4,6}));
        assertEquals(18, scoreYatzy(YatziCategory.CHANCE, new int[] {1,2,3,3,4,5}));
    }

    @Test
    void checkYatzy(){
        assertEquals(50, scoreYatzy(YatziCategory.YATZY, new int[] {6,6,6,6,6,6}));
        assertEquals(0, scoreYatzy(YatziCategory.YATZY, new int[] {2,2,6,3,3,5}));
    }









    // main method where we calculate all yatzy possibilities
    public int scoreYatzy(YatziCategory cat, int[] dice) {
        int [] frequencies = new int[7];
        int score= 0;

        for(int die : dice){
            frequencies[die]++;
        }

        if(cat == YatziCategory.ONES){score = calcOneScore(1, frequencies);}
        else if(cat == YatziCategory.TWOS){score = calcOneScore(2, frequencies);}
        else if(cat == YatziCategory.THREES){score = calcOneScore(3, frequencies);}
        else if(cat == YatziCategory.FOURS){score = calcOneScore(4, frequencies);}
        else if(cat == YatziCategory.FIVES){score = calcOneScore(5, frequencies);}
        else if(cat == YatziCategory.SIXES){score = calcOneScore(6, frequencies);}
        else if(cat == YatziCategory.PAIR){score = calcPair(frequencies);}
        else if(cat == YatziCategory.TWOPAIRS){score = calcTwoPairs(frequencies);}
        else if(cat == YatziCategory.FULLHOUSE){score = calcFullHouse(frequencies);}
        else if(cat == YatziCategory.SMALLSTRAIGHT){score = calcSmallStraight(frequencies);}
        else if(cat == YatziCategory.LARGESTRAIGHT){score = calcLargeStraight(frequencies);}
        else if(cat == YatziCategory.FOUROFAKIND){score = calcFourOfAKind(frequencies);}
        else if(cat == YatziCategory.THREEOFAKIND){score = calcThreeOfAKind(frequencies);}
        else if(cat == YatziCategory.CHANCE){score = calcChance(frequencies);}
        else if(cat == YatziCategory.YATZY){score = calcYatzy(frequencies);}

        return score;
    }


    //calculate sum of the dice showing one score
    public int calcOneScore(int diceValue, int[] dice){
        for(int i=1;i<dice.length;i++){
            return (dice[diceValue]*diceValue);
        }
        return 0;
    }

    //calculate one pair
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

    //calc two pairs with use of calcPair function
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

    //calc Full House with use of calcPair function
    public int calcFullHouse(int[] dice){
        int firstHouse =calcPair(dice);
        int secHouse =0;

        for(int i=1; i<dice.length;i++){
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
            return 15;
        }
        return 0;
    }

    public int calcLargeStraight(int[] dice){
        int largeStraight = 0;

        for(int i = 2; i<dice.length; i++){
            if(dice[i]<= 2 && dice[i]>0){
                largeStraight++;
            }
        }

        if(largeStraight== 5){
            return 20;
        }
        return 0;
    }

    //this function we will reuse in calc three and four of a kind
    //we use one parameter to choose the number of the dice we want to get
    public int calcOfAKind(int[]dice, int expectedNumOfDice){
        for(int i =  dice.length-1; i>0; i--){
            if(dice[i]>=expectedNumOfDice){
                return i*expectedNumOfDice;
            }
        }
        return 0;
    }

    public int calcThreeOfAKind(int[] dice){
       return calcOfAKind(dice,3);
    }

    public int calcFourOfAKind(int[] dice) {
        return calcOfAKind(dice,4);
    }

    public int calcChance(int[] dice){
        int scoreAll =0;
        for(int i=1;i<dice.length;i++){
            scoreAll += (dice[i] * i);
        }
        return scoreAll;
    }

    public int calcYatzy(int[] dice){
       int isYatzy = calcOfAKind(dice, 6);
       if (isYatzy>0){
           return 50;
       }
       return 0;
    }

}
