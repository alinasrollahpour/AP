import 'package:android_front/tab_parent.dart';
import 'package:flutter/material.dart';
import 'package:android_front/profile_page/profile.dart';
import 'package:android_front/login_page/login.dart';
import 'package:android_front/signup_page/signup.dart';
import 'base.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  MyApp({super.key});

  //first time creation of base
  Base base = Base();

  @override
  Widget build(BuildContext context) {
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

            return LoginPage(base: base);
            //return const ProfilePage();
            //return SignupPage();
            //return TabParent();
          },
        )); //LoginPage());
  }
}
