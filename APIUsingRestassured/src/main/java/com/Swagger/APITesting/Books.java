package com.Swagger.APITesting;

public class Books {
    private int id;
    private String title;
    private String description;
    private  int packageCount;
    private String excerpt;
    private String date;

    public Books(int id ,String title,String description,int packageCount,String excerpt,String date)
    {
        this.id=id;
        this.title=title;
        this.description=description;
        this.packageCount=packageCount;
        this.excerpt=excerpt;
        this.date=date;
    }

    public void setId(int id) { this.id = id;}
    public void setTitle(String title) {this.title = title;}
    public void setDescription(String description) {this.description = description;}
    public void setPackageCount(int packageCount) {this.packageCount = packageCount;}
    public void setExcerpt(String excerpt) { this.excerpt = excerpt;}
    public void setDate(String date) { this.date = date;}

    public int getId() { return id;}
    public String getTitle() { return title;}
    public String getDescription() { return description;}
    public int getPackageCount() { return packageCount;}
    public String getExcerpt() { return excerpt;}
    public String getDate() { return date;}
}
