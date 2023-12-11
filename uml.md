```puml
@startuml
class AttackGrid {
    - name : String
    - enemyShipSunkPlayer1 : int
    - enemyShipSunkPlayer2 : int
    - isAttackGridListener : boolean
    - battleShip : BattleShip
    - player : PlayerScreen
    - thePanel : JPanel
    
    + AttackGrid(name : String, battelShip : BattleShip, player : PlayerScreen)
    # getCell() : JPanel
    +setAttackGridListener(attackGridListener : boolean)) : void
    + getJPanel(newPoint : Point) : void
    + draw() : void
    + numberToPanel(s : int) : int
    + getAttackGridListener() : boolean
}

abstract class BattleGrid {
    - temp : JPanel
    ~ self : JPanel
    
    + BattleGrid()
    + getComponentAt(p : Point) : JPanel
    # {abstract} getCell() : JPanel
}

class BattleShip {
    - begginingOfGame : GameState
    - middleOfGame : GameState
    - endOfGame : GameState
    - state : GameState
    - takeTurnAttack : boolean
    - player1Data : PlayerData
    - player2Data : PlayerData
    - player1 : PlayerScreen
    - player2 : PlayerScreen
    
    + BattleShip()
    + {static} main(args : String[]) : void
    + player1Turn() : void
    + player2Turn() : void
    + getMiddleOfTheGame() : GameState
    + getEndOfGame() : GameState
    + setState(state : GameState) : void
    + setTakeTurnAttack(isPlayerTurn : boolean) : void
    + getTakeTurnAttack() : boolean
    + getPlayer2Data() : PlayerData
    + getPlayer1Data() : PlayerData
    + getPlayer1() : PlayerScreen
    + getPlayer2() : PlayerScreen
}

class BeginningOfTheGame {
    - battleShip : BattleShip
    - player1 : PlayerScreen
    - player2 : PlayerScreen
    
    ~ BeginningOfTheGam(battleShip: BattleShip, player1 : PlayerScreen, player2 : PlayerScreen)
    + player1Turn() : void
    + player2Turn() : void
}

class Coordinate {
    ~ x : int
    ~ y : int
    
    + Coordinate(x : int, y : int)
    + getX() : int
    + getY() : int
    + compareCoord(coordinate : Coordinate) : boolean
    + toString() : String
}

class EndOfTheGame {
    - battleShip : BattleShip
    - player1 : PlayerScreen
    - player2 : PlayerScreen
    
    ~ EndOfTheGame(battleShip: BattleShip, player1 : PlayerScreen, player2 : PlayerScreen)
    + player1Turn() : void
    + player2Turn() : void
}

interface GameState {
    player1Turn() : void
    player2Turn() : void
}

class JPanel

class MiddleOfTheGame {
    - battleShip : BattleShip
    - player1 : PlayerScreen
    - player2 : PlayerScreen
    
    ~ MiddleOfTheGame(battleShip: BattleShip, player1 : PlayerScreen, player2 : PlayerScreen)
    + player1Turn() : void
    + player2Turn() : void
}

class PlayerData {
    - player : PlayerScreen
    - attackData : int[][]
    - selfData : int[][]
    - numberOfShipsSunk : int
    - fleet : ArraList<Ship>
    
    ~ PlayerData(player : PlayerScreen)
    + addShip(a : Coordinate, b : Coordinate, c : Coordinate): void
    + deleteShip(a : Coordinate, b : Coordinate, c : Coordinate) : void
    + deleteShipInSelfGrid(a : Coordinate, b : Coordinate, c : Coordinate) : void
    + addShipInSelfGrid(a : Coordinate, b : Coordinate, c : Coordinate) : void
    + addVerticalShip(a : Coordinate, b : Coordinate, c : Coordinate) : void
    + attackShip(Coordinate : hitCord) : void
    + shipsLeft() : int
    + setAttackData(x : int, y : int, result : String) : void
    + setSelfData(a, : Coordinate, b : Coordinate, c : Coordinate) : void
    + getNumberOfOwnShipSunk() : int
    + getFleet() : ArrayList<Ship>
    + getSelfData() : int[][]
    + getAttackData() : int[][]
    + getDataFromCell(x : int, y : int) : int
    + isHit(point : Coordinate) : boolean
    + isPlayerLost() : boolean
    + isSunk(hitCord : Coordinate) : boolean
    + isOverlapAtRotatePoint(a : Coordinate, b : Coordinate, c : Coordinate) : boolean
    + isEdge(a : Coordinate, b : Coordinate, c : Coordinate) : boolean
    + isShipCollision(a : Coordinate, b : Coordinate, c : Coordinate) : boolean
    + isOverlap(a : Coordinate, b : Coordinate, c : Coordinate) : boolean
    + printSelfData() : void
    + printAttackData() : void
}

class PlayerScreen {
    ~ size : int
    ~ isBeginningOfTheGameOfPlayer1 : boolean
    ~ isBeginningOfTheGameOfPlayer2 : boolean
    ~ battleShip : BattleShip
    ~ ownShipSunk : JLabel
    ~ shipBeginning : JLabel
    ~ enemyShipSunk : JLabel
    
    + PlayerScreen(name : String, show : boolean, battleShip : BattelShip)
    + showScreen() : void
    + hideScreen() : void
    + getSelfGrid() : SelfGrid
    + getAttackGrid() : AttackGrid
    + getNextButton() : JButton
    getIsBeginningOfTheGameOfPlayer2() : boolean
}

class SelfGrid {
    - gridType : String
    - isSelfGridListener : boolean
    - NUMBER_OF_SHIP : int
    - count : int
    - name : String
    - firstPoint : Point
    - secondNextPoint : Point
    - secondNextCell : JPanel
    - thirdNextPoint : Point
    - thirdNextCell : JPanel
    - battleShip : BattleShip
    - thePanel : JPanel
    
    + SelfGrid(name : String, battleShip : BattleShip)
    + getJPanel(newPoint : Point) : void
    + getComp2(newPoint : Point) : void
    + getComp3(newPoint : Point) : void
    # getCell() : JPanel
    + setSelfGridListener(selfGridListener : boolean) : void
    + draw() : void
    + numberToPanel(s : int) : int
    + getSelfGridListener() : boolean
    + getGridType() : String
}

class Ship {
    a : Coordinate
    b : Coordinate
    c : Coordinate
    aHit : boolean
    bHit : boolean
    cHit : boolean
    
    ~ Ship(a : Coordinate, b : Coordinate, c : Coordinate)
    + compareShip(ship : Ship) : boolean
    + getA() : Coordinate
    + getB() : Coordinate
    + getC() : Coordinate
    + isPointHit(hit : Coordinate) : boolean
    + Hit(hit : Coordinate) : void
    + isShipSunk() : boolean
    + printShip() : void
}

BattleGrid <|-- AttackGrid
BattleGrid <|-- SelfGrid

BattleShip <-- AttackGrid
BattleShip <-- BeginningOfTheGame
BattleShip <-- EndOfTheGame
BattleShip <-- MiddleOfTheGame
BattleShip <-- PlayerScreen
BattleShip <-- SelfGrid

Coordinate <.. PlayerData
Coordinate <-- Ship

GameState <|.. BattleShip
GameState <-- BattleShip
GameState <|.. BeginningOfTheGame
GameState <|.. EndOfTheGame
GameState <|.. MiddleOfTheGame

JFrame <|-- PlayerScreen

JPanel <-- AttackGrid
JPanel <|-- BattleGrid
JPanel <-- BattleGrid
JPanel <-- SelfGrid

PlayerData <-- BattleShip

PlayerScreen <-- AttackGrid
PlayerScreen <-- BattleShip
PlayerScreen <-- BeginningOfTheGame
PlayerScreen <-- EndOfTheGame
PlayerScreen <-- MiddleOfTheGame
PlayerScreen <-- PlayerData

Ship <-- PlayerData
@enduml