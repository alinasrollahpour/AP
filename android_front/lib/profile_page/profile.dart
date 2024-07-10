import 'package:android_front/ali_text_field.dart';
import 'package:android_front/profile_page/Avatar.dart';
import 'package:flutter/material.dart';
import 'package:android_front/ali_button.dart';
import 'package:android_front/ali_container.dart';

import '../base.dart';

class ProfilePage extends StatelessWidget {
  Base base;
  ProfilePage({super.key, required this.base});

  @override
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
              icon: const Icon(Icons.add_a_photo_outlined),
              color: Colors.white,
            ),
            const Expanded(
              child: SizedBox(),
            ),
            const Text(
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
              backgroundColor: Colors.blueAccent.shade100,
                borderWidth: 0,
                child: Column(
              children: [
                const Row(
                  children: [
                    Expanded(
                      child: RoundedTextField(
                        borderColor: Colors.blueAccent,
                      ),
                    ),
                    SizedBox(
                        width: 100,
                        child: Padding(
                          padding: EdgeInsets.fromLTRB(15, 0, 0, 0),
                          child: Text('نام دانشجو'),
                        ))
                  ],
                ),
                const Padding(
                  padding: EdgeInsets.fromLTRB(0, 10, 0, 10),
                  child: Row(
                    children: [
                      Expanded(
                        child: RoundedTextField(
                          borderColor: Colors.blueAccent,
                        ),
                      ),
                      SizedBox(
                          width: 100,
                          child: Padding(
                            padding: EdgeInsets.fromLTRB(15, 0, 0, 0),
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
                        hintText: 'YYYY/MM/DD',
                        borderColor: Colors.blueAccent,
                      ),
                    ),
                    const SizedBox(
                        width: 100,
                        child: Padding(
                          padding: EdgeInsets.fromLTRB(15, 0, 0, 0),
                          child: Text('تاریخ تولد'),
                        ))
                  ],
                ),
              ],
            )),
            Row(
              children: [
                Padding(
                  padding: const EdgeInsets.fromLTRB(15, 0, 0, 0),
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
              padding: EdgeInsets.fromLTRB(0, 0, 0, 0),
              child: RoundedContainer(
                borderWidth: 0,
                  backgroundColor: Colors.grey.shade200,
                  child: Center(
                      child: Text(
                'شماره دانشجویی: 109859793     ترم: 2',
                style: TextStyle(fontSize: 17),
              ))
              ),
            ),
            Center(
              child: Padding(
                padding: const EdgeInsets.fromLTRB(0, 15, 0, 15),
                child: ConstrainedBox(
                    constraints: const BoxConstraints.tightFor(width: 190),
                    child: ElevatedButton(
                        style: ElevatedButton.styleFrom(
                            backgroundColor: Colors.red),
                        onPressed: () {},
                        child: const Padding(
                          padding: EdgeInsets.all(5.0),
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
