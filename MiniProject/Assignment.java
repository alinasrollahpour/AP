package MiniProject;

import java.util.Date;

public class Assignment
{
    private String detail;
    private final Course course;
    private Date deadline;
    private boolean isActive;

    public Assignment(String detail, Course course)
    {
        this.detail = detail;
        this.course = course;
        this.isActive = false;
    }

    public Assignment(String detail, Course course, Date deadline)
    {
        this(detail, course);
        this.deadline = deadline;
        this.isActive = true;
    }

    public String getDetail()
    {
        return detail;
    }

    public Course getCourse()
    {
        return course;
    }

    public Date getDeadline()
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

    public void setDeadline(Date deadline)
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
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Assignment that = (Assignment) o;
        return deadline == that.deadline && isActive == that.isActive && detail.equals(that.detail) && course.equals(that.course);
    }
}