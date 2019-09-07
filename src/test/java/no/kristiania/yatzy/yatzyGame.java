package no.kristiania.yatzy;
        import org.junit.jupiter.api.Test;
        import static org.junit.jupiter.api.Assertions.assertEquals;


public class yatzyGame {

    @Test
    void getScore(){
        assertEquals(1, scoreYatzy(YatziCategory.ONES, new int[] {1,2,3,4,5,6}));
    }



    public int scoreYatzy(YatziCategory cat, int[] dice) {
        int [] frequencies = new int[7];
        for(int die : dice){
            frequencies[die]++;
        }
        for(int i=0;i<frequencies.length;i++){
            return frequencies[1];
        }
        return 0;
    }






}
