DEPOSIT Organizational model
============================

Target: **Domain experts**

This is a Scala implementation of the organizational model described [here](https://raw.githubusercontent.com/ILogre/SensorDeployementLanguage/master/AbstractSyntax.png)

A domain expert might use this model to represent her organization (examples bellow), describe her sensors in an intentional way and share out them between her organization.
 
**Example of organizations**

* Building: Building - Floor - Corridor - Open Space - Office
* Roads (US): Freeways - Arterials - Collectors - Local roads
* Parking: Parking - Sector - Parking space

A domain experts might complete ``EContainerType.scala`` with her own vocabulary.

**Demonstration**

``InfraSmartCampus.scala`` presents the description of a Smart Campus located in the SophiaTech campus (France).
It contains the description of a building equipped with sensors.

*Next steps*:
 
 * DSL Integration