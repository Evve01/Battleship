package danil;

/**
 * @author Danil Kolesnikov danil.kolesnikov@sjsu.edu
 * @author Minh Phan minh.phan@sjsu.edu
 * CS 151 HW4 Fall 2017
 */

public class EndOfTheGame implements GameState {
    private BattleShip battleShip;

    EndOfTheGame(BattleShip battleShip){
        this.battleShip = battleShip;
    }

    public void player1Turn (){
        System.out.println("end of the game player 1 ");
        System.out.println("if player 1 win, switch to beginning of the game ");
        //if statement to switch
        //battleShip.setState(battleShip.getBeginningOfTheGame());

    }
    public void player2turn (){
        System.out.println("end of the game player 2 ");
        System.out.println("if player 2 win, switch to beginning of the game ");
        //if statement to switch
        //battleShip.setState(battleShip.getBeginningOfTheGame());
    }
}