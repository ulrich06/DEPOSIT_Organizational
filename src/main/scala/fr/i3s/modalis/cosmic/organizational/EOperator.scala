package fr.i3s.modalis.cosmic.organizational

/**
 * Concepts related to fields
 * Created by Cyril Cecchinel - I3S Laboratory on 07/09/15.
 */
object EOperator extends Enumeration {
  type EOperator = Value
  val Sampling, Intersection, Union, Offset = Value
}
