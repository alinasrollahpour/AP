import 'dart:io';
import 'Course.dart';

class Student {
  final String name;
  String userName;
  String birthday;
  int term;
  final String studentId;
  String password;
  Map<String, double?> termCoursesId = {};
  Map<String, double> passedCoursesId = {};

  Student(this.name, this.userName, this.birthday, this.studentId, this.password)
      : term = 1;

  Student.withTerm(this.name, this.userName, this.birthday, this.studentId, this.password, this.term);

  String getName() => name;

  String getUserName() => userName;

  String getBirthday() => birthday;

  int getTerm() => term;

  Map<String, double?> getTermCoursesId() => termCoursesId;

  Map<String, double> getPassedCoursesId() => passedCoursesId;

  int getTermCoursesNumber() => termCoursesId.length;

  int getPassedCoursesNumber() => passedCoursesId.length;

  String getStudentId() => studentId;

  String getPassword() => password;

  double getTermAverage() {
    if (termCoursesId.isEmpty) return -1;

    final courses = loadCourses();
    if (courses == null) return -1;

    double sum = 0;
    int num = 0;

    for (var c in courses) {
      final score = termCoursesId[c.courseId];
      if (score != null) {
        sum += c.unit * score;
        num++;
      }
    }

    return num == 0 ? -1 : sum / num;
  }

  double getTotalAverage() {
    if (term == 1) return -1;

    final courses = loadCourses();
    if (courses == null) return -1;

    double sum = 0;

    for (var c in courses) {
      final score = passedCoursesId[c.courseId];
      if (score != null) {
        sum += c.unit * score;
      }
    }

    return passedCoursesId.isEmpty ? -1 : sum / passedCoursesId.length;
  }

  void setUserName(String userName) => this.userName = userName;

  void setBirthday(String birthday) => this.birthday = birthday;

  void setTerm(int term) => this.term = term;

  void setPassword(String password) => this.password = password;

  int getTermUnitNumber() {
    final courses = loadCourses();
    if (courses == null) return 0;

    int num = 0;

    for (var c in courses) {
      if (termCoursesId.containsKey(c.courseId)) {
        num += c.unit;
      }
    }

    return num;
  }

  int getPassedUnitNumber() {
    final courses = loadCourses();
    if (courses == null) return 0;

    int num = 0;

    for (var c in courses) {
      if (passedCoursesId.containsKey(c.courseId)) {
        num += c.unit;
      }
    }

    return num;
  }

  void printTermCourses() {
    final courses = loadCourses();
    if (courses == null) return;

    for (var c in courses) {
      if (termCoursesId.containsKey(c.courseId)) {
        print(c.name);
      }
    }
  }

  void printPassedCourses() {
    final courses = loadCourses();
    if (courses == null) return;

    for (var c in courses) {
      if (passedCoursesId.containsKey(c.courseId)) {
        print(c.name);
      }
    }
  }

  void addCourse(Course course) {
    termCoursesId[course.courseId] = null;
  }

  void addCourseById(String courseId) {
    termCoursesId[courseId] = null;
  }

  void addPassedCourse(Course course, double score) {
    passedCoursesId[course.courseId] = score;
  }

  void addPassedCourseById(String courseId, double score) {
    passedCoursesId[courseId] = score;
  }

  void deleteTermCourse(Course course) {
    termCoursesId.remove(course.courseId);
  }

  void deleteTermCourseById(String courseId) {
    termCoursesId.remove(courseId);
  }

  void deletePassedCourse(Course course) {
    passedCoursesId.remove(course.courseId);
  }

  void deletePassedCourseById(String courseId) {
    passedCoursesId.remove(courseId);
  }

  double? getScoreOfCourse(Course course) {
    return passedCoursesId[course.courseId] ?? termCoursesId[course.courseId];
  }

  double? getScoreOfCourseById(String courseId) {
    return passedCoursesId[courseId] ?? termCoursesId[courseId];
  }

  @override
  bool operator ==(Object other) {
    if (identical(this, other)) return true;
    if (other is! Student) return false;
    return studentId == other.studentId;
  }

  @override
  int get hashCode => studentId.hashCode;

  @override
  String toString() {
    return 'Student{name=$name, userName=$userName, birthday=$birthday, term=$term, '
        'studentId=$studentId, password=$password, termCoursesId=$termCoursesId, passedCoursesId=$passedCoursesId}';
  }

  List<Course>? loadCourses() {
    try {
      return DataBase.courseLoader();
    } catch (e) {
      return null;
    }
  }
}


class DataBase {
  static List<Course> courseLoader() {
    // Mock implementation
    return [];
  }
}
