class Course {
  final String name;
  String? teacherId;
  final String courseId;
  final int unit;
  Set<String> studentsId = {};
  Set<String> assignmentsId = {};
  String? examDate;
  bool isActive;

  Course(this.name, this.courseId, this.unit) : isActive = false;

  Course.withDetails(this.name, this.teacherId, this.courseId, this.unit, this.examDate) : isActive = true;

  String getName() {
    return name;
  }

  String? getTeacherId() {
    return teacherId;
  }

  String getCourseId() {
    return courseId;
  }

  int getUnit() {
    return unit;
  }

  Set<String> getStudentsId() {
    return studentsId;
  }

  Set<String> getAssignmentsId() {
    return assignmentsId;
  }

  bool isActiveStatus() {
    return isActive;
  }

  String? getExamDate() {
    return examDate;
  }

  int getStudentNumber() {
    return studentsId.length;
  }

  void setExamDate(String examDate) {
    this.examDate = examDate;
  }

  void activeCourse(String teacherId, String examDate) {
    if (!isActive) {
      isActive = true;
      this.teacherId = teacherId;
      this.examDate = examDate;
    }
  }

  void inactiveCourse() {
    if (isActive) {
      isActive = false;
      teacherId = null;
      examDate = null;
      studentsId = {};
      assignmentsId = {};
    }
  }

  void addStudent(String studentId) {
    studentsId.add(studentId);
  }

  void deleteStudent(String studentId) {
    studentsId.remove(studentId);
  }

  void addAssignment(String assignmentId) {
    assignmentsId.add(assignmentId);
  }

  void deleteAssignment(String assignmentId) {
    assignmentsId.remove(assignmentId);
  }

  @override
  bool operator ==(Object other) {
    if (identical(this, other)) return true;
    if (other is! Course) return false;
    return courseId == other.courseId;
  }

  @override
  int get hashCode => courseId.hashCode;

  @override
  String toString() {
    return 'Course{name=$name, teacherId=$teacherId, courseId=$courseId, unit=$unit, '
        'studentsId=$studentsId, assignmentsId=$assignmentsId, examDate=$examDate, isActive=$isActive}';
  }
}
