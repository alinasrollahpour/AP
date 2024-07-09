class Assignment {
  final String assignmentId;
  String detail;
  final String courseId;
  String? deadline;
  bool isActive;

  Assignment(this.assignmentId, this.detail, this.courseId)
      : isActive = false;

  Assignment.withDeadline(this.assignmentId, this.detail, this.courseId, this.deadline)
      : isActive = true;

  String getAssignmentId() {
    return assignmentId;
  }

  String getDetail() {
    return detail;
  }

  String getCourseId() {
    return courseId;
  }

  String? getDeadline() {
    return deadline;
  }

  bool isActiveStatus() {
    return isActive;
  }

  void setDetail(String detail) {
    this.detail = detail;
  }

  void setDeadline(String deadline) {
    isActive = true;
    this.deadline = deadline;
  }

  void inactive() {
    isActive = false;
    deadline = null;
  }

  @override
  bool operator ==(Object other) {
    if (identical(this, other)) return true;
    if (other is! Assignment) return false;
    return assignmentId == other.assignmentId;
  }

  @override
  int get hashCode => assignmentId.hashCode;

  @override
  String toString() {
    if (isActive) {
      return "Assignment{assignmentId='$assignmentId', detail='$detail', courseId='$courseId', deadline='$deadline'}";
    } else {
      return "Assignment{assignmentId='$assignmentId', detail='$detail', courseId='$courseId'}";
    }
  }
}
