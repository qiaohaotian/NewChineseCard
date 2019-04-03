import org.junit.Assert;
import org.junit.Test;
import server.Card;
import server.Win;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestHule {
    @Test
    public void Win_Tesst(){
        ArrayList<Card> cardsPile = new ArrayList<Card>();
        String[] NUMBER1 = new String[] { "1", "2", "3", "4", "5", "6", "7"};
        String[] COLOR1 = new String[] { "条", "饼"};
        for (int i = 0; i < NUMBER1.length; i++) {
            for (int j = 0; j < COLOR1.length; j++) {
                Card card = new Card(NUMBER1[i], COLOR1[j], i);
                cardsPile.add(card);
            }
        }
        junit.framework.Assert.assertEquals(false, Win.ishule(cardsPile));
    }
}
