package classwork.may12.reflection;

import classwork.may12.annotations.Doc;

@Doc(author = "me", desc = "desc")
public class User
{
    private String name_;
    private String var_;

    public User(String name, String var)
    {
        name_ = name;
        var_ = var;
    }

    private User(String var)
    {
        var_ = var;
    }
}
