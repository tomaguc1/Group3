import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Map;

import Model.Position;
import Model.Ship.Ship;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Model.Ship.Ship_Type;
import Model.Ship.Direction;
//import Views.PlaceShips.GridShip.BoardGrid_Panel.Tile;
import Model.Ship.PlaceShipsModel;
import Model.Board.*;
import Model.Player.Kompic;
import Model.Player.PlayerModel;
import Model.Player.PlayerType;
import org.junit.Test;


public class StepsOurs {
	
	
	Board b = new Board();
	private ArrayList<Ship> ships;
	Ship s;
	Ship s1;
	private PlaceShipsModel model;

	private ArrayList<Position> positions;
	private String name;
	private PlayerModel playerModel;
	private PlayerModel playerModel1;
	private Kompic kompic;
	private ArrayList<Ship_Type> types;
	private ArrayList<Ship_Type> types_new;
	
	
	
	//private Kompic type;
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

 	@Given("Two ships {string} and {string}")
 	public void two_ships_and(String string, String string2) {
 		Ship_Type type = Ship_Type.valueOf(string.toUpperCase());
        s = new Ship(type);
        
        Ship_Type type1 = Ship_Type.valueOf(string2.toUpperCase());
        s1 = new Ship(type1);
        
 	}
 	@When("{string} is placed on the position {int} {int}")
 	public void is_placed_on_the_position(String string, int int1, int int2) {
 		b.setShip( new Position(int1,int2),s);
 		assertTrue(b.getBoardElementAtPosition(new Position(int1,int2)) instanceof Ship);
 	}
 	@When("The {string} is placed on the position {int} {int}")
 	public void the_is_placed_on_the_position(String string, int int1, int int2) {
 		
 		b.setShip( new Position(int1,int2),s1);
 		assertTrue(b.getBoardElementAtPosition(new Position(int1,int2)) instanceof Ship);
 	}
 	@Then("the overlap method should return true")
 	public void the_overlap_method_should_return_true() {
 		boolean overlap = s.doesItOverlapWith(s1);
 		assertTrue(overlap);
 	}
 	
 	

 	@Given("{string} on the position {int} {int}")
 	public void on_the_position(String string, int int1, int int2) {
 		Ship_Type type = Ship_Type.valueOf(string.toUpperCase());
        s = new Ship(type);
        b.setShip( new Position(int1,int2),s);
        assertTrue(b.getBoardElementAtPosition(new Position(int1,int2)) instanceof Ship);
 	}
 	@When("I check if the ship is in bounds")
 	public void i_check_if_the_ship_is_in_bounds() {
 		 boolean inBounds = this.s.isInBounds();
       assertTrue(inBounds);
 	}
 	@Then("the player should be allowed to place it and the method returns (true|false)$")
 	public void the_player_should_be_allowed_to_place_it_and_the_method_returns_true(boolean expectedResult) {
 		expectedResult =true;
 		boolean actualResult = this.s.isInBounds();
        assertEquals(expectedResult, actualResult);
 	}
 	
