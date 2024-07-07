import 'package:android_front/tab_parent.dart';
import 'package:flutter/material.dart';
import 'package:android_front/profile_page/profile.dart';
import 'package:android_front/login_page/login.dart';
import 'package:android_front/signup_page/signup.dart';
import 'dart:io';
import 'package:fluttertoast/fluttertoast.dart';

class Base {
  bool isConnected = false;
  //socket sock

  //incomplete
  //connect to 10.0.2.2:port
  static bool connect(String port) {
    return false;
  }

  //incomplete
  //shows related toast notifications and returns false
  //if successful returns true
  static bool login(String s_id, String passwd) {
    Fluttertoast.showToast(msg: "Login methode called!", fontSize: 22);
    return false;
  }

  //incomplete
  //shows related toast notifications and returns false
  //if successful returns true
  static bool signup(String name, String s_id, String u_id,
      String passwd, String passwd2){
    return false;
  }
}

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    Exception e = Exception("hooo!");
    print(e.toString());
    return MaterialApp(
        locale: const Locale('ar', 'AE'),
        debugShowCheckedModeBanner: false,
        theme: ThemeData(
          fontFamily: 'IRANSans', // Set the default font family here
        ),
        title: 'DaneshjooYar',
        home: Builder(
          builder: (BuildContext context) {
            // Get the TextDirection based on the locale
            final TextDirection textDirection = Directionality.of(context);

            //return LoginPage();
            //return const ProfilePage();
            //return SignupPage();
            return TabParent();
          },
        )); //LoginPage());
  }
}
