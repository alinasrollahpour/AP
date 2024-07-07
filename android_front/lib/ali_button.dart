import 'package:flutter/material.dart';

class RoundedButton extends StatelessWidget {
  final String text;
  final Color color;
  final Color textColor;
  final double borderRadius;
  final VoidCallback onPressed;
  final double fontSize;


  const RoundedButton({
    super.key,
    required this.text,
    required this.color,
    required this.textColor,
    this.borderRadius = 90.0, //completely round
    required this.onPressed,
    this.fontSize = 16,
  });

  @override
  Widget build(BuildContext context) {
    return ElevatedButton(
      onPressed: onPressed,
      style: ElevatedButton.styleFrom(
        backgroundColor: color,
        shape: RoundedRectangleBorder(
          borderRadius: BorderRadius.circular(borderRadius),
        ),
        padding: const EdgeInsets.symmetric(vertical: 15, horizontal: 30),
      ),
      child: Text(
        text,
        style: TextStyle(color: textColor, fontSize: fontSize),
      ),
    );
  }
}
