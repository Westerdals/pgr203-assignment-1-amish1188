package no.kristiania.yatzy;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class YatzyGameTest {

    // main method where we calculate all yatzy possibilities
    private static int scoreYatzy(YatzyCategory cat, int[] dice) {
        int [] frequencies = new int[7];
        int score= 0;

        for(int die : dice){
            frequencies[die]++;
        }

        if(cat == YatzyCategory.ONES){score = YatzyGame.calcOneScore(1, frequencies);}
        else if(cat == YatzyCategory.TWOS){score = YatzyGame.calcOneScore(2, frequencies);}
        else if(cat == YatzyCategory.THREES){score = YatzyGame.calcOneScore(3, frequencies);}
        else if(cat == YatzyCategory.FOURS){score = YatzyGame.calcOneScore(4, frequencies);}
        else if(cat == YatzyCategory.FIVES){score = YatzyGame.calcOneScore(5, frequencies);}
        else if(cat == YatzyCategory.SIXES){score = YatzyGame.calcOneScore(6, frequencies);}
        else if(cat == YatzyCategory.PAIR){score = YatzyGame.calcPair(frequencies);}
        else if(cat == YatzyCategory.TWOPAIRS){score = YatzyGame.calcTwoPairs(frequencies);}
        else if(cat == YatzyCategory.FULLHOUSE){score = YatzyGame.calcFullHouse(frequencies);}
        else if(cat == YatzyCategory.SMALLSTRAIGHT){score = YatzyGame.calcSmallStraight(frequencies);}
        else if(cat == YatzyCategory.LARGESTRAIGHT){score = YatzyGame.calcLargeStraight(frequencies);}
        else if(cat == YatzyCategory.FOUROFAKIND){score = YatzyGame.calcFourOfAKind(frequencies);}
        else if(cat == YatzyCategory.THREEOFAKIND){score = YatzyGame.calcThreeOfAKind(frequencies);}
        else if(cat == YatzyCategory.CHANCE){score = YatzyGame.calcChance(frequencies);}
        else if(cat == YatzyCategory.YATZY){score = YatzyGame.calcYatzy(frequencies);}

        return score;
    }

    @Test
    void checkOnes(){
        assertEquals(2, scoreYatzy(YatzyCategory.ONES, new int[]{1, 1, 2, 3, 5, 6}));
        assertEquals(0, scoreYatzy(YatzyCategory.ONES, new int[] {6,5,5,6,6,6}));
    }

    @Test
    void checkTwos(){
        assertEquals(6, scoreYatzy(YatzyCategory.TWOS, new int[] {2,3,2,1,1,2}));
        assertEquals(4, scoreYatzy(YatzyCategory.TWOS, new int[] {2,2,1,3,3,5}));
    }

    @Test
    void checkThrees(){
        assertEquals(9, scoreYatzy(YatzyCategory.THREES, new int[] {2,3,2,3,1,3}));
        assertEquals(6, scoreYatzy(YatzyCategory.THREES, new int[] {2,2,1,3,3,5}));
    }

    @Test
    void checkFours(){
        assertEquals(8, scoreYatzy(YatzyCategory.FOURS, new int[] {4,3,2,4,1,2}));
        assertEquals(0, scoreYatzy(YatzyCategory.FOURS, new int[] {2,2,1,3,3,5}));
    }

    @Test
    void checkFives(){
        assertEquals(10, scoreYatzy(YatzyCategory.FIVES, new int[] {1,2,3,5,4,5}));
        assertEquals(5, scoreYatzy(YatzyCategory.FIVES, new int[] {2,2,1,3,3,5}));
    }

    @Test
    void checkSixes(){
        assertEquals(12, scoreYatzy(YatzyCategory.SIXES, new int[] {2,3,6,5,4,6}));
        assertEquals(6, scoreYatzy(YatzyCategory.SIXES, new int[] {2,2,6,3,3,5}));
    }

    @Test
    void checkPair(){
        assertEquals(12, scoreYatzy(YatzyCategory.PAIR, new int[] {2,4,6,5,4,6}));
        assertEquals(4, scoreYatzy(YatzyCategory.PAIR, new int[] {2,2,6,3,1,2}));
    }

    @Test
    void checkTwoPairs(){
        assertEquals(18, scoreYatzy(YatzyCategory.TWOPAIRS, new int[] {2,3,6,3,4,6}));
        assertEquals(14, scoreYatzy(YatzyCategory.TWOPAIRS, new int[] {2,2,6,5,3,5}));
    }

    @Test
    void checkFullHouse(){
        assertEquals(25, scoreYatzy(YatzyCategory.FULLHOUSE, new int[] {2,3,6,3,3,6}));
        assertEquals(0, scoreYatzy(YatzyCategory.FULLHOUSE, new int[] {2,2,6,3,3,5}));
    }

    @Test
    void checkSmallStraight(){
        assertEquals(15, scoreYatzy(YatzyCategory.SMALLSTRAIGHT, new int[] {6,1,2,3,4,5}));
        assertEquals(0, scoreYatzy(YatzyCategory.SMALLSTRAIGHT, new int[] {2,3,4,5,6,6}));
    }

    @Test
    void checkLargeStraight(){
        assertEquals(20, scoreYatzy(YatzyCategory.LARGESTRAIGHT, new int[] {2,3,6,5,4,6}));
        assertEquals(0, scoreYatzy(YatzyCategory.LARGESTRAIGHT, new int[] {1,2,3,4,5,5}));
    }

    @Test
    void checkFourOfAKinds(){
        assertEquals(12, scoreYatzy(YatzyCategory.FOUROFAKIND, new int[] {2,3,3,3,3,6}));
        assertEquals(8, scoreYatzy(YatzyCategory.FOUROFAKIND, new int[] {2,2,2,2,2,5}));
    }

    @Test
    void checkThreeOfAKind(){
        assertEquals(15, scoreYatzy(YatzyCategory.THREEOFAKIND, new int[] {2,5,6,5,4,5}));
        assertEquals(9, scoreYatzy(YatzyCategory.THREEOFAKIND, new int[] {3,3,6,3,3,5}));
    }

    @Test
    void checkChance(){
        assertEquals(26, scoreYatzy(YatzyCategory.CHANCE, new int[] {2,3,6,5,4,6}));
        assertEquals(18, scoreYatzy(YatzyCategory.CHANCE, new int[] {1,2,3,3,4,5}));
    }

    @Test
    void checkYatzy(){
        assertEquals(50, scoreYatzy(YatzyCategory.YATZY, new int[] {6,6,6,6,6,6}));
        assertEquals(0, scoreYatzy(YatzyCategory.YATZY, new int[] {2,2,6,3,3,5}));
    }











}
