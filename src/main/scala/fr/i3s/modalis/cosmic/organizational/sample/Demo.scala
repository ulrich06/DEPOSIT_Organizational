package fr.i3s.modalis.cosmic.organizational.sample

import fr.i3s.modalis.cosmic.organizational.dsl.ObservationPatterns
import fr.i3s.modalis.cosmic.organizational.shared.StringType

/**
 * Example of use
 * Created by Cyril Cecchinel - I3S Laboratory on 10/09/15.
 */
object SmartCampusObservation extends App with ObservationPatterns{

  patterns {

    "test" hasFields( "a" inContinuousRange(None,None),
      "b" inDiscreteRange(StringType("OPENED"), StringType("CLOSED"))) andATimeFieldCalled "t"

    "test2" hasFields( "a" inContinuousRange(None,None),
      "b" inDiscreteRange(StringType("OPENED"), StringType("CLOSED"))) andATimeFieldCalled "t"



  }

  println(this.observations)

}
