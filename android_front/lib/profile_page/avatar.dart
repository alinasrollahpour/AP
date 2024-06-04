import 'package:flutter/material.dart';

class Avatar extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Stack(alignment: Alignment.center, children: [
      CircleAvatar(
        radius: 100, // This sets the size of the circular avatar
        backgroundImage: AssetImage('assets/l.jpg'), // Path to the local image
      ),
      Positioned(
          top: 140,
          child: Container(
            decoration: BoxDecoration(
              color: Colors.black54,
              border: Border.all(
                color: Colors.black,
                width: 0,
              ),
              borderRadius: BorderRadius.circular(30),
            ),
            child: IconButton(
              icon: Icon(Icons.photo_camera_outlined),
              color: Colors.white,
              iconSize: 25, // Adjust the size of the icon
              onPressed: () {
                // Define your onPressed action here
              },
            ),
          )),
    ]);
  }
}
