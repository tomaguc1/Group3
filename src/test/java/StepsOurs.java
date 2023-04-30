import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Map;

import Model.Position;
import Model.Ship.Ship;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Model.Ship.Ship_Type;
//import Views.PlaceShips.GridShip.BoardGrid_Panel.Tile;
import Model.Ship.PlaceShipsModel;
import Model.Board.*;
import Model.Player.PlayerModel;



public class StepsOurs {
	
	
	Board b = new Board();
	Ship s;
	
	
	@Given("Player {int} board view")
	public void player_board_view(Integer int1) {
	    
	}
	@When("{string} chooses to place a {string}")
	public void chooses_to_place_a(String string, String string2) {
		Ship_Type type = Ship_Type.valueOf(string2.toUpperCase());
        s = new Ship(type);
        
	}
	
	@Then("{string} has the length {string}")
	public void has_the_length(String string, String string2) {
		int x = Integer.parseInt(string2);
		assertEquals(s.getLength(),x);
	}
	@Given("Player {string} board view")
	public void player_board_view(String string) {
	    
	}
	
	@When("{string} places {string}  on the position {int} {int}")
	public void places_on_the_position(String string, String string2, int int1, int int2) {
		Ship_Type type = Ship_Type.valueOf(string2.toUpperCase());
        s = new Ship(type);
        b.setShip( new Position(int1,int2),s);
        
        
	}
	@Then("there should be a ship on the initial positon {int} {int}")
	public void there_should_be_a_ship_on_the_initial_positon(int int1, int int2) {
 		assertTrue(b.getBoardElementAtPosition(new Position(int1,int2)) instanceof Ship);
 	}
	
	@Given("{string} on the position {int} {int} with health {int}")
 	public void on_the_position_with_health(String string, int int1, int int2, int int3) {
 		Ship_Type type = Ship_Type.valueOf(string.toUpperCase());
         s = new Ship(type);
         b.setShip( new Position(int1,int2),s);
 		assertTrue(b.getBoardElementAtPosition(new Position(int1, int2)) instanceof Ship);
 	}
 	@When("It was hit by a move on the position {int} {int}")
 	public void it_was_hit_by_a_move_on_the_position(int int1, int int2) {
 		//Ship s = (ShipElement) b.getBoardElementAtPosition(new Position(1, 1));
 	    s.setWasHit();
 		assertTrue(s.getWasHit()==true);

 	}
 	@Then("the health is {int}")
 	public void the_health_is(int int1) {
 	   assertEquals(b.getHealth(), int1);
 	}



}

