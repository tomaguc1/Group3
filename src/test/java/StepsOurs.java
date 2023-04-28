import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import Model.Board.Board;
import Model.Position;
import Model.Ship.Ship;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Model.Ship.Ship_Type;
import Model.Ship.PlaceShipsModel;
import Model.Board.*;

public class StepsOurs {
	
	
	Board b = new Board();
	Ship s;
	
	@Given("Player {int} boar view")
	public void player_boar_view(Integer int1) {
	    
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
	
	
}
	/*
	@Given("Player {int} boar view")
	public void player_boar_view(Integer int1) {
	    
	}
	@When("{string} chooses to place a {string}")
	public void chooses_to_place_a(String string, String string2) {
		Ship_Type type = Ship_Type.valueOf(string2.toUpperCase());
        s = new Ship(type);
        
	}
	@Then("{string} has the length {int}")
	public void has_the_length(String string, int int1) {
	    
		assertEquals(s.getLength(),int1);
		
	}
	
}
	
/*	
	Ship s;
	Board b = new Board();
	Bomb bomb= new Bomb();
	int x;
	int y;
	
	//Player player = new Player;
	//Miss miss = new Miss();
	
	@Given("A {string}")
	public void a(String string) {
		s = new Ship (string);

	}

	
	@When("I am placing the ship on the position {string} {string}")
	public void i_am_placing_the_ship_on_the_position(String string, String string2) {
		int x = Integer.parseInt(string);
		int y = Integer.parseInt(string2);
		s.setPosition(x,y);	
		b.setShip(s.getPosition(), s);
	
	}
	
	
	@Then("There should be a ship on the initial position {string} {string}")
	public void there_should_be_a_ship_on_the_initial_position(String string, String string2) {
		int x = Integer.parseInt(string);
		int y = Integer.parseInt(string2);
		assertTrue(b.getBoardElement(new Position(x,y)) instanceof Ship);
	}
	@Then("There should be a ship on the final position  {string} {string}")
	public void there_should_be_a_ship_on_the_final_position(String string, String string2) {
		int xEnd = Integer.parseInt(string);
		int yEnd = Integer.parseInt(string2);
		assertTrue(b.getBoardElement(new Position(xEnd,yEnd)) instanceof Ship);
	}
	
	
	@Given("Two players: {string} and {string}")
	public void two_players_and(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("{string} is finished with setting his ships")
	public void is_finished_with_setting_his_ships(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("{string} can set his ships")
	public void can_set_his_ships(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	
	
	
	
	/*
	
	@Given("My board")
	public void my_board() {
	    b.printBoard();
	}
	@When("I am choosing the position to attack {string} {string}")
	public void i_am_choosing_the_position_to_attack(String string, String string2) {
		int x = Integer.parseInt(string);
		int y = Integer.parseInt(string2);
		
		//b.setBomb(x,y,bomb, miss); ?? Is miss necesarry 
	}
	@Then("A bomb replaces the ship at that position and you can shoot again")
	public void a_bomb_replaces_the_ship_at_that_position_and_you_can_shoot_again() {
	    //how to make it shoot again
		
		b.printBoard();
	}
	
	@Given("I am a player")
	public void i_am_a_player() {
	    Player player = new Player(); //why player cannnot be resolved to a type?
		
	}
	@Then("I have a board view")
	public void i_have_a_board_view() {
	   
		
	}
	
	
	@Given("I have a board")
	public void i_have_a_board() {
	    b.printBoard();

	}
	
	@When("I am choosing the position to attack {string} {string} and there is an obstacle")
	public void i_am_choosing_the_position_to_attack_and_there_is_an_obstacle(String string, String string2) {
		int x = Integer.parseInt(string);
		int y = Integer.parseInt(string2);
		//b.setBomb();
		
	}
	@Then("the obstacle explodes")
	public void the_obstacle_explodes() {
	    
		
		
	}

*/
	







