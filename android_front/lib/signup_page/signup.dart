
import 'package:android_front/ali_text_field.dart';
import 'package:android_front/login_page/login.dart';
import 'package:flutter/material.dart';
import 'package:android_front/ali_button.dart';
import 'package:android_front/ali_container.dart';
import 'package:android_front/login_page/number_field.dart';
import 'package:android_front/login_page/password_field.dart';

class SignupPage extends StatelessWidget {
  const SignupPage({super.key});

  @override
  Widget build(BuildContext context) {

    return Scaffold(
      appBar: AppBar(
        foregroundColor: Colors.white,
        backgroundColor: Colors.orangeAccent,
        title: const Center(child: Text('ثبت نام در دانشجویار')),
      ),
      body: SingleChildScrollView(
        child: Center(
            child: Column(children: [
              RoundedContainer(
                borderColor: Colors.orangeAccent,
                  backgroundColor: Colors.orangeAccent.shade100,
                  child: Column(
                    children: [
                      Padding(
                          padding: const EdgeInsets.fromLTRB(0, 0, 0, 15),
                          child: RoundedTextField(
                            icon: const Icon(Icons.text_snippet_outlined),
                            hintText: 'نام و نام خانوادگی',
                            controller: TextEditingController(),
                            textStyle: const TextStyle(fontSize: 18),
                          )
                      ),

                      NumberField(
                        labelText: 'شماره دانشجویی',
                        controller: TextEditingController(),
                        icon: const Icon(Icons.school_outlined),
                      ),
                      const Padding(
                          padding: EdgeInsets.fromLTRB(0, 15, 0, 0),
                          child: RoundedTextField(
                            hintText: 'شناسه کاربری',
                            icon: Icon(Icons.account_circle_outlined),
                          )
                      ),
                      Padding(
                        padding: const EdgeInsets.fromLTRB(0, 15, 0, 0),
                        child: PasswordField(
                          labelText: 'گذرواژه',
                          controller: TextEditingController(),
                        ),
                      ),
                      Padding(
                        padding: const EdgeInsets.fromLTRB(0, 15, 0, 0),
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
                padding: const EdgeInsets.all(15),
                child: RoundedButton(
                    text: "بازگشت به صفحه ورود",
                    color: Colors.white70,
                    textColor: Colors.black,
                    onPressed: () {Navigator.push(
                      context,
                      MaterialPageRoute(builder: (context) => const LoginPage()),
                    );}),
              )
            ])),
      ),
    );
  }
}
