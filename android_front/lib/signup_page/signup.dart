
import 'package:android_front/ali_text_field.dart';
import 'package:flutter/material.dart';
import 'package:android_front/ali_button.dart';
import 'package:android_front/ali_container.dart';
import 'package:android_front/login_page/number_field.dart';
import 'package:android_front/login_page/password_field.dart';

class SignupPage extends StatelessWidget {
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        foregroundColor: Colors.white,
        backgroundColor: Colors.orangeAccent,
        title: Center(child: Text('ثبت نام در دانشجویار')),
      ),
      body: SingleChildScrollView(
        child: Center(
            child: Column(children: [
              RoundedContainer(
                  backgroundColor: Colors.white,
                  child: Column(
                    children: [
                      Padding(
                          padding: EdgeInsets.fromLTRB(0, 0, 0, 15),
                          child: RoundedTextField(
                            icon: Icon(Icons.text_snippet_outlined),
                            labelText: 'نام و نام خانوادگی',
                            controller: TextEditingController(),
                            textStyle: TextStyle(fontSize: 18),
                          )
                      ),

                      NumberField(
                        labelText: 'شماره دانشجویی',
                        controller: TextEditingController(),
                        icon: Icon(Icons.school_outlined),
                      ),
                      Padding(
                          padding: EdgeInsets.fromLTRB(0, 15, 0, 0),
                          child: RoundedTextField(
                            labelText: 'شناسه کاربری',
                            icon: Icon(Icons.account_circle_outlined),
                          )
                      ),
                      Padding(
                        padding: EdgeInsets.fromLTRB(0, 15, 0, 0),
                        child: PasswordField(
                          labelText: 'گذرواژه',
                          controller: TextEditingController(),
                        ),
                      ),
                      Padding(
                        padding: EdgeInsets.fromLTRB(0, 15, 0, 0),
                        child: PasswordField(
                          labelText: 'تکرار گذرواژه',
                          controller: TextEditingController(),
                        ),
                      )
                    ],
                  )),
              RoundedButton(
                text: "ثبت نام",
                onPressed: () {},
                textColor: Colors.white,
                color: Colors.orangeAccent,
                fontSize: 26,
              ),
              Padding(
                padding: EdgeInsets.all(15),
                child: RoundedButton(
                    text: "بازگشت به صفحه ورود",
                    color: Colors.white70,
                    textColor: Colors.black,
                    onPressed: () {}),
              )
            ])),
      ),
    );
  }
}
