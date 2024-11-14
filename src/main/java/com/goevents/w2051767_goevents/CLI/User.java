package com.goevents.w2051767_goevents.CLI;

public class User {
    protected String name;
    protected int id;

    public User(String name, int id) {
        this.setName(name);
        this.setId(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        Validator nameValidator = new Validator();
        if(nameValidator.validateName(name)){
            this.name = name;
        }
        else{
           System.out.println("Invalid name" + name);
           System.out.println("Error");
           System.exit(0);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id>0){
            this.id = id;
        }
        else{
            //throw new IllegalArgumentException("Id can't be 0 or less than 0");
            System.out.println("Id can't be 0 or less than 0");
            System.exit(0);
        }

    }
}
