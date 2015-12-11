package fr.i3s.modalis.cosmic.organizational

import fr.i3s.modalis.cosmic.organizational.shared.DataType

/**
  * Created by Cyril Cecchinel - I3S Laboratory on 10/12/2015.
  */
case class Continuous(min:Option[DataType], max:Option[DataType]) extends Range
