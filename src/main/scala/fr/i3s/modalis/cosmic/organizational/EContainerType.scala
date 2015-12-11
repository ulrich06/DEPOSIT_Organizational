package fr.i3s.modalis.cosmic.organizational

/**
 * Concepts related to containers
 * Created by Cyril Cecchinel - I3S Laboratory on 07/09/15.
 */
object EContainerType extends Enumeration {
  type EContainerType = Value
  val Building, Floor, Corridor, Room, Campus, Parking, OpenSpace, Unknown = Value
}