 	@Given("a Board object is created")
 	public void a_board_object_is_created() {
 		ships = new ArrayList<Ship>();
       // Ship shipA = new Ship(Ship_Type.BATTLESHIP);
       // Ship shipB = new Ship(Ship_Type.BATTLESHIP);
       // ships.add(shipA);
      //  ships.add(shipB);
        b = new Board(ships);
 	}
 	@Then("the board array should be initialized with 10x10 WaterElement objects")
 	public void the_board_array_should_be_initialized_with_10x10_water_element_objects() {
 		for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                assertTrue(b.getBoardElementAtPosition(new Position(i, j)) instanceof WaterElement);
            }
        }
 	}

 	@Given("a Board object is created with default constructor")
 	public void a_board_object_is_created_with_default_constructor() {
 	    
 	}
 	@Given("a Position and a Ship object is provided")
 	public void a_position_and_a_ship_object_is_provided() {
 		ships = new ArrayList<Ship>();
        Ship shipA = new Ship(Ship_Type.BATTLESHIP);
         Ship shipB = new Ship(Ship_Type.BATTLESHIP);
        ships.add(shipA);
      ships.add(shipB);
         b = new Board(ships);
 	}
 	@When("the setShip method is called with the Position and Ship object")
 	public void the_set_ship_method_is_called_with_the_position_and_ship_object() {
 	    
 	}
 	@Then("the Ship object should be set at the positions on the Board")
 	public void the_ship_object_should_be_set_at_the_positions_on_the_board() {
 		for (Ship ship : ships) {
            for (Position position : ship.getAllPositions()) {
               assertTrue(b.getBoardElementAtPosition(position) instanceof ShipElement);
            }
 		}
 	}
 		
 		@Given("a Board object is created with {int} ships")
 		public void a_board_object_is_created_with_ships(int int1) {
 			ships = new ArrayList<Ship>();
 			b.setBoardElementTypeAtPosition(new ShipElement(), new Position(2, 3));
 			b.setBoardElementTypeAtPosition(new ShipElement(), new Position(4, 5));
 			b.setBoardElementTypeAtPosition(new ShipElement(), new Position(7, 5));
 			b.setBoardElementTypeAtPosition(new ShipElement(), new Position(7, 2));
 			b.setBoardElementTypeAtPosition(new ShipElement(), new Position(1, 1));
 		}
 		
 		@Then("the total health of all the ships on the Board equal to {int}")
 		public void the_total_health_of_all_the_ships_on_the_board_equal_to(int int1) {
 		    int totalHealth=b.getHealth();
 		    assertEquals(totalHealth, int1);
 		}
 		
 		@Given("a Ship object is created")
 		public void a_ship_object_is_created() {
 		    s  = new Ship(Ship_Type.CARRIER);
 		   
 	      
 		}
 		@When("the object is rotated")
 		public void the_object_is_rotated() {
 			assertEquals(Direction.HORIZONTAL, s.getDirection());
 	        s.rotate();
 		}
 		@Then("the object direction should be updated")
 		public void the_object_direction_should_be_updated() {
 			  assertEquals(Direction.VERTICAL, s.getDirection());
 	 	        s.rotate();
 	 	        assertEquals(Direction.HORIZONTAL, s.getDirection());
 		}
 		
 		@Given("a ship {string} is created")
 		public void a_ship_is_created(String string) {
 			Ship_Type type = Ship_Type.valueOf(string.toUpperCase());
 	        s = new Ship(type);
 		}
 		@When("the objects direction is set")
 		public void the_objects_direction_is_set() {
 			
 	        Direction direction = Direction.VERTICAL;

 	        
 	        this.s.setDirection(direction);

 	        
 		}
 		@When("the position of the ship is set {int} {int}")
 		public void the_position_of_the_ship_is_set(int int1, int int2) {
 			Position position = new Position(int1, int2);
 			this.s.setPosition(position);
 			this.positions = this.s.getAllPositions();
 		}
 		@Then("the function should return a list of all the positions that the Ship takes up on the board.")
 		public void the_function_should_return_a_list_of_all_the_positions_that_the_ship_takes_up_on_the_board() {
 			ArrayList<Position> expectedPositions = new ArrayList<>();
 	        expectedPositions.add(new Position(1, 1));
 	        expectedPositions.add(new Position(1, 2));
 	        expectedPositions.add(new Position(1, 3));
 	        expectedPositions.add(new Position(1, 4));
 	        expectedPositions.add(new Position(1, 5));
 	        //assertEquals(positions, expectedPositions);
 	        assert this.positions.equals(expectedPositions);
 		}
 		@Given("a player name {string}")
 		public void a_player_name(String string) {
 			this.name = string;
 		}
 		@Given("a list of ships of different types and positions")
 		public void a_list_of_ships_of_different_types_and_positions() {
 			this.ships = new ArrayList<>();
 	        ships.add(new Ship(Ship_Type.CARRIER));
 	        ships.add(new Ship(Ship_Type.BATTLESHIP));
 	        
 	        ships.add(new Ship(Ship_Type.SUBMARINE));
 	        ships.add(new Ship(Ship_Type.DESTROYER));
 		}
 		@When("the PlayerModel is created with the given name and list of ships")
 		public void the_player_model_is_created_with_the_given_name_and_list_of_ships() {
 			 this.playerModel = new PlayerModel(name, ships);
 	        this.b = playerModel.board;
 		}
 		@Then("the PlayerModels name should be {string}")
 		public void the_player_models_name_should_be(String string) {
 			
 			assertEquals(string, playerModel.name);
 		}
 		@Then("the PlayerModels ships list should match the given list of ships")
 		public void the_player_models_ships_list_should_match_the_given_list_of_ships() {
 			assertArrayEquals(ships.toArray(), playerModel.ships.toArray());
 		}
 		
 		@Given("a {string} is picked")
 		public void a_is_picked(String string) {
 			Ship_Type type = Ship_Type.valueOf(string.toUpperCase());
 	        s = new Ship(type);
 	        
 		}
 		@When("the {string} is placed on the board")
 		public void the_is_placed_on_the_board(String string) {
 			s.setIsPlaced(true);
 			
 		}
 		@Then("the ship should be saved as placed")
 		public void the_ship_should_be_saved_as_placed() {
 			assertEquals(true, s.getIsPlaced());
 		}
 		
 		@Given("a list of ship types [{string}, {string}, {string}, {string}]")
 		public void a_list_of_ship_types(String string, String string2, String string3, String string4) {
 			types_new = new ArrayList<Ship_Type>();
 	        types_new.add(Ship_Type.CARRIER);
 	        types_new.add(Ship_Type.BATTLESHIP);
 	        types_new.add(Ship_Type.DESTROYER);
 	        types_new.add(Ship_Type.SUBMARINE);

 		}
 		
 		@When("a PlaceShipsModel is created with the ship types")
 		public void a_place_ships_model_is_created_with_the_ship_types() {
 		
 			model = new PlaceShipsModel(types_new);
 	    
 		}
 		@Then("the PlaceShipsModel should be created with empty player name, ships, and unselected ship")
 		public void the_place_ships_model_should_be_created_with_empty_player_name_ships_and_unselected_ship() {
 		 
 			assertEquals("", model.playerName);
 	       
 	        assertFalse(model.isShipSelected);
 		}

 		
}