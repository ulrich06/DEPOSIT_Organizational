package fr.i3s.modalis.cosmic.organizational.dsl

import fr.i3s.modalis.cosmic.organizational._
import fr.i3s.modalis.cosmic.organizational.shared.{DataType, IntegerType}

/**
 * DSL definition
 * Created by Cyril Cecchinel - I3S Laboratory on 10/09/15.
 */
trait ObservationPatterns {
  import scala.language.implicitConversions

  var observations: Set[Observation] = Set()
  var currentObservation:Observation = _

  def patterns(observations: => Unit) {
    observations
    saveCurrentObservation()
  }

  private def saveCurrentObservation() {
    if(currentObservation != null)
      observations += currentObservation
    currentObservation = null
  }

  protected case class ObservationBuilder(name:String = "", fields:Set[Field] = Set(), timeField:AtomicField = null) {
    //def hasFields(f:FieldBuilder *) = this.copy(fields = f.toSet.map {FieldBuilder2Field})
    def hasFields(f:FieldBuilder *) = {val updated = this.copy(fields = f.toSet.map {FieldBuilder2Field}); currentObservation = updated; updated}
    def andATimeFieldCalled(n:String) = {
      val timeRange = AtomicField(n, Continuous(Some(IntegerType(0)), None))
      this.copy(timeField = timeRange)
    }
  }


  protected case class FieldBuilder(name:String = "", range:Range = null, fieldType:String = "atomic", rangeType:String = "") {
    def inDiscreteRange(values:DataType *) =  this.copy(range = new Discrete(values.toSet))
    def inContinuousRange(minv:Option[DataType], maxv:Option[DataType]) = this.copy(range = new Continuous(minv, maxv))

  }


  implicit protected def ObservationBuilder2Observation(builder:ObservationBuilder):Observation = {
    new Observation(builder.name, builder.timeField, builder.fields)
  }

  implicit def str2ObservationBuilder(s: String): ObservationBuilder = {
    saveCurrentObservation()
    ObservationBuilder(name = s)
  }



  implicit def str2FieldBuilder(s:String):FieldBuilder = {
    FieldBuilder(name = s)
  }

  implicit protected def FieldBuilder2Field(builder:FieldBuilder): Field = {
      //TODO: calculated fields
    new AtomicField(builder.name, builder.range)
  }

}
