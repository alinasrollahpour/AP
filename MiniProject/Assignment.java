package MiniProject;

import java.io.Serializable;

public class Assignment implements Serializable
{
    private String assignmentId;
    private String detail;
    private final String courseId;
    private String deadline;
    private boolean isActive;

    public Assignment(String assignmentId, String detail, String courseId)
    {
        this.assignmentId = assignmentId;
        this.detail = detail;
        this.courseId = courseId;
        this.isActive = false;
    }

    public Assignment(String assignmentId, String detail, String courseId, String deadline)
    {
        this(assignmentId, detail, courseId);
        this.deadline = deadline;
        this.isActive = true;
    }

    public String getAssignmentId()
    {
        return assignmentId;
    }

    public String getDetail()
    {
        return detail;
    }

    public String getCourseId()
    {
        return courseId;
    }

    public String getDeadline()
    {
        return deadline;
    }

    public boolean isActive()
    {
        return isActive;
    }

    public void setDetail(String detail)
    {
        this.detail = detail;
    }

    public void setDeadline(String deadline)
    {
        isActive = true;
        this.deadline = deadline;
    }

    public void inactive()
    {
        isActive = false;
        deadline = null;
    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o)
            return true;

        if(o == null || getClass() != o.getClass())
            return false;

        Assignment that = (Assignment) o;

        return assignmentId.equals(that.assignmentId);
    }

//    @Override
//    public String toString()
//    {
//        if(isActive)
//            return "Assignment ID: " + assignmentId + "Detail: " + detail + "Course ID: " + courseId + "Deadline: " + deadline;
//
//        else
//            return "Assignment ID: " + assignmentId + "Detail: " + detail + "Course ID: " + courseId;
//    }

    @Override
    public String toString()
    {
        if(isActive)
            return "Assignment{" + "assignmentId='" + assignmentId + '\'' + ", detail='" + detail + '\'' + ", courseId='"
                    + courseId + '\'' + ", deadline='" + deadline + '\'' + '}';
        else
            return "Assignment{" + "assignmentId='" + assignmentId + '\'' + ", detail='" + detail + '\'' + ", courseId='"
                    + courseId + '\'' + '}';
    }
}