import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import Model.Board.Board;
import Model.Board.Bomb;
import Model.Board.Direction;
import Model.Board.Player;
import Model.Board.Position;
import Model.Board.Ship;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class StepsOurs {
	
	Ship s;
	
	Board b = new Board();
	Bomb bomb= new Bomb();
	int x;
	int y;
	
	Player p1 = new Player();
	Player p2 = new Player();
    
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
	
	
	@Given("A player with {int} ships")
	public void a_player_with_ships( Integer int1) {
		   p1.AddShip(s);
		   p1.AddShip(s);
		   p1.AddShip(s);
		   p1.AddShip(s);
		   p1.AddShip(s);
		 
	}

	@When("He tries to add another ship")
	public void tries_to_add_another_ship() {
		p1.AddShip(s);
	}

	@Then("He still only has {int} ships")
	public void still_only_has_ships( int int1) {
	    assertEquals(p1.getList().size(), int1);
	}
	
	
	
	@Given("Two players: {string} and {string}")
	public void two_players_and(String string, String string2) {
	    int playerNumber1 =Integer.parseInt(string);
	    int playerNumber2 =Integer.parseInt(string2);
		p1.setNumber(playerNumber1);
		p2.setNumber(playerNumber2);
	}
	
	@When("{string} is finished")
	public void is_finished(String string) {
		   p1.AddShip(s);
		   p1.AddShip(s);
		   p1.AddShip(s);
		   p1.AddShip(s);
		   p1.AddShip(s);
	}

	@Then("{string} has {int} ships")
	public void has_ships(String string, Integer int1) {
		assertEquals(p1.getList().size(),5);
	}

	@Then("{string} can set his ships")
	public void can_set_his_ships(String string) {
		assertTrue(p2.isYourTurn()==true);
	}
	
	
	@Given("Player {string} board view")
	public void player_board_view(String string) {
	   int  playerNumber1 =Integer.parseInt(string);
	   p1.setNumber(playerNumber1);
	   
	}
	
	@Given("there is a ship on the position {string} {string}")
	public void there_is_a_ship_on_the_position(String string, String string2) {
		int x = Integer.parseInt(string);
	    int y = Integer.parseInt(string2);
	    Ship ship= new Ship();
	    ship.setLength(2);
	    ship.setDirection(Direction.VERTICAL);
	    ship.setPosition(x,y);
	    b.setShip(ship.getPosition(), ship);
	    assertTrue(b.getBoardElement(new Position(x,y)) instanceof Ship);
	}
	
	@When("{string} makes a move on the position {string} {string}")
	public void makes_a_move_on_the_position(String string, String string2, String string3) {
		    int x = Integer.parseInt(string);
		    int y = Integer.parseInt(string2);
			b.setBomb(x,y,bomb,p1);
	}

	

	@Then("{string} can make another move")
	public void can_make_another_move(String string) {
		assertTrue(p1.isYourTurn()==true);
	}
	
	
	
/*
	@When("{string} has {int} ships")
	public void has_ships(String string) {
	   p1.AddShip(s);
	   p1.AddShip(s);
	   p1.AddShip(s);
	   p1.AddShip(s);
	   p1.AddShip(s);
	}

	@Then("{string} can set his ships")
	public void can_set_his_ships(String string) {
		assertEquals(p1.getList().size(),5);
		assertTrue(p2.isYourTurn()==true);
	}
	
	
	*/
	
	
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
	
}






