package fr.i3s.modalis.cosmic.organizational

import fr.i3s.modalis.cosmic.organizational.EOperator.EOperator

/**
  * Created by Cyril Cecchinel - I3S Laboratory on 10/12/2015.
  */
case class Calculated(name:String, range:Range, operator:EOperator, operands:Set[Field]) extends Field
