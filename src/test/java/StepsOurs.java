import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import STD_Classes.Position;
import STD_Classes.Direction;
import STD_Classes.Ship;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class StepsOurs {
	
	Ship ship1 = new Ship();
	Position newPosition ;
	
	@Given("a ship with length {int} and type {string}")
	public void a_ship_with_length_and_type(int int1, String string) {
		 ship1.setLength(int1);
		 ship1.setDirection(Direction.valueOf(string));
	}
	
	



	@When("I am placing the ship on the position {string} {int}")
	public void i_am_placing_the_ship_on_the_position(String s, int int2) {
		newPosition = new Position(s.charAt(0), int2);
		ship1.setPosition(newPosition);
	}
	
	@Then("we check the position")
	public void we_check_the_position() {
		assertTrue(ship1.getPosition().getX() == 'a');
	}

}



