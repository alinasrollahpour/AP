import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

import '../ali_container.dart';
import '../base.dart';

class Sara extends StatelessWidget {
  late double widthScr;
  late double heightScr;
  Base base;
  Sara({required this.base});

  @override
  Widget build(BuildContext context) {
    widthScr = MediaQuery.of(context).size.width;
    heightScr = MediaQuery.of(context).size.width;
    return Column(
      children: [
        SizedBox(
          height: 15,
        ),
        Text(
          'خلاصه',
          style: TextStyle(fontSize: 26),
        ),
        summary(context),
        line(context),
        Text(
          'کارهای جاری',
          style: TextStyle(fontSize: 26),
        ),
        currentJobs(context),
        line(context),
        Text(
          'تمرین های انجام شده',
          style: TextStyle(fontSize: 26),
        ),
        done(context)
      ],
    );
  }

  //widgets#############
  Widget summary(BuildContext context) {
    return Column(
      children: [
        Center(
          child: Row(
            children: [best_score(context), worst_score(context)],
          ),
        ),
        Row(
          children: [lost_deadlines(context), assignments(context)],
        )
      ],
    );
  }

  Widget currentJobs(BuildContext context) {
    //temporary
    String text1 = 'وظیفه1';
    String text2 = 'وظیفه2';
    return Column(
      children: [job(context, text1), job(context, text2)],
    );
  }

  Widget done(BuildContext context) {
    //temporary
    String text1 = 'تمرین 1';
    String text2 = 'تمرین 2';
    return Row(
      children: [
        done_assignment(context, text1),
        done_assignment(context, text2)
      ],
    );
  }

  //inner widgets#########
  Widget worst_score(BuildContext context) {
    return SizedBox(
      width: widthScr / 2,
      child: RoundedContainer(
        child: Column(
          children: [
            Icon(
              Icons.trending_down_outlined,
              color: Colors.brown,
              size: 40,
            ),
            Text(
              'بدترین نمره',
              style: TextStyle(fontSize: 20),
            )
          ],
        ),
      ),
    );
  }

  Widget best_score(BuildContext context) {
    return SizedBox(
      width: widthScr / 2,
      child: RoundedContainer(
        child: Column(
          children: [
            Icon(
              Icons.stars_sharp,
              color: Colors.yellow.shade800,
              size: 40,
            ),
            Text(
              'بهترین نمره',
              style: TextStyle(fontSize: 20),
            )
          ],
        ),
      ),
    );
  }

  Widget assignments(BuildContext context) {
    return SizedBox(
      width: widthScr / 2,
      child: RoundedContainer(
        child: Column(
          children: [
            Icon(
              Icons.upcoming_outlined,
              color: Colors.green,
              size: 40,
            ),
            Text(
              'چند تا تمرین داری',
              style: TextStyle(fontSize: 20),
            )
          ],
        ),
      ),
    );
  }

  Widget lost_deadlines(BuildContext context) {
    return SizedBox(
      width: widthScr / 2,
      child: RoundedContainer(
        child: Column(
          children: [
            Icon(
              Icons.not_interested_outlined,
              color: Colors.redAccent,
              size: 40,
            ),
            Text(
              'چند تا ددلاین پرید',
              style: TextStyle(fontSize: 20),
            )
          ],
        ),
      ),
    );
  }

  Widget job(BuildContext context, String text) {
    return RoundedContainer(
      child: SizedBox(
        width: widthScr - 40,
        child: Row(
          children: [
            Padding(
              padding: const EdgeInsets.fromLTRB(5, 0, 10, 0),
              child: Icon(
                Icons.task_alt,
                color: Colors.green,
              ),
            ),
            Icon(
              Icons.do_not_disturb_on_outlined,
              color: Colors.redAccent,
            ),
            Expanded(
              child: SizedBox(),
            ),
            Text(
              text,
              style: TextStyle(fontSize: 20),
            )
          ],
        ),
      ),
    );
  }

  Widget done_assignment(BuildContext context, String text) {
    return SizedBox(
      width: widthScr / 2,
      child: RoundedContainer(
        child: Row(
          children: [
            Text(
              text,
              style: TextStyle(fontSize: 20),
            ),
            Expanded(child: SizedBox()),
            Icon(
              Icons.task_outlined,
              color: Colors.green,
              size: 30,
            )
          ],
        ),
      ),
    );
  }

  Widget line(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.all(12.0),
      child: Container(
        height: 2,
        width: widthScr - 40,
        color: Colors.grey,
      ),
    );
  }
}
