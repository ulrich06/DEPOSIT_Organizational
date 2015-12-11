package fr.i3s.modalis.cosmic.organizational

import fr.i3s.modalis.cosmic.organizational.EContainerType.EContainerType

/**
  * Created by Cyril Cecchinel - I3S Laboratory on 10/12/2015.
  */
case class Container(name:String, cType:EContainerType, contains:Set[Containable] = Set.empty) extends Containable {

  def lookup(what:String):Option[Containable] = {

    if (contains.map{_.name} contains what) contains find {_.name equals what}
    else {
      var result:Option[Containable] = None
      contains.collect {case p:Container => p}.toStream.takeWhile(_ => result.isEmpty).foreach(i => result = i.lookup(what))
      result
    }
  }

  def getContainers(eContainerType: EContainerType.Value): Set[Container] = {
    this.contains.collect {case x:Container if x.cType == eContainerType => x} ++ this.contains.collect {case x:Container => x}.flatMap{_.getContainers(eContainerType)} ++ (if (this.cType == eContainerType) Set(this) else Set())
  }

  def getSensors:Set[Sensor] = {
    this.contains.collect {case x:Sensor => x} ++ this.contains.collect {case x:Container => x}.flatMap {_.getSensors}
  }

  def getSensors(observation: Observation):Set[Sensor] = {
    this.contains.collect {case x:Sensor if x.observes equals observation => x} ++ this.contains.collect {case x:Container => x}.flatMap{_.getSensors(observation)}
  }

  def getContainersName:Set[String] =
    Set(this.name) ++ this.contains.collect {case x:Container => x}.flatMap {_.getContainersName}
}
