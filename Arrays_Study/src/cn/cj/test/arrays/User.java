package cn.cj.test.arrays;

public class User{
    private int id;
    private String name;

    public User(int id, String name){
        super();
        this.id = id;
        this.name = name;
    }

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
}
