import org.example.PlayGame;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class PlayGameTest {
    PlayGame playGame;
    @Before
    public void prepareData(){
        playGame = new PlayGame();
    }
    @Test
    public void testGetValidNumber_Valid(){
        String input = "5\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner sc = new Scanner(System.in);

        int result = playGame.getValidNumber(sc);

        Assert.assertEquals(5, result);
    }
    @Test
    public void testGetValidNumber_NotValid(){
        String input = "0\n11\n7\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner sc = new Scanner(System.in);

        int result = playGame.getValidNumber(sc);

        Assert.assertEquals(7, result);
    }

    @Test
    public void testGiveHelp_Hot() {
        int number = 5;
        int rand = 6;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        playGame.giveHelp(number, rand);
        String expectedOutput = "Жгётся!" + System.lineSeparator();

        Assert.assertEquals(expectedOutput, outContent.toString());
    }
    @Test
    public void testGiveHelp_Warm() {
        int number = 5;
        int rand = 8;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        playGame.giveHelp(number, rand);
        String expectedOutput = "Тепло" + System.lineSeparator();

        Assert.assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testGiveHelp_Cold() {
        int number = 5;
        int rand = 12;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        playGame.giveHelp(number, rand);
        String expectedOutput = "Холодно" + System.lineSeparator();

        Assert.assertEquals(expectedOutput, outContent.toString());
    }
}
