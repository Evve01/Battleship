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
}

class BeginningOfTheGame

class Coordinate

class EndOfTheGame

interface GameState

class JPanel

class MiddleOfTheGame

class PlayerData

class PlayerScreen

class SelfGrid

class Ship



BattleGrid <|-- AttackGrid

BattleShip <-- AttackGrid

GameState <|.. BattleShip
GameState <-- BattleShip

JPanel <-- AttackGrid
JPanel <|-- BattleGrid
JPanel <-- BattleGrid

PlayerData <-- BattleShip

PlayerScreen <-- AttackGrid
PlayerScreen <-- BattleShip
@enduml