package MiniProject;

import java.io.Serializable;

public class Assignment implements Serializable
{
    private String assignmentId;
    private String detail;
    private final Course course;
    private String deadline;
    private boolean isActive;

    public Assignment(String assignmentId, String detail, Course course)
    {
        this.assignmentId = assignmentId;
        this.detail = detail;
        this.course = course;
        this.isActive = false;
    }

    public Assignment(String assignmentId, String detail, Course course, String deadline)
    {
        this(assignmentId, detail, course);
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

    public Course getCourse()
    {
        return course;
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
}