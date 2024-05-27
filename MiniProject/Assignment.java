package MiniProject;

public class Assignment
{
    private Course course;
    private String deadline;
    private boolean isActive;

    public Assignment(Course course)
    {
        this.course = course;
        this.isActive = false;
    }

    public Assignment(Course course, String deadline)
    {
        this(course);
        this.deadline = deadline;
        this.isActive = true;
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
    public boolean equals(Object obj)
    {
        if(!(obj instanceof Assignment))
        {
            return false;
        }
        Assignment assignment = (Assignment)obj;

        if(assignment.getCourse().equals(course) && assignment.getDeadline() == deadline && assignment.isActive() == isActive)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}