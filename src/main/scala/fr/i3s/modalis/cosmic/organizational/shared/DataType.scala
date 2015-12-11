package fr.i3s.modalis.cosmic.organizational.shared

/**
 * Data Type trait
 * Created by Cyril Cecchinel - I3S Laboratory on 03/11/14.
 */
trait DataType {
  val value:Any

}
trait AtomicType extends DataType {
}
trait CompositeType extends DataType {
  val bindings:Map[String, AtomicType]
}
/**
 * Represent Integer values
 */
case class IntegerType(val value:Int) extends AtomicType

/**
 * Represent Double values
 */
case class DoubleType(val value:Double) extends AtomicType

/**
 * Represent Long values
 */
case class LongType(val value:Long) extends AtomicType

/**
 * Represent String values
 */
case class StringType(val value:String) extends AtomicType

/**
 * Represent SmartCampus fr.i3s.modalis.sensordeploiement.language.Sensor Data
 */
case class SmartCampusType(val value:(String, Int, Long)) extends CompositeType {
  val bindings = Map("n" -> new StringType(value._1),
                     "v" -> new IntegerType(value._2),
                     "t" -> new LongType(value._3))
}

/**
 * Represent Santander Parking fr.i3s.modalis.sensordeploiement.language.Sensor Data
 */
case class SantanderParkingType(val value:(Int, String, Double, Int)) extends CompositeType {
  val bindings = Map("nodeId" -> new IntegerType(value._1),
                     "date" -> new StringType(value._2),
                     "battery" -> new DoubleType(value._3),
                     "status" -> new IntegerType(value._4))
}