import 'package:flutter/material.dart';

import '../ali_container.dart';

class Sara extends StatelessWidget {
  late double widthScr;
  late double heightScr;
  @override
  Widget build(BuildContext context) {
    widthScr = MediaQuery.of(context).size.width;
    heightScr = MediaQuery.of(context).size.width;
    return Column(
      children: [
        Text('خلاصه', style: TextStyle(fontSize: 26),),
        summary(context),
        Text('کارهای جاری', style: TextStyle(fontSize: 26),),
        currentJobs(context),
        Text('تمرین های انجام شده', style: TextStyle(fontSize: 26),),
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
            children: [
              best_score(context),
              worst_score(context)
            ],
          ),
        ),
        Row(
          children: [
            lost_deadlines(context),
            assignments(context)
          ],
        )
      ],
    );
  }
  
  Widget currentJobs(BuildContext context) {
    return Placeholder();
  }
  
  Widget done(BuildContext context) {
    return Placeholder();
  }

  //inner widgets#########
  Widget worst_score(BuildContext context) {
    return SizedBox(
      width: widthScr/2,
      child: RoundedContainer(
        child: Column(
          children: [
            Icon(Icons.trending_down_outlined),
            Text('بدترین نمره', style: TextStyle(fontSize: 20),)
          ],
        ),
      ),
    );
  }
  
  Widget best_score(BuildContext context) {
    return SizedBox(
      width: widthScr/2,
      child: RoundedContainer(
        child: Column(
          children: [
            Icon(Icons.stars_sharp),
            Text('بهترین نمره', style: TextStyle(fontSize: 20),)
          ],
        ),
      ),
    );
  }

  Widget assignments(BuildContext context) {
    return SizedBox(
      width: widthScr/2,
      child: RoundedContainer(
        child: Column(
          children: [
            Icon(Icons.upcoming_outlined),
            Text('چند تا تمرین داری', style: TextStyle(fontSize: 20),)
          ],
        ),
      ),
    );
  }

  Widget lost_deadlines(BuildContext context) {
    return SizedBox(
      width: widthScr/2,
      child: RoundedContainer(
        child: Column(
          children: [
            Icon(Icons.not_interested_outlined),
            Text('چند تا ددلاین پرید', style: TextStyle(fontSize: 20),)
          ],
        ),
      ),
    );
  }


}


