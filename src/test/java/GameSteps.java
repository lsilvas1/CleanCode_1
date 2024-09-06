import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GameSteps {

    public static final int OPTION_PAPER = 1;
    public static final int OPTION_SCISSORS = 2;
    public static final int OPTION_ROCK = 0;

    @InjectMocks
    private Game game;

    @Mock
    Scanner scanner;

    @Mock
    Random random;

    private ByteArrayOutputStream out;

    @Before
    public void setup() {
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @Given("the user will choose {string}")
    public void theUserWillChoose(String gameOption) {
        when(scanner.nextLine()).thenReturn("Rock").thenReturn("Quit");

    }

    @And("the computer will choose {string}")
    public void theComputerWillChoose(String arg0) {
        when(random.nextInt(3)).thenReturn(OPTION_SCISSORS);
        
    }

    @When("they play")
    public void theyPlay() {
        game.play();
    }

    @Then("the user wins")
    public void theUserWins() {
        Assert.assertTrue(out.toString().contains("Computer chose scissors"));
        Assert.assertTrue(out.toString().contains("wins:1"));
    }
}
