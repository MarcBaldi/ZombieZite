package de.htwg.se.zombiezite.aview.gui

import de.htwg.se.zombiezite.controller._
import scala.swing._

class Attack(c: Controller) extends Frame {
  val fieldlength = c.area.line(0)(0).length
  val fields = c.attackableFields(c.actualPlayer)
  val grid = new GridPanel(fields.length + 1, 1) {
    fields.foreach {
      f =>
        var fieldString = "<" + (f.p.x / fieldlength).toString() + ">, <" + (f.p.y / fieldlength).toString() + ">"
        if (f.zombies.isEmpty) {
          fieldString = "Zombieloses Feld " + fieldString
        } else {
          fieldString = f.zombies.length + " Zombies auf " + fieldString
        }
        if (f == fields(0)) {
          contents += Button(fieldString + " (Aktuelles Feld)") {
            c.attackField(c.actualPlayer, f)
            dispose()
          }
        } else {
          contents += Button(fieldString) {
            c.attackField(c.actualPlayer, f)
            dispose()
          }
        }
    }
    contents += Button("Abbrechen") { dispose() }
  }
  contents_=(grid)
  title_=("Angreifbare Felder für " + c.actualPlayer.name)
  visible = true
}