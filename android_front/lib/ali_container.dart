import 'package:flutter/material.dart';

class RoundedContainer extends StatelessWidget {
  final Widget child;
  final double borderRadius;
  final Color borderColor;
  final double borderWidth;
  final Color backgroundColor;
  final EdgeInsetsGeometry padding;
  final EdgeInsetsGeometry margin;

  const RoundedContainer({
    super.key,
    required this.child,
    this.borderRadius = 30.0,
    this.borderColor = Colors.grey,
    this.borderWidth = 1.0,
    this.backgroundColor = Colors.white,
    this.padding = const EdgeInsets.all(15.0),
    this.margin = const EdgeInsets.all(15.0),
  });

  @override
  Widget build(BuildContext context) {
    return Container(
      padding: padding,
      margin: margin,
      decoration: BoxDecoration(
        color: backgroundColor,
        border: Border.all(
          color: borderColor,
          width: borderWidth,
        ),
        borderRadius: BorderRadius.circular(borderRadius),
      ),
      child: child,
    );
  }
}
