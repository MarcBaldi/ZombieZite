package de.htwg.se.zombiezite.model

trait Character {
  var lifePoints: Int
  val strength: Int
  val range: Int
  var actualField: Field
  var equippedWeapon: Item= Weapon("Fist", 1, 0)
  var kritchance = 20
  var armor = 0
  val area: Area
  
  def walk(x: Int, y: Int): Boolean = {
    if (actualField.p.x / actualField.length + x < 0 || actualField.p.x / actualField.length + x > area.breite - 1) {
      return false
    }
    if (actualField.p.y / actualField.length + y < 0 || actualField.p.y / 2 + y > area.laenge - 1) {
      return false
    }
    leaveField()
    actualField = area.line(actualField.p.x / actualField.length + x)(actualField.p.y / actualField.length + y)
    enterField()
    return true
  }
  def attack(critRand: Int): Int = {
    var dmg = strength + equippedWeapon.strength
    critRand match {
      case 1 => {
        println("\nKRITISCHER TREFFER!")
        return dmg * 2
      }
      case _ => return dmg
    }
  }
  def die(): String
  def leaveField()
  def enterField()
}