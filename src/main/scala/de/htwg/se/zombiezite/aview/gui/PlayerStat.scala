package de.htwg.se.zombiezite.aview.gui

import de.htwg.se.zombiezite.controller._
import scala.swing._
import scala.swing.event._
import javax.swing._

class PlayerStat(c: Controller) extends GridPanel(10, 1) {
  val axe = "media/weapons/Axe.png"
  val fists = "media/weapons/Fists.png"
  val pistol = "media/weapons/Pistol.png"
  val pan = "media/weapons/Pan.png"
  val shotgun = "media/weapons/Shotgun.png"
  val sniper = "media/weapons/Sniper.png"
  val flame = "media/weapons/Flame Thrower.png"
  val mama = "media/weapons/Big Mama.png"
  val sisters = "media/weapons/EVIL SISTERS.png"
  val gun = "media/weapons/Mashine Gun.png"
  val knife = "media/weapons/Knife.png"

  val maiar = "media/players/F. Maiar Por.png"
  val kawaguchi = "media/players/K. Kawaguchi Por.png"
  val kaiba = "media/players/H. Kaiba Por.png"
  val rainbow = "media/players/P. B. Rainbow Por.png"

  val default = "media/weapons/Default.png"

  contents += new Label {
    c.actualPlayer.name match {
      case "F. Maiar" => {
        icon = new ImageIcon(maiar)
      }
      case "K. Kawaguchi" => {
        icon = new ImageIcon(kawaguchi)
      }
      case "H. Kaiba" => {
        icon = new ImageIcon(kaiba)
      }
      case "P. B. Rainbow" => {
        icon = new ImageIcon(rainbow)
      }
      case _ => {
        icon = new ImageIcon(default)
      }
    }
  }
  contents += new Label(c.actualPlayer.name + " ist am Zug.") {
    font = new Font("Arial", java.awt.Font.HANGING_BASELINE, 15)
  }
  contents += new Label {
    listenTo(this.mouse.wheel)
    listenTo(this.mouse.clicks)
    reactions += {
      case MouseWheelMoved(_, _, _, _) => new ItemInfo(c.actualPlayer.equippedWeapon, "Weapon")
      case MouseClicked(_, _, _, _, _) => c.beweapon(c.actualPlayer, null)
    }
    c.actualPlayer.equippedWeapon.name match {
      case "Axe" => icon = new ImageIcon(axe)
      case "Fist" => icon = new ImageIcon(fists)
      case "Pan" => icon = new ImageIcon(pan)
      case "Flame Thrower" => icon = new ImageIcon(flame)
      case "EVIL SISTERS" => icon = new ImageIcon(sisters)
      case "Big Mama" => icon = new ImageIcon(mama)
      case "Mashine Gun" => icon = new ImageIcon(gun)
      case "Sniper" => icon = new ImageIcon(sniper)
      case "Shotgun" => icon = new ImageIcon(shotgun)
      case "Pistol" => icon = new ImageIcon(pistol)
      case "Knife" => icon = new ImageIcon(knife)
      case _ => icon = new ImageIcon(default)
    }
  }
  contents += new Inventory(c)
  contents += new Label {
    contents += new Label("LP " + c.actualPlayer.lifePoints.toString()) {
      font = new Font("Arial", java.awt.Font.TRUETYPE_FONT, 20)
    }
    contents += new Label("Rüstung " + c.actualPlayer.armor.toString()) {
      font = new Font("Arial", java.awt.Font.TRUETYPE_FONT, 20)
    }
  }
  contents += new Label("Aktionspunkte: " + c.actualPlayer.actionCounter) {
    font = new Font("Arial", java.awt.Font.HANGING_BASELINE, 15)
  }
}