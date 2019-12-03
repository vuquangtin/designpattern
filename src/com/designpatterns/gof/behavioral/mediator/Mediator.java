package com.designpatterns.gof.behavioral.mediator;

interface Mediator {

  void registerFirstPartner(FirstPartner partner);

  void registerSecondPartner(SecondPartner partner);

  String executeFirstPartner();

  String executeSecondPartner();
}