
import 'package:flutter/material.dart';
import 'package:android_front/ali_button.dart';
import 'package:android_front/ali_container.dart';
import 'package:android_front/login_page/number_field.dart';
import 'package:android_front/login_page/password_field.dart';

class LoginPage extends StatelessWidget {
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        foregroundColor: Colors.white,
        backgroundColor: Colors.blueAccent,
        title: Center(child: Text('ورود به دانشجویار')),
      ),
      body: Center(
          child: Column(children: [
        RoundedContainer(
            backgroundColor: Colors.white,
            child: Column(
              children: [
                NumberField(
                  labelText: 'شماره دانشجویی',
                  controller: TextEditingController(),
                  icon: Icon(Icons.account_circle_outlined),
                ),
                Padding(
                  padding: EdgeInsets.fromLTRB(0, 15, 0, 0),
                  child: PasswordField(
                    labelText: 'گذرواژه',
                    controller: TextEditingController(),
                  ),
                )
              ],
            )),
        RoundedButton(
          text: "   ورود   ",
          onPressed: () {},
          textColor: Colors.white,
          color: Colors.blueAccent,
          fontSize: 30,
        ),
        Padding(
          padding: EdgeInsets.all(15),
          child: RoundedButton(
              text: "حساب کاربری ندارید؟ همین الان بسازید",
              color: Colors.white70,
              textColor: Colors.black,
              onPressed: () {}),
        )
      ])),
    );
  }
}
