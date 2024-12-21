import 'package:estudo_mobx/controller.dart';
import 'package:flutter/material.dart';
import 'package:flutter_mobx/flutter_mobx.dart';

class Home extends StatefulWidget {
  const Home({super.key});

  @override
  State<Home> createState() => _HomeState();
}

class _HomeState extends State<Home> {

  Controller controller = Controller();
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Container(
        padding: const EdgeInsets.all(16),
        child: Column(
          children: [
            Padding(
              padding: EdgeInsets.all(16.0),
              child: Observer(builder: (_){
                return Text(
                  "${controller.numero}",
                  style: const TextStyle(color: Colors.black, fontSize: 80),
                );
              }),
            ),
            Padding(
              padding: const EdgeInsets.all(16.0),
              child: ElevatedButton(
                  onPressed: controller.incrementar,
                  style: ElevatedButton.styleFrom(
                      backgroundColor: Colors.blue,),
                  child: const Text("Incrementar",
                          style: const TextStyle(color: Colors.white)))
            )
          ],
        ),
      ),
    );
  }
}
