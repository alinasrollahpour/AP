import 'dart:collection';
import 'Course.dart';

class Teacher {
  final String name;
  final String teacherId;
  Set<String> coursesId;

  Teacher(this.name, this.teacherId, Set<String> coursesId)
      : coursesId = HashSet<String>.from(coursesId);

  String getName() => name;

  String getTeacherId() => teacherId;

  int getCoursesNumber() => coursesId.length;

  Set<String> getCoursesId() => coursesId;

  void addCourse(Course course) {
    coursesId.add(course.courseId);
  }

  void addCourseById(String courseId) {
    coursesId.add(courseId);
  }

  void removeCourse(Course course) {
    coursesId.remove(course.courseId);
  }

  void removeCourseById(String courseId) {
    coursesId.remove(courseId);
  }

  @override
  bool operator ==(Object other) {
    if (identical(this, other)) return true;
    if (other is! Teacher) return false;
    return teacherId == other.teacherId;
  }

  @override
  int get hashCode => teacherId.hashCode;

  @override
  String toString() {
    return 'Teacher{name=$name, teacherId=$teacherId, coursesId=$coursesId}';
  }
}
