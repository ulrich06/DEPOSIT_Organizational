package fr.i3s.modalis.cosmic.organizational

import fr.i3s.modalis.cosmic.organizational.shared.DataType

/**
  * Created by Cyril Cecchinel - I3S Laboratory on 10/12/2015.
  */
case class Discrete(values:Set[DataType]) extends Range {
  assert(values.size > 1) //TODO: Find a prettier way to implement this constrain
}
