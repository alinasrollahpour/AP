import 'dart:io';

import 'package:fluttertoast/fluttertoast.dart';

import 'classes/Assignment.dart';
import 'classes/Course.dart';
import 'classes/Student.dart';
import 'classes/Teacher.dart';

class Base {

  bool isConnected = false;
  bool loggedIn = false;
  late Student student;
  late Set<Course> courses;
  late Set<Teacher> teachers;
  late Set<Assignment> assignments;

  late Socket socket;
  final String host = '10.0.2.2';
  final int port = 8080;


  //incomplete
  //do all nessecary jobs at startup
  //including connecting and setting miniProject objects
  Base(){
    //todo
  }
  //incomplete
  //connect to 10.0.2.2:port
  Future<bool> connect() async {
    try {
      final Socket socket = await Socket.connect(host, port);
      print('Connected to: ${socket.remoteAddress.address}:${socket.remotePort}');

      // Listen for responses from the server
      socket.listen(
            (List<int> event) {
          print('Server: ${String.fromCharCodes(event)}');
        },
        onError: (error) {
          print('Error: $error');
          socket.destroy();
        },
        onDone: () {
          print('Server closed the connection');
          socket.destroy();
        },
      );

    } catch (e) {
      print('Unable to connect: $e');
    }
    return false;
  }

  Future<void> disconnect() async{
    await socket.flush();
    await socket.close();
  }

  //incomplete
  //shows related toast notifications and returns false
  //if successful returns true
  bool login(String s_id, String passwd) {
    Fluttertoast.showToast(msg: "Logged in successfully!", fontSize: 22);
    //temp
    return true;
  }

  //incomplete
  //shows related toast notifications and returns false
  //if successful returns true
  bool signup(String name, String s_id, String u_id,
      String passwd, String passwd2){
    return false;
  }

  double getWorstScore() {
    return 0.0; //todo
  }
  double getBestScore() {
    return 0.0; //todo
  }
  int getAssigmentCount() {
    return 0; //todo
  }
  int getLostAssignment() {
    return 0; //todo
  }
  
}