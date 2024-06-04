import 'package:flutter/material.dart';
import 'package:android_front/profile_page/profile.dart';
import 'package:android_front/login_page/login.dart';
import 'package:android_front/signup_page/signup.dart';
import '/ali_button.dart';
import '/ali_text_field.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        debugShowCheckedModeBanner: false,
        theme: ThemeData(
          fontFamily: 'IRANSans', // Set the default font family here
        ),
        title: 'DaneshjooYar',
        home: ProfilePage()); //LoginPage());
  }
}

//old

/*
Scaffold(
          drawer: Drawer(
            shadowColor: Colors.white,
            child: ListView(
              children: <Widget>[
                ListTile(
                  title: Text("New chat"),
                )
              ],
            ),
          ),
          appBar: AppBar(
            toolbarOpacity: 0.3,
            backgroundColor: Colors.blue,
            title: Text(
              'Natzigram',
              style: TextStyle(fontSize: 25, color: Colors.white),
            ),
          ),
          body: Center(
            child: Container(
                child: Column(children: [
              Text(
                "Hile Hitler!",
                style: TextStyle(fontSize: 50, color: Colors.blue),
              ),
             RoundedButton(text: 'Join to army',
                 color: Colors.white,
                 textColor: Colors.black,
                 onPressed: (){}),
              Padding(
                  padding: EdgeInsets.all(11.0),
                  child: RoundedTextField(

                  )),
              ElevatedButton(
                  onPressed: () {},
                  child: Text(
                    'Join party now',
                    style: TextStyle(fontSize: 30, color: Colors.red),
                  ))
            ])),
          ),
        )
*/
