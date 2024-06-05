import 'package:android_front/ali_text_field.dart';
import 'package:android_front/profile_page/Avatar.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:android_front/ali_button.dart';
import 'package:android_front/ali_container.dart';
import 'package:android_front/login_page/number_field.dart';
import 'package:android_front/login_page/password_field.dart';
import 'package:flutter/widgets.dart';

class ProfilePage extends StatelessWidget {
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        toolbarHeight: 80,
        backgroundColor: Colors.blueAccent,
        title: Row(
          children: [
            Padding(
              padding: const EdgeInsets.fromLTRB(0, 0, 0, 0),
              child: Avatar(),
            ),
            IconButton(
              onPressed: () {},
              icon: Icon(Icons.add_a_photo_outlined),
              color: Colors.white,
            ),
            Expanded(
              child: SizedBox(),
            ),
            Text(
              'اطلاعات کاربری',
              style: TextStyle(color: Colors.white),
            )
          ],
        ),
      ),
      body: Center(
        child: ListView(
          children: [
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
                        width: 100,
                        child: Padding(
                          padding: const EdgeInsets.fromLTRB(15, 0, 0, 0),
                          child: Text('نام دانشجو'),
                        ))
                  ],
                ),
                Padding(
                  padding: const EdgeInsets.fromLTRB(0, 10, 0, 10),
                  child: Row(
                    children: [
                      Expanded(
                        child: RoundedTextField(
                          borderColor: Colors.blueAccent,
                        ),
                      ),
                      Container(
                          width: 100,
                          child: Padding(
                            padding: const EdgeInsets.fromLTRB(15, 0, 0, 0),
                            child: Text('شناسه کاربری'),
                          ))
                    ],
                  ),
                ),
                Row(
                  children: [
                    Expanded(
                      child: RoundedTextField(
                        controller: TextEditingController(),
                        labelText: 'YYYY/MM/DD',
                        borderColor: Colors.blueAccent,
                      ),
                    ),
                    Container(
                        width: 100,
                        child: Padding(
                          padding: const EdgeInsets.fromLTRB(15, 0, 0, 0),
                          child: Text('تاریخ تولد'),
                        ))
                  ],
                ),
              ],
            )),
            Row(
              children: [
                Padding(
                  padding: EdgeInsets.fromLTRB(15, 0, 0, 0),
                  child: RoundedButton(
                      text: 'تغییر گذرواژه',
                      color: Colors.orange,
                      textColor: Colors.white,
                      onPressed: () {}),
                ),
                Expanded(
                    child: Padding(
                  padding: const EdgeInsets.fromLTRB(15, 0, 15, 0),
                  child: RoundedButton(
                      text: 'اعمال تغییرات',
                      color: Colors.blueAccent,
                      textColor: Colors.white,
                      onPressed: () {}),
                )),
              ],
            ),
            Padding(
              padding: const EdgeInsets.fromLTRB(0, 0, 0, 0),
              child: RoundedContainer(
                  child: Center(
                      child: Text(
                'شماره دانشجویی: 109859793     ترم: 2',
                style: TextStyle(fontSize: 17),
              ))),
            ),
            Center(
              child: Padding(
                padding: const EdgeInsets.fromLTRB(0, 15, 0, 15),
                child: ConstrainedBox(
                    constraints: BoxConstraints.tightFor(width: 190),
                    child: ElevatedButton(
                        style: ElevatedButton.styleFrom(
                            backgroundColor: Colors.red),
                        onPressed: () {},
                        child: Padding(
                          padding: const EdgeInsets.all(5.0),
                          child: Row(
                            children: [
                              Icon(
                                size: 40,
                                Icons.delete_forever_outlined,
                                color: Colors.white,
                              ),
                              Text(
                                'حذف حساب',
                                style:
                                    TextStyle(color: Colors.white, fontSize: 18),
                              )
                            ],
                          ),
                        ))),
              ),
            )
          ],
        ),
      ),
    );
  }
}
