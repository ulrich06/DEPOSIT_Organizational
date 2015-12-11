package fr.i3s.modalis.cosmic.organizational

/**
 * Concepts related to sensors
 * Created by Cyril Cecchinel - I3S Laboratory on 07/09/15.
 */
trait Sensor extends Containable {
  val uri:String
  val observes:Observation
}
case class EventBased(name:String, trigger:String, uri:String, observes:Observation) extends Sensor
case class Periodic(name:String, period:Int, uri:String, observes:Observation) extends Sensor
