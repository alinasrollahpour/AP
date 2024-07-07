import 'package:android_front/ali_text_field.dart';
import 'package:flutter/material.dart';

class TabParent extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return DefaultTabController(
      length: 5,
      child: Scaffold(
        appBar: AppBar(
          bottom: const TabBar(
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
        body: const TabBarView(
          children: [
            Icon(Icons.directions_car),
            Icon(Icons.directions_transit),
            Icon(Icons.directions_bike),
          ],
        ),
      ),
    );
  }
}
