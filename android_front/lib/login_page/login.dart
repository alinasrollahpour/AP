import 'package:android_front/tab_parent.dart';
import 'package:flutter/material.dart';
import 'package:android_front/ali_button.dart';
import 'package:android_front/ali_container.dart';
import 'package:android_front/login_page/number_field.dart';
import 'package:android_front/login_page/password_field.dart';
import 'package:android_front/signup_page/signup.dart';
import 'package:android_front/main.dart';
import 'package:fluttertoast/fluttertoast.dart';

import '../base.dart';

class LoginPage extends StatelessWidget {
  Base base;
  TextEditingController sidController = TextEditingController();
  TextEditingController passwdController = TextEditingController();
  LoginPage({required this.base});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        foregroundColor: Colors.white,
        backgroundColor: Colors.blueAccent,
        title: const Center(child: Text('ورود به دانشجویار')),
      ),
      body: Center(
          child: Column(children: [
        RoundedContainer(
            backgroundColor: Colors.white,
            child: Column(
              children: [
                NumberField(
                  labelText: 'شماره دانشجویی',
                  controller: sidController,
                  icon: const Icon(Icons.account_circle_outlined),
                ),
                Padding(
                  padding: const EdgeInsets.fromLTRB(0, 15, 0, 0),
                  child: PasswordField(
                    labelText: 'گذرواژه',
                    controller: passwdController,
                  ),
                )
              ],
            )),
        RoundedButton(
          text: "   ورود   ",
          onPressed: () {
            if (base.login(sidController.text, passwdController.text)){
              print("login successfully");
              Navigator.push(
                context,
                MaterialPageRoute(builder: (context) => TabParent(base: base)),
              );
            }
            },
          textColor: Colors.white,
          color: Colors.blueAccent,
          fontSize: 30,
        ),
        Padding(
          padding: const EdgeInsets.all(15),
          child: RoundedButton(
              text: "حساب کاربری ندارید؟ همین الان بسازید",
              color: Colors.white70,
              textColor: Colors.black,
              onPressed: () {
                Navigator.push(
                  context,
                  MaterialPageRoute(builder: (context) => SignupPage(base: base)),
                );
              }),
        )
      ])),
    );
  }
}
