package no.kristiania.yatzy;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class YatzyGameTest {

    @Test
    void checkOnes(){
        assertEquals(2, YatzyGame.scoreYatzy(YatzyCategory.ONES, new int[]{1, 1, 2, 3, 5, 6}));
        assertEquals(0, YatzyGame.scoreYatzy(YatzyCategory.ONES, new int[] {6,5,5,6,6,6}));
    }

    @Test
    void checkTwos(){
        assertEquals(6, YatzyGame.scoreYatzy(YatzyCategory.TWOS, new int[] {2,3,2,1,1,2}));
        assertEquals(4, YatzyGame.scoreYatzy(YatzyCategory.TWOS, new int[] {2,2,1,3,3,5}));
    }

    @Test
    void checkThrees(){
        assertEquals(9, YatzyGame.scoreYatzy(YatzyCategory.THREES, new int[] {2,3,2,3,1,3}));
        assertEquals(6, YatzyGame.scoreYatzy(YatzyCategory.THREES, new int[] {2,2,1,3,3,5}));
    }

    @Test
    void checkFours(){
        assertEquals(8, YatzyGame.scoreYatzy(YatzyCategory.FOURS, new int[] {4,3,2,4,1,2}));
        assertEquals(0, YatzyGame.scoreYatzy(YatzyCategory.FOURS, new int[] {2,2,1,3,3,5}));
    }

    @Test
    void checkFives(){
        assertEquals(10, YatzyGame.scoreYatzy(YatzyCategory.FIVES, new int[] {1,2,3,5,4,5}));
        assertEquals(5, YatzyGame.scoreYatzy(YatzyCategory.FIVES, new int[] {2,2,1,3,3,5}));
    }

    @Test
    void checkSixes(){
        assertEquals(12, YatzyGame.scoreYatzy(YatzyCategory.SIXES, new int[] {2,3,6,5,4,6}));
        assertEquals(6, YatzyGame.scoreYatzy(YatzyCategory.SIXES, new int[] {2,2,6,3,3,5}));
    }

    @Test
    void checkPair(){
        assertEquals(12, YatzyGame.scoreYatzy(YatzyCategory.PAIR, new int[] {2,4,6,5,4,6}));
        assertEquals(4, YatzyGame.scoreYatzy(YatzyCategory.PAIR, new int[] {2,2,6,3,1,2}));
    }

    @Test
    void checkTwoPairs(){
        assertEquals(18, YatzyGame.scoreYatzy(YatzyCategory.TWOPAIRS, new int[] {2,3,6,3,4,6}));
        assertEquals(14, YatzyGame.scoreYatzy(YatzyCategory.TWOPAIRS, new int[] {2,2,6,5,3,5}));
    }

    @Test
    void checkFullHouse(){
        assertEquals(25, YatzyGame.scoreYatzy(YatzyCategory.FULLHOUSE, new int[] {2,3,6,3,3,6}));
        assertEquals(0, YatzyGame.scoreYatzy(YatzyCategory.FULLHOUSE, new int[] {2,2,6,3,3,5}));
    }

    @Test
    void checkSmallStraight(){
        assertEquals(15, YatzyGame.scoreYatzy(YatzyCategory.SMALLSTRAIGHT, new int[] {6,1,2,3,4,5}));
        assertEquals(0, YatzyGame.scoreYatzy(YatzyCategory.SMALLSTRAIGHT, new int[] {2,3,4,5,6,6}));
    }

    @Test
    void checkLargeStraight(){
        assertEquals(20, YatzyGame.scoreYatzy(YatzyCategory.LARGESTRAIGHT, new int[] {2,3,6,5,4,6}));
        assertEquals(0, YatzyGame.scoreYatzy(YatzyCategory.LARGESTRAIGHT, new int[] {1,2,3,4,5,5}));
    }

    @Test
    void checkFourOfAKinds(){
        assertEquals(12, YatzyGame.scoreYatzy(YatzyCategory.FOUROFAKIND, new int[] {2,3,3,3,3,6}));
        assertEquals(8, YatzyGame.scoreYatzy(YatzyCategory.FOUROFAKIND, new int[] {2,2,2,2,2,5}));
    }

    @Test
    void checkThreeOfAKind(){
        assertEquals(15, YatzyGame.scoreYatzy(YatzyCategory.THREEOFAKIND, new int[] {2,5,6,5,4,5}));
        assertEquals(9, YatzyGame.scoreYatzy(YatzyCategory.THREEOFAKIND, new int[] {3,3,6,3,3,5}));
    }

    @Test
    void checkChance(){
        assertEquals(26, YatzyGame.scoreYatzy(YatzyCategory.CHANCE, new int[] {2,3,6,5,4,6}));
        assertEquals(18, YatzyGame.scoreYatzy(YatzyCategory.CHANCE, new int[] {1,2,3,3,4,5}));
    }

    @Test
    void checkYatzy(){
        assertEquals(50, YatzyGame.scoreYatzy(YatzyCategory.YATZY, new int[] {6,6,6,6,6,6}));
        assertEquals(0, YatzyGame.scoreYatzy(YatzyCategory.YATZY, new int[] {2,2,6,3,3,5}));
    }











}
