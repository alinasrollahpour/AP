import 'package:android_front/ali_text_field.dart';
import 'package:flutter/material.dart';
import 'package:android_front/ali_container.dart';

class LoginPage extends StatelessWidget {
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        foregroundColor: Colors.white,
        backgroundColor: Colors.blueAccent,
        title: Center(child: Text('ورود به دانشجویار')),
      ),
      body: Center(
        child: Column(
          children: [
            RoundedContainer(
                backgroundColor: Colors.white,
                child: RoundedTextField(
                  labelText: 'شماره دانشجویی',
                  controller: TextEditingController(),
                  icon: Icon(Icons.account_circle_outlined),
                ))
          ],
        ),
      ),
    );
  }
}
