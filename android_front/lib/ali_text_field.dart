import 'package:flutter/material.dart';

class RoundedTextField extends StatelessWidget {
  final TextEditingController? controller;
  final String? hintText;
  final Color borderColor;
  final double borderRadius;
  final Color fillColor;
  final TextStyle? textStyle;
  final TextStyle? labelStyle;
  final EdgeInsetsGeometry contentPadding;
  final Icon? icon;
  final bool obscureText;

  const RoundedTextField({
    super.key,
    this.controller,
    this.hintText,
    this.borderColor = Colors.grey,
    this.borderRadius = 30.0,
    this.fillColor = Colors.white,
    this.textStyle,
    this.labelStyle,
    this.contentPadding = const EdgeInsets.symmetric(vertical: 15, horizontal: 20),
    this.icon,
    this.obscureText = false,
  });

  @override
  Widget build(BuildContext context) {
    return TextField(
      controller: controller,
      style: textStyle,
      obscureText: obscureText,
      decoration: InputDecoration(
        hintText: hintText,
        labelStyle: labelStyle,
        fillColor: fillColor,
        contentPadding: contentPadding,
        filled: true,
        border: OutlineInputBorder(
          borderRadius: BorderRadius.circular(borderRadius),
          borderSide: BorderSide(color: borderColor)
        ),
        enabledBorder: OutlineInputBorder(
          borderRadius: BorderRadius.circular(borderRadius),
          borderSide: BorderSide(color: borderColor),
        ),
        focusedBorder: OutlineInputBorder(
          borderRadius: BorderRadius.circular(borderRadius),
          borderSide: BorderSide(color: borderColor),
        ),
        prefixIcon: icon,
      ),
    );
  }
}
