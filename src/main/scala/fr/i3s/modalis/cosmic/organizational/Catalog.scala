package fr.i3s.modalis.cosmic.organizational

/**
  * Created by Cyril Cecchinel - I3S Laboratory on 10/12/2015.
  */
case class Catalog(name:String, root:Container, patterns:Set[Observation]) {


  def getSensors(containerName:String):Set[Sensor] =
    getContainer(containerName).get.getSensors

  def getSensors(observation: Observation): Set[Sensor] = root.getSensors(observation)

  def getSensor(name:String): Option[Sensor] = {
    val lookup = getElement(name)
    lookup match {
      case a:Option[Sensor @unchecked] => a
      case _ => None
    }
  }
  def getContainersName:Set[String] = root.getContainersName

  def getContainer(name:String):Option[Container] = {
    val lookup = getElement(name)
    lookup match {
      case a:Option[Container @unchecked] => a
      case _ => None
    }
  }
  def getContainers(eContainerType: EContainerType.Value): Set[Container] = root.getContainers(eContainerType)

  private def getElement(name:String) = root.lookup(name)
 }
