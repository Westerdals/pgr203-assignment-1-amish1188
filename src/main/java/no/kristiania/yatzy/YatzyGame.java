package no.kristiania.yatzy;

public class YatzyGame {


    //calculate sum of the dice showing one score
    public static int calcOneScore(int diceValue, int[] dice){
        for(int i=1;i<dice.length;i++){
            return (dice[diceValue]*diceValue);
        }
        return 0;
    }

    //calculate one pair
    public static int calcPair(int[] dice) {
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
    public static int calcTwoPairs(int[] dice){
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
    public static int calcFullHouse(int[] dice){
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

    public static int calcSmallStraight(int[] dice){
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

    public static int calcLargeStraight(int[] dice){
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
    public static int calcOfAKind(int[]dice, int expectedNumOfDice){
        for(int i =  dice.length-1; i>0; i--){
            if(dice[i]>=expectedNumOfDice){
                return i*expectedNumOfDice;
            }
        }
        return 0;
    }

    public static int calcThreeOfAKind(int[] dice){
        return calcOfAKind(dice,3);
    }

    public static int calcFourOfAKind(int[] dice) {
        return calcOfAKind(dice,4);
    }

    public static int calcChance(int[] dice){
        int scoreAll =0;
        for(int i=1;i<dice.length;i++){
            scoreAll += (dice[i] * i);
        }
        return scoreAll;
    }

    public static int calcYatzy(int[] dice){
        int isYatzy = calcOfAKind(dice, 6);
        if (isYatzy>0){
            return 50;
        }
        return 0;
    }

    // main method where we calculate all yatzy possibilities
    static int scoreYatzy(YatzyCategory cat, int[] dice) {
        int [] frequencies = new int[7];
        int score= 0;

        for(int die : dice){
            frequencies[die]++;
        }

        if(cat == YatzyCategory.ONES){score = calcOneScore(1, frequencies);}
        else if(cat == YatzyCategory.TWOS){score = calcOneScore(2, frequencies);}
        else if(cat == YatzyCategory.THREES){score = calcOneScore(3, frequencies);}
        else if(cat == YatzyCategory.FOURS){score = calcOneScore(4, frequencies);}
        else if(cat == YatzyCategory.FIVES){score = calcOneScore(5, frequencies);}
        else if(cat == YatzyCategory.SIXES){score = calcOneScore(6, frequencies);}
        else if(cat == YatzyCategory.PAIR){score = calcPair(frequencies);}
        else if(cat == YatzyCategory.TWOPAIRS){score = calcTwoPairs(frequencies);}
        else if(cat == YatzyCategory.FULLHOUSE){score = calcFullHouse(frequencies);}
        else if(cat == YatzyCategory.SMALLSTRAIGHT){score = calcSmallStraight(frequencies);}
        else if(cat == YatzyCategory.LARGESTRAIGHT){score = calcLargeStraight(frequencies);}
        else if(cat == YatzyCategory.FOUROFAKIND){score = calcFourOfAKind(frequencies);}
        else if(cat == YatzyCategory.THREEOFAKIND){score = calcThreeOfAKind(frequencies);}
        else if(cat == YatzyCategory.CHANCE){score = calcChance(frequencies);}
        else if(cat == YatzyCategory.YATZY){score = calcYatzy(frequencies);}

        return score;
    }
}
