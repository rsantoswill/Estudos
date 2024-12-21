import 'package:flutter_mobx/flutter_mobx.dart';
import 'package:mobx/mobx.dart';

class Controller {

  var _numero = Observable(0);

  late Action incrementar; // para usar este método preciso associar ao construtor

  Controller(){
    incrementar = Action(_incrementar);
  }

  int get numero => _numero.value;
  set numero(int valor) => _numero.value = valor;

  _incrementar(){
    numero++;
  }



}