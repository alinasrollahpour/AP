import 'package:android_front/ali_text_field.dart';
import 'package:android_front/profile_page/Avatar.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:android_front/ali_button.dart';
import 'package:android_front/ali_container.dart';
import 'package:android_front/login_page/number_field.dart';
import 'package:android_front/login_page/password_field.dart';

class ProfilePage extends StatelessWidget {
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.blueAccent,
        title: Center(
          child: Text(
            'اطلاعات کاربری',
            style: TextStyle(color: Colors.white),
          ),
        ),
      ),
      body: Center(
        child: ListView(
          children: [
            Padding(
              padding: const EdgeInsets.all(15.0),
              child: Avatar(),
            ),
            RoundedContainer(
                child: Column(
              children: [
                Row(
                  children: [
                    Expanded(
                      child: RoundedTextField(
                        borderColor: Colors.blueAccent,
                      ),
                    ),
                    Container(
                      width: 80,
                        child: Padding(
                          padding: const EdgeInsets.fromLTRB(15, 0, 0, 0),
                          child: Text('نام دانشجو'),
                        )
                    )],
                )
              ],
            ))
          ],
        ),
      ),
    );
  }
}
