package test;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.Player;
import pojo.Root;

import java.io.FileNotFoundException;
import java.io.FileReader;

@Epic("Validate RCB Team Players")
@Feature("Validate Foreign players and wicket keeper")
public class Team {

    @Test(description = "To validate atmost four foreign players are there in team")
    public void validateForeignPlayers() throws FileNotFoundException {

        int foreignPlayer = 0;

        //Using Gson class to convert JSON to java objects
        Gson gson = new Gson();

        //Using Json Reader to read the JSON data
        JsonReader reader = new JsonReader(new FileReader(System.getProperty("user.dir") + "/src/test/resources/Players.json"));
        Root data = gson.fromJson(reader, Root.class);

        //Iterating over Player class to get the data from Player class.
        for (Player player : data.getPlayer()) {
            if (!player.getCountry().equalsIgnoreCase("India")) {
                foreignPlayer++;
            }
        }

        //Assertion for four Foreign Players
        Assert.assertEquals(foreignPlayer, 4, "more than four foreign players");

    }

    @Test(description = "To validate atleast one wicketkeeper is present in the team")
    public void validateWicketKeeper() throws FileNotFoundException {
        int wicketKeeper = 0;
        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new FileReader(System.getProperty("user.dir") + "/src/test/resources/Players.json"));
        Root data = gson.fromJson(reader, Root.class);
        for (Player player : data.getPlayer()) {
            if (player.getRole().equalsIgnoreCase("Wicket-keeper")) {
                wicketKeeper++;
            }
        }
        //Assertion for atleast one wicket keeper
        Assert.assertTrue(wicketKeeper > 0, "No wicket-keeper found");
    }

}
