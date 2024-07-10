import 'package:android_front/ali_text_field.dart';
import 'package:android_front/profile_page/profile.dart';
import 'package:flutter/material.dart';
import 'package:android_front/workstation_pages/kara.dart';
import 'package:android_front/workstation_pages/sara.dart';
import 'package:android_front/workstation_pages/kelasa.dart';
import 'package:android_front/workstation_pages/khabara.dart';
import 'package:android_front/workstation_pages/tamrina.dart';

import 'base.dart';


class TabParent extends StatelessWidget {
  Base base;
  TabParent({required this.base});

  @override
  Widget build(BuildContext context) {
    return DefaultTabController(
      length: 5,
      child: Scaffold(
        drawer: ElevatedButton(
          child: Icon(Icons.person),
          onPressed: (){
            Navigator.push(
              context,
              MaterialPageRoute(builder: (context) => ProfilePage(base: base)),
            );
          },
        ),
        backgroundColor: Colors.grey.shade100,
        appBar: AppBar(
          bottom: TabBar(
            labelColor: Colors.blueAccent,
            indicatorColor: Colors.blueAccent,
            dividerHeight: 2,
            indicatorSize: TabBarIndicatorSize.tab,
            labelStyle: TextStyle(fontSize: 20),
            tabs: [
              Tab(icon: Icon(Icons.home_outlined, ),
                  child: Text("سرا")),
              Tab(icon: Icon(Icons.task_alt),
              child: Text("کارا"),),
              Tab(icon: Icon(Icons.class_outlined),
                  child: Text("کلاسا")),
              Tab(icon: Icon(Icons.announcement_outlined),
                  child: Text("خبرا")),
              Tab(icon: Icon(Icons.note_alt_outlined),
                  child: Text("تمرینا")),
            ],

          ),
        ),
        body: SingleChildScrollView(
          child: SizedBox(
            height: 2000,
            child: TabBarView(
              children: [
                Sara(base: base,),
                Kara(base: base,),
                Kelasa(),
                Khabara(),
                Tamrina()
              ],
            ),
          ),
        ),
      ),
    );
  }
}
