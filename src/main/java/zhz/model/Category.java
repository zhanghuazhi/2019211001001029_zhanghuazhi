package zhz.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Category {
    private int categoryId;
    private String categoryName;
    private String description;
    private boolean action;

    public  Category(){

    }
    public Category(int categoryId,String categoryName,String description,boolean action){
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.description = description;
        this.action = action;
    }

    public boolean isAction() {
        return action;
    }

    public void setAction(boolean action) {
        this.action = action;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", description='" + description + '\'' +
                ", action=" + action +
                '}';
    }
    public static List<Category> findAllCategory(Connection con) throws SQLException {
        String sql="select * from Category";
        List<Category> list=new ArrayList<Category>();
        PreparedStatement pt= con.prepareStatement(sql);
        ResultSet rs=pt.executeQuery();
        while (rs.next()){
            Category c=new Category();
            c.setCategoryId(rs.getInt("categoryId"));
            c.setCategoryName(rs.getString("caegoryName"));
            c.setDescription(rs.getString("description"));
            list.add(c);
        }
        return list;
    }
    public static String findByCategoryId(Connection con,int categoryId) throws SQLException{
        String sql="select * from Category where categoryId=?";
        PreparedStatement pt= con.prepareStatement(sql);
        pt.setInt(1,categoryId);
        ResultSet rs=pt.executeQuery();
        String categoryName=null;
        while (rs.next()){
            categoryName=rs.getString("categoryName");
        }
        return categoryName;
    }
}
