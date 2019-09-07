package no.kristiania.yatzy;
        import org.junit.jupiter.api.Test;
        import static org.junit.jupiter.api.Assertions.assertEquals;


public class yatzyGame {

    @Test
    void getScore(){
        assertEquals(0, scoreYatzy(YatziCategory.ONES, new int[] {1,2,3,4,5,6}));
    }



    public int scoreYatzy(YatziCategory cat, int[] dice) {
        return 0;
    }





}
