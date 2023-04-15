import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import Model.Board.Board;
import Model.Board.Bomb;
import Model.Board.Direction;
import Model.Board.Position;
import Model.Board.Ship;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class StepsOurs {
	
	Ship Carrier = new Ship ("Carrier");
	Board b = new Board();
	Bomb bomb= new Bomb();
	
	
	@Given("A {string} ship with {string}")
	public void a_ship_with(String string, String string2) {
	    int length = Integer.parseInt(string2);
	    
	}
	@Given("direction {string}")
	public void direction(String string) {
	    
	}
	@When("I am placing the ship on the position {string} {string}")
	public void i_am_placing_the_ship_on_the_position(String string, String string2) {
		int x = Integer.parseInt(string);
		int y = Integer.parseInt(string2);
		
		Carrier.setPosition(x,y);
		
		b.setShip(Carrier.getPosition(), Carrier);
	   
	}
	@Then("The ship is displayed on the board")
	public void the_ship_is_displayed_on_the_board() {
		
		
		
		b.printBoard();
	}
	
	@Given("My board")
	public void my_board() {
	    b.printBoard();
	}
	@When("I am choosing the position to attack {string} {string}")
	public void i_am_choosing_the_position_to_attack(String string, String string2) {
		int x = Integer.parseInt(string);
		int y = Integer.parseInt(string2);
		
		b.setBomb(x,y,bomb);
	}
	@Then("A bomb falls there")
	public void a_bomb_falls_there() {
	    b.printBoard();
	}

	
}






