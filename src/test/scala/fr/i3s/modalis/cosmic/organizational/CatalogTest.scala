package fr.i3s.modalis.cosmic.organizational

import fr.i3s.modalis.cosmic.organizational.sample.InfraSmartCampus
import org.specs2.mutable.SpecificationWithJUnit

/**
  * Created by Cyril Cecchinel - I3S Laboratory on 10/12/2015.
  */
class CatalogTest extends SpecificationWithJUnit {



  "A catalog" should {
    val catalog = InfraSmartCampus.catalog

    "have a name" in {
      catalog.name must be equalTo "SmartCampus"
    }

    "return sensors contained in a container" in {
      catalog.getSensors("Modalis corridor").map(_.name) must be equalTo  Set("Window_Modalis", "TEMP_CORRIDOR", "NOISE_SPARKS_CORRIDOR", "TEMP_442V", "DOOR443STATE", "TEMP_443V", "AC_443", "WINDOW443STATE", "PRESENCE_443", "Coffee_power", "Office_443_Power", "TEMP_444V", "LIGHT_444", "TEMP_445V", "TEMP_449V")
    }

    "return sensors handling a specific observation" in {
      catalog.getSensors(InfraSmartCampus.SC_light).map(_.name) must be equalTo Set("LIGHT_CAFE", "LIGHT_444")
    }

    "return a specific sensor" in {
      catalog.getSensor("DOOR443STATE") must beSome
      catalog.getSensor("WrongSensorName") must beNone
    }



    "return a specific container" in {
      catalog.getContainer("Office 443") must beSome
      catalog.getContainer("WrongContainerName") must beNone
    }

    "return containers with a specific type" in {
      catalog.getContainers(EContainerType.Room).map{_.name} must be equalTo Set("Sous repartiteur", "Office 442", "Office 443", "Office 444", "Office 445", "Office 449")
      catalog.getContainers(EContainerType.Campus).map{_.name} must be equalTo Set("Campus SophiaTech")

    }
  }

  "A container" should {

    val container = InfraSmartCampus.infrastructure

    "find inner elements" in {
      container.lookup("4th floor") must beSome
      container.lookup("DOOR443STATE") must beSome
      container.lookup("NonExistingElement") must beNone
    }

    "return the list of containers name" in {
      container.getContainersName must be equalTo Set("Campus SophiaTech", "Templiers Ouest", "4th floor", "Coffee corner", "Sous repartiteur", "Modalis corridor", "Office 442", "Office 443", "Office 444", "Office 445", "Office 449")
    }
  }

}
