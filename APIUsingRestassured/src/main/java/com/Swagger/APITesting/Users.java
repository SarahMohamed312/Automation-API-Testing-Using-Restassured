/*package com.Swagger.APITesting;

public class Users {
    private int id;
    private String user_name;
    private String password;

    public Users(int id ,String user_name,String password)
    {   this.id=id;
        this.user_name=user_name;
        this.password=password;
    }

    public Users(Users editUserInfo) {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
*/
package com.Swagger.APITesting;

public class Users {
    private int id;
    private String user_name;
    private String password;

    // كونستركتور مع معاملات
    public Users(int id, String user_name, String password) {
        this.id = id;
        this.user_name = user_name;
        this.password = password;
    }

    // كونستركتور افتراضي
    public Users() {
        this.id = 0;
        this.user_name = "";
        this.password = "";
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

   /* public void updateUserInfo(int id, String user_name, String password) {
        this.id = id;
        this.user_name = user_name;
        this.password = password;

    }*/


}
