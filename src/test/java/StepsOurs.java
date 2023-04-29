import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

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
	Position position;
	ArrayList<Ship> shipArray;
	int shipLength;
	
	
	@Given("Player {int} with some ships")
	public void player_with_some_ships(Integer int1)  {
		this.shipArray = new ArrayList<Ship>();
	    PlayerModel player = new PlayerModel("Player" + int1, shipArray);
		for (Ship_Type type : Ship_Type.values()) {
			shipArray.add(new Ship(type));
		}
	}
	@When("{int} chooses to place a {string} of length")
	public void chooses_to_place_a_of_length(Integer int1, String string) {
		for (Ship ship : shipArray) {
			if (ship.getShipType().toString().equals(shipType)) {
				this.s = ship;
				shipLength = ship.getShipType().length();
				
			} else {
				continue;
			}
		}                
	}

	@Then("Has the appropiate length")
	public void has_the_appropiate_length() {
		
		assertEquals(s.getLength(),this.shipLength);
	}
	
	@Given("Player {int} with some ships")
	public void player_with_ships_to_place(Integer int1) {
		this.shipArray = new ArrayList<Ship>();
	    PlayerModel player = new PlayerModel("Player" + int1, shipArray);
		for (Ship_Type type : Ship_Type.values()) {
			shipArray.add(new Ship(type));
		}
	}
	@When("places on the position {int} {int}")
	public void places_on_the_position(Integer int1, Integer int2)  {
		
        this.s = this.shipArray.get(0);
        b.setShip( new Position(int1,int2),s);
        
        
	}
	@Then("there should be a ship on the positon {int} {int}")
	public void there_should_be_a_ship_on_the_positon(int int1, int int2) {
		assertTrue(b.getBoardElementAtPosition(new Position(int1,int2)) instanceof ShipElement);
	}

	@Given("{string} on the position {int} {int} with health {int}")
	public void on_the_position_with_health(String string, Integer int1, Integer int2, Integer int3) {
		//Ship_Type type = Ship_Type.valueOf(string.toUpperCase());
        //s = new Ship(type);
        //b.setShip( new Position(int1,int2),s);
		this.position = new Position(int1, int2);
		b.setBoardElementTypeAtPosition(shipElement, position);
		assertTrue(b.getBoardElementAtPosition(position) instanceof ShipElement);
		throw new io.cucumber.java.PendingException();
	}
	@When("It was hit by a move on the position {int} {int}")
	public void it_was_hit_by_a_move_on_the_position(int int1, int int2) {
			
		this.position = new Position(int1, int2);
		ShipElement shipElement = (ShipElement) b.getBoardElementAtPosition(this.position);
		//Ship s = (ShipElement) b.getBoardElementAtPosition(new Position(1, 1));
	    shipElement.setWasHit();
		assertTrue(shipElement.getWasHit()==true);
	   
	}
	@Then("the health is {int}")
	public void the_health_is(int int3) {
	   assertEquals(b.getHealth(), int3 -1);
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
	







